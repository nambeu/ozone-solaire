package com.paperjais.ozone.entity;

import org.springframework.stereotype.Service;

@Service
public class FeuilleCalcul {
    // id de test
	private final Long id = (long) 1;
	// bilan des besoins energetiques de tous les equipements
	private double energie;
	// somme des energie des appareils
	private double energieMax;
	// ensoillement : entrée clavier
	private double ensoillement;
	// tension PV : entrée pV
	private double tensionPv;
	// puissance crete panneau
	private double pcp;
	// tension champs Pv
	private long tensionChampPv;
	// nombre pv en serie
	private double nombrePvSerie;
	// nombre pv en parallèle
	private double nombrePvParallele;
	// nombre reel de pv
	private double nombreReelPv;
	// nombre de jour d'autonomie
	private long nbreJourAutonomie;
	// capacite total des batteries
	private double capaciteTotalBatterie;
	// tension batterie entrée clavier
	private double tensionBatterie;
	// capacité batterie : entrée clavier
	private double capaciteBatterie;
	// nombre de Batterie en serie
	private double nombreBatterieSerie;
    //nombre de Batterie en Parallele
	private double nombreBatterieParallele;
	// nombre de Batterie totale pour le site isolé
	private double nombreBatterie;
	// Intensite d'Entrée
    private double intensiteEntree;
    // Intensite de sortie
    private double intensiteSortie;
    // 11- puissance Maximun de l'onduleur 
    private double puissanceOnduleur;
    // puissance d'un PV
    private double puissancePv;
    // nom de la ville du site
    private String nameVille;
    // longueur et largeur du Panneau solaire
    private double longueur;
    private double largeur;
    //Epaisseur du Panneau
    private double epaisseur;
    //surface du champs Pv
    private double surfaceChamps;
    // surface disponible
    private double surfaceDisponible;
	
	public FeuilleCalcul() {
		super();
	}

	public FeuilleCalcul(double energie, double ensoillement, double tensionPv, Long id,
			double pcp, long tensionChampPv, double nombrePvSerie, double puissancePv,
			double nombreReelPv, double capaciteTotalBatterie, double puissanceOnduleur,
			double tensionBatterie, double nombrePvParallele, double nombreBatterie,double intensiteSortie,
			double nombreBatterieSerie, double energieMax,double nombreBatterieParallele, double intensiteEntree,String nameVille,
			long nbreJourAutonomie, double capaciteBatterie, double longueur, double largeur , double epaisseur , double surfaceChamps, double surfaceDisponible ) {
		super();
		this.nameVille = nameVille;
		this.energie = energie;
		this.energieMax = energieMax;
		this.ensoillement = ensoillement;
		this.tensionPv = tensionPv;
		this.pcp = pcp;
		this.tensionChampPv = tensionChampPv;
		this.nombrePvSerie = nombrePvSerie;
		this.nombrePvParallele = nombrePvParallele;
		this.nombreReelPv = nombreReelPv;
		this.nbreJourAutonomie = nbreJourAutonomie;
		this.capaciteTotalBatterie = capaciteTotalBatterie;
		this.tensionBatterie = tensionBatterie;
		this.capaciteBatterie = capaciteBatterie;
		this.nombreBatterieSerie = nombreBatterieSerie;
		this.nombreBatterieParallele = nombreBatterieParallele;
		this.nombreBatterie = nombreBatterie;
		this.intensiteEntree = intensiteEntree;
		this.intensiteSortie = intensiteSortie;
		this.puissanceOnduleur = puissanceOnduleur;
		this.puissancePv = puissancePv ;
		this.longueur = longueur;
		this.largeur = largeur;
		this.epaisseur = epaisseur;
		this.surfaceDisponible = surfaceDisponible;
		this.surfaceChamps = surfaceChamps;

	} 
	
	
     public double getSurfaceChamps() {
		return surfaceChamps;
	}

	public void setSurfaceChamps(double surfaceChamps) {
		this.surfaceChamps = surfaceChamps;
	}

	public double getSurfaceDisponible() {
		return surfaceDisponible;
	}

	public void setSurfaceDisponible(double surfaceDisponible) {
		this.surfaceDisponible = surfaceDisponible;
	}

	public double getEpaisseur() {
		return epaisseur;
	}

