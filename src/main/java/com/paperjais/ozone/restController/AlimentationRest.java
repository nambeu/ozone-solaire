package com.paperjais.ozone.restController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paperjais.ozone.entity.ClientDTO;
import com.paperjais.ozone.entity.Equipement;
import com.paperjais.ozone.entity.Facture;
import com.paperjais.ozone.entity.FeuilleCalcul;
import com.paperjais.ozone.restController.utils.HeaderUtil;
import com.paperjais.ozone.service.AlimentationDomestic;

@Configuration
@RestController
@RequestMapping(value = "/ozone/api")
public class AlimentationRest {

	@Autowired
	private AlimentationDomestic calcul;

	@Autowired
	private FeuilleCalcul feuille1;

	@Autowired
	private Facture factureService;
	
	@Autowired
	private ClientDTO client1;
	
	private List<ClientDTO> listClient = new ArrayList<ClientDTO>();

	private List<FeuilleCalcul> liste = new ArrayList<FeuilleCalcul>();

	private List<Equipement> listeEquipement = new ArrayList<Equipement>();

	private long montantTotal = 0;
	private long taxe, montantTTC;

	@Autowired
	private Equipement equipement1;

	// Les donnees entree clavier
	@RequestMapping("/feuille")
	public FeuilleCalcul getFeuilleCalcul() {
		return feuille1;
	}

	// les données sur la surface et les dimensions du panneau..
	@RequestMapping("/dimensionpanneau")
	public ResponseEntity<FeuilleCalcul> getSurface(
			@RequestBody FeuilleCalcul feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
		feuille1.setLongueur(feuille.getLongueur());
		feuille1.setLargeur(feuille.getLargeur());
		return ResponseEntity
				.created(new URI("/ozone/api/energie/" + feuille1.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille1",
								feuille1.getId().toString())).body(feuille1);
	}

	// Les données sur l'energie produite
	@RequestMapping(value = "/energie", method = RequestMethod.POST)
	public ResponseEntity<FeuilleCalcul> saveEnergie(
			@RequestBody FeuilleCalcul feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
		feuille1.setEnergie(feuille.getEnergie());
		feuille1.setEnergieMax(feuille.getEnergieMax());

		return ResponseEntity
				.created(new URI("/ozone/api/energie/" + feuille1.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille1",
								feuille1.getId().toString())).body(feuille1);
	}

	// les données sur la puissance pv et batteries
	@RequestMapping(value = "/puissance", method = RequestMethod.POST)
	public ResponseEntity<FeuilleCalcul> savePuissance(
			@RequestBody FeuilleCalcul feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
		feuille1.setTensionPv(feuille.getTensionPv());
		;
		feuille1.setPuissancePv(feuille.getPuissancePv());
		feuille1.setTensionBatterie(feuille.getTensionBatterie());
		feuille1.setCapaciteBatterie(feuille.getCapaciteBatterie());

		return ResponseEntity
				.created(new URI("/ozone/api/puissance/" + feuille1.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille1",
								feuille1.getId().toString())).body(feuille1);
	}

	// les données sur coordonnées de la ville
	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public ResponseEntity<FeuilleCalcul> saveLocation(
			@RequestBody FeuilleCalcul feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
		feuille1.setEnsoillement(feuille.getEnsoillement());
		feuille1.setNbreJourAutonomie(feuille.getNbreJourAutonomie());
		feuille1.setNameVille(feuille.getNameVille());

		return ResponseEntity
				.created(new URI("/ozone/api/location/" + feuille1.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille1",
								feuille1.getId().toString())).body(feuille1);
	}

	@RequestMapping(value = "/alimentationDomestique", method = RequestMethod.GET)
	public List<FeuilleCalcul> getPuissanceCrete() {

		// 1. Puissance Crete panneau
		double pcp = calcul.puissanceCrete(feuille1.getEnsoillement(),
				feuille1.getEnergie());
		feuille1.setPcp(pcp);

		// 2. Tension Champ Pv
		long tensionChampPv = calcul.tensionChampPv(pcp);
		feuille1.setTensionChampPv(tensionChampPv);

		// 3. Calcul de la valeur du nombre de PV en serie
		double nombrePvSerie = calcul.nombrePvSerie(tensionChampPv,
				feuille1.getTensionPv());
		feuille1.setNombrePvSerie(nombrePvSerie);

		// 4. Calcul de la valeur du nombre de PV en parallele
		double pubv = calcul.puissanceUtileVie(feuille1.getEnergieMax());
		double nombrePanneaux = calcul.nombrePanneau(pcp, pubv);
		double nombrePvParallele = calcul.nombrePvParallele(nombrePanneaux,
				nombrePvSerie);
		feuille1.setNombrePvParallele(nombrePvParallele);

		// 5. Nombre Reel de Pv
		double nombreReelPv = calcul.nombreReelPv(nombrePvSerie,
				nombrePvParallele);
		feuille1.setNombreReelPv(nombreReelPv);

		// 6. Capacité Totale des Batteries , nbreJourAutonomie est entreé au
		// clavier
		double capacitéTotalBat = calcul.capaciteTotalBatterie(
				feuille1.getEnergie(), feuille1.getNbreJourAutonomie(),
				tensionChampPv);
		feuille1.setCapaciteTotalBatterie(capacitéTotalBat);

		/* 7- Nombre de batterie en Serie, tensionBatterie: entrée clavier */
		double nbreBatterieSerie = calcul.nombreBatterieSerie(
				feuille1.getTensionBatterie(), tensionChampPv);
		feuille1.setNombreBatterieSerie(nbreBatterieSerie);

		/*
		 * 8- Nombre de Batteries en parallele, capaciteBatterie : entrée
		 * clavier
		 */
		double nbreBatterieParallele = calcul.nombreBatterieParallele(
				capacitéTotalBat, feuille1.getCapaciteBatterie());
		feuille1.setNombreBatterieParallele(nbreBatterieParallele);

		/* 9- Nombre de Batterie totale pour le site insolé */
		double nombreBatterie = calcul.nombreBatterie(nbreBatterieSerie,
				nbreBatterieParallele);
		feuille1.setNombreBatterie(nombreBatterie);

		// 10- Intensite d'Entrée
		double intensiteEntree = calcul.intensiteEntree(nombrePvParallele);
		feuille1.setIntensiteEntree(intensiteEntree);

		/* 11- Intensité de sortie */
		double intensiteSortie = calcul.intensiteSortie(feuille1
				.getEnergieMax());
		feuille1.setIntensiteSortie(intensiteSortie);

		/* 12- puissance Maximun de l'onduleur , energieMax: entree clavier */
		double puissanceOnduleur = calcul.puissanceOnduleur(feuille1
				.getEnergieMax());
		feuille1.setPuissanceOnduleur(puissanceOnduleur);

		// 13- epaisseur du panneau
		double epaisseur = calcul.epaisseurCalcul(feuille1.getLongueur(),
				feuille1.getLargeur());
		feuille1.setEpaisseur(epaisseur);

		// 14- surface du champs Pv
		double surfaceChamps = calcul.surfaceChampPv(epaisseur, nombreReelPv);
		feuille1.setSurfaceChamps(surfaceChamps);

		// 15- surface du champs disponible
		double surfaceDisponible = calcul.surfaceDisponible(surfaceChamps,
				feuille1.getPuissancePv(), epaisseur);
		feuille1.setSurfaceDisponible(surfaceDisponible);

		// ajout à la Liste de feuille de calcul ...
		liste.clear();
		liste.add(feuille1);
		System.out.println(liste);
		return liste;
	}

