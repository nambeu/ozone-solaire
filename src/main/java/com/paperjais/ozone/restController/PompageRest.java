package com.paperjais.ozone.restController;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paperjais.ozone.entity.ClientDTO;
import com.paperjais.ozone.entity.FeuillePompage;
import com.paperjais.ozone.restController.utils.HeaderUtil;

@RestController
@RequestMapping("/api/ozone/pompage")
public class PompageRest {
     
	@Autowired
	private FeuillePompage pompage;
	
	@Autowired
	private ClientDTO client1;
	
	private List<FeuillePompage> listePompage = new ArrayList<FeuillePompage>();
	
	private List<ClientDTO> listClient = new ArrayList<ClientDTO>();
	
	
	@RequestMapping(value="/besoin", method= RequestMethod.POST)
	public ResponseEntity<FeuillePompage> getBesoin(
			@RequestBody FeuillePompage feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
	//	feuille1.setLongueur(feuille.getLongueur());
	//	feuille1.setLargeur(feuille.getLargeur());
		return ResponseEntity
				.created(new URI("/ozone/api/pompage/besoin" + feuille.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille",
								feuille.getId().toString())).body(feuille);
	}
	
	@RequestMapping(value="/puissance" , method= RequestMethod.POST)
	public ResponseEntity<FeuillePompage> getPuissance(
			@RequestBody FeuillePompage feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
	//	feuille1.setLongueur(feuille.getLongueur());
	//	feuille1.setLargeur(feuille.getLargeur());
		return ResponseEntity
				.created(new URI("/ozone/api/pompage/puissance" + feuille.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille",
								feuille.getId().toString())).body(feuille);
	}
	
	@RequestMapping( value="/dimensionpanneau", method=RequestMethod.POST)
	public ResponseEntity<FeuillePompage> getSurface(
			@RequestBody FeuillePompage feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
	//	feuille1.setLongueur(feuille.getLongueur());
	//	feuille1.setLargeur(feuille.getLargeur());
		return ResponseEntity
				.created(new URI("/ozone/api/pompage/dimensionpanneau/" + feuille.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille",
								feuille.getId().toString())).body(feuille);
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public ResponseEntity<FeuillePompage> saveLocation(
			@RequestBody FeuillePompage feuille) throws URISyntaxException {
		if (feuille.getId() == null) {
			return ResponseEntity.badRequest()
					.header("failure", "a new user cannot by have that id")
					.body(null);
		}
	//	feuille1.setEnsoillement(feuille.getEnsoillement());
	//	feuille1.setNbreJourAutonomie(feuille.getNbreJourAutonomie());
	//	feuille1.setNameVille(feuille.getNameVille());

		return ResponseEntity
				.created(new URI("/ozone/api/pompage/location/" + feuille.getId()))
				.headers(
						HeaderUtil.createEntityCreationAlert("feuille",
								feuille.getId().toString())).body(feuille);
	}
	
	@RequestMapping(value="/client", method = RequestMethod.POST)
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

		System.out.println("client :" + client);
		return ResponseEntity
				.created(new URI("/ozone/api/pompage/client/" + client1.getID()))
				.headers(
						HeaderUtil.createEntityCreationAlert("client", client1
								.getID().toString())).body(client1);

	}
	
	@RequestMapping(value="/client", method= RequestMethod.GET)
	public List<ClientDTO> getClient() {
		return listClient;
	}
}