	public void setEpaisseur(double epaisseur) {
		this.epaisseur = epaisseur;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public String getNameVille() {
		return nameVille;
	}

	public void setNameVille(String nameVille) {
		this.nameVille = nameVille;
	}

	public double getPuissancePv() {
		return puissancePv;
	}

	public void setPuissancePv(double puissancePv) {
		this.puissancePv = puissancePv;
	}

	public Long getId(){
    	 return id;
     }
	
	public double getPuissanceOnduleur() {
		return puissanceOnduleur;
	}

	public void setPuissanceOnduleur(double puissanceOnduleur) {
		this.puissanceOnduleur = puissanceOnduleur;
	}

	public double getIntensiteSortie() {
		return intensiteSortie;
	}

	public void setIntensiteSortie(double intensiteSortie) {
		this.intensiteSortie = intensiteSortie;
	}

	public double getIntensiteEntree() {
		return intensiteEntree;
	}

	public void setIntensiteEntree(double intensiteEntree) {
		this.intensiteEntree = intensiteEntree;
	}

	public double getNombreBatterie() {
		return nombreBatterie;
	}

	public void setNombreBatterie(double nombreBatterie) {
		this.nombreBatterie = nombreBatterie;
	}

	public double getNombreBatterieParallele() {
		return nombreBatterieParallele;
	}

	public void setNombreBatterieParallele(double nombreBatterieParallele) {
		this.nombreBatterieParallele = nombreBatterieParallele;
	}

	public double getNombreBatterieSerie() {
		return nombreBatterieSerie;
	}

	public void setNombreBatterieSerie(double nombreBatterieSerie) {
		this.nombreBatterieSerie = nombreBatterieSerie;
	}

	public double getTensionBatterie() {
		return tensionBatterie;
	}

	public void setTensionBatterie(double tensionBatterie) {
		this.tensionBatterie = tensionBatterie;
	}

	public double getCapaciteBatterie() {
		return capaciteBatterie;
	}

	public void setCapaciteBatterie(double capaciteBatterie) {
		this.capaciteBatterie = capaciteBatterie;
	}

	public double getCapaciteTotalBatterie() {
		return capaciteTotalBatterie;
	}

	public void setCapaciteTotalBatterie(double capaciteTotalBatterie) {
		this.capaciteTotalBatterie = capaciteTotalBatterie;
	}

	public long getNbreJourAutonomie() {
		return nbreJourAutonomie;
	}

	public void setNbreJourAutonomie(long nbreJourAutonomie) {
		this.nbreJourAutonomie = nbreJourAutonomie;
	}

	public double getNombreReelPv() {
		return nombreReelPv;
	}

	public void setNombreReelPv(double nombreReelPv) {
		this.nombreReelPv = nombreReelPv;
	}

	public double getNombrePvParallele() {
		return nombrePvParallele;
	}

	public void setNombrePvParallele(double nombrePvParallele) {
		this.nombrePvParallele = nombrePvParallele;
	}

	public double getNombrePvSerie() {
		return nombrePvSerie;
	}

	public void setNombrePvSerie(double nombrePvSerie) {
		this.nombrePvSerie = nombrePvSerie;
	}

	public double getEnergie() {
		return energie;
	}

	public double getEnergieMax() {
		return energieMax;
	}

	public void setEnergie(double energie) {
		this.energie = energie;
	}

	public void setEnergieMax(double energieMax) {
		this.energieMax = energieMax;
	}

	public double getEnsoillement() {
		return ensoillement;
	}

	public void setEnsoillement(double ensoillement) {
		this.ensoillement = ensoillement;
	}

	public double getTensionPv() {
		return tensionPv;
	}

	public void setTensionPv(double tensionPv) {
		this.tensionPv = tensionPv;
	}

	public double getPcp() {
		return pcp;
	}

	public void setPcp(double pcp) {
		this.pcp = pcp;
	}

	public long getTensionChampPv() {
		return tensionChampPv;
	}

	public void setTensionChampPv(long tensionChampPv) {
		this.tensionChampPv = tensionChampPv;
	}

	@Override
	public String toString() {
		return "FeuilleCalcul [id=" + id + ", energie=" + energie
				+ ", energieMax=" + energieMax + ", ensoillement="
				+ ensoillement + ", tensionPv=" + tensionPv + ", pcp=" + pcp
				+ ", tensionChampPv=" + tensionChampPv + ", nombrePvSerie="
				+ nombrePvSerie + ", nombrePvParallele=" + nombrePvParallele
				+ ", nombreReelPv=" + nombreReelPv + ", nbreJourAutonomie="
				+ nbreJourAutonomie + ", capaciteTotalBatterie="
				+ capaciteTotalBatterie + ", tensionBatterie="
				+ tensionBatterie + ", capaciteBatterie=" + capaciteBatterie
				+ ", nombreBatterieSerie=" + nombreBatterieSerie
				+ ", nombreBatterieParallele=" + nombreBatterieParallele
				+ ", nombreBatterie=" + nombreBatterie + ", intensiteEntree="
				+ intensiteEntree + ", intensiteSortie=" + intensiteSortie
				+ ", puissanceOnduleur=" + puissanceOnduleur + ", puissancePv="
				+ puissancePv + ", nameVille=" + nameVille + ", longueur="
				+ longueur + ", largeur=" + largeur + ", epaisseur="
				+ epaisseur + ", surfaceChamps=" + surfaceChamps
				+ ", surfaceDisponible=" + surfaceDisponible + "]";
	}

	
	
}