	// ajouter un element dans la facture
	@RequestMapping(value = "/addFactureItems", method = RequestMethod.POST)
	public ResponseEntity<Equipement> addFacture(
			@RequestBody Equipement equipement) throws URISyntaxException {
		if (equipement.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
		System.out.println(equipement);
		listeEquipement.add(equipement);

		return ResponseEntity
				.created(new URI("/addFactureItems" + equipement.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("equipement",
								equipement.getId().toString()))
				.body(equipement);
	}
	
	// recuperer la liste des equipements de la facture
	@RequestMapping(value="/addFactureItems", method=RequestMethod.GET)
	public List<Equipement> getListeEquipement(){
		return listeEquipement;
	}

	// supprimer un element de la facture
	@RequestMapping(value = "/removeFactureItems", method = RequestMethod.POST)
	public ResponseEntity<Equipement> removeFactureItems(
			@RequestBody Equipement equipement) throws URISyntaxException {
		if (equipement.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}

		for (int i = 0; i < listeEquipement.size(); i++) {
			if (listeEquipement.get(i).getDesignation()
					.equals(equipement.getDesignation())) {
				equipement1 = listeEquipement.get(i);
				System.out.println("facture11 : " + equipement1);
				listeEquipement.remove(equipement1);
			}
		}
		System.out.println("removeList: "+listeEquipement);
		return ResponseEntity
				.created(new URI("/removeFactureItems" + equipement.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("equipement",
								equipement.getId().toString()))
				.body(equipement);
	}
    
	// générer la facture en pdf 
	@RequestMapping(value = "/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InputStreamResource> generatePdf() throws IOException {

		// calcul du montant de la facture
		System.out.println(listeEquipement.size());
		System.out
				.println("montantTotal1: " + factureService.getMontantTotal());
		
		montantTotal = 0;

		if (listeEquipement.size() > 0) {
			for (int i = 0; i < listeEquipement.size(); i++) {
				montantTotal += listeEquipement.get(i).getMontantHt();
			}
		} else {
			montantTotal = 0;
		}

		taxe = (long) ((montantTotal * 19.25) / 100);
		montantTTC = taxe + montantTotal;
		System.out.println("mont" + montantTotal);
		factureService.setMontantTotal(montantTotal);
		factureService.setTaxe(taxe);
		factureService.setMontantTTC(montantTTC);
		System.out
				.println("montantTotal1: " + factureService.getMontantTotal());
		ByteArrayInputStream bis = com.paperjais.ozone.pdf.GeneratePdfReport
				.factureReport(listeEquipement, factureService, client1, feuille1);
		listeEquipement.clear();
		long reset = 0;
		factureService.setMontantTotal(reset);
		System.out
				.println("montantTotal2: " + factureService.getMontantTotal());
		factureService.setTaxe(reset);
		factureService.setMontantTTC(reset);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-disposition", "inline; filename=devis.pdf");
		return ResponseEntity.ok().headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}
	
	@RequestMapping(value="/client", method = org.springframework.web.bind.annotation.RequestMethod.POST)
//	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	public ResponseEntity<ClientDTO> addCient(@RequestBody ClientDTO client)
			throws URISyntaxException {

		if (client.getID() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}

		client1.setLastName(client.getLastName());
		client1.setFirstName(client.getFirstName());
		client1.setEmail(client.getEmail());
		client1.setAddress(client.getAddress());
		client1.setTelephone(client.getTelephone());
		listClient.clear();
		listClient.add(client);
		
		System.out.println("client :"+client);
		return ResponseEntity.created(new URI("/ozone/api/client/" + client1.getID()))
				.headers(HeaderUtil.createEntityCreationAlert("client", client1.getID().toString()))
				.body(client1);

	}

	@RequestMapping(value="/client" ,method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public List<ClientDTO> getClient() {
		return listClient;
	}
}
