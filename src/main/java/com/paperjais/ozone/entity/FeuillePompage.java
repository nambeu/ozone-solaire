package com.paperjais.ozone.entity;

import org.springframework.stereotype.Service;

@Service
public class FeuillePompage {

	private Long id = (long) 1;
	private double hauteurNano;
	private double volumeEau;
	private double consommationTotal;
	private double nombrePersonne;
	private double consommationJour;
	// puissance crete panneau
	private double pcp;
	private double energieHydraulique;
	private double ensoillemenentGlobal;
	private double ensoillement;
	private double capaciteTotalBatterie;
	private double nbreJourAutonomie;
	private double tensionChamp;
	private double nombreBatterieSerie;
	// entrée clavier
	private double tensionBatterie;
	private double nombreBatterieParallele;
	private double capaciteBatterie;
	private double nombreBatterie;
	private double nombrePv;
	private double nombrePvSerie;
	private double nombrePvParallele;
	// entrée clavier
	private double tensionPv;

	public FeuillePompage() {
		super();
	}

	public FeuillePompage(double hauteurNano, double volumeEau,
			double consommationTotal, double nombrePersonne,
			double consommationJour, double pcp, double energieHydraulique,
			double ensoillemenentGlobal, double ensoillement,
			double capaciteTotalBatterie, double nbreJourAutonomie,
			double tensionChamp, double nombreBatterieSerie,
			double tensionBatterie, double nombreBatterieParallele,
			double capaciteBatterie, double nombreBatterie, double nombrePv,
			double nombrePvSerie, double nombrePvParallele, double tensionPv) {
		super();
		this.hauteurNano = hauteurNano;
		this.volumeEau = volumeEau;
		this.consommationTotal = consommationTotal;
		this.nombrePersonne = nombrePersonne;
		this.consommationJour = consommationJour;
		this.pcp = pcp;
		this.energieHydraulique = energieHydraulique;
		this.ensoillemenentGlobal = ensoillemenentGlobal;
		this.ensoillement = ensoillement;
		this.capaciteTotalBatterie = capaciteTotalBatterie;
		this.nbreJourAutonomie = nbreJourAutonomie;
		this.tensionChamp = tensionChamp;
		this.nombreBatterieSerie = nombreBatterieSerie;
		this.tensionBatterie = tensionBatterie;
		this.nombreBatterieParallele = nombreBatterieParallele;
		this.capaciteBatterie = capaciteBatterie;
		this.nombreBatterie = nombreBatterie;
		this.nombrePv = nombrePv;
		this.nombrePvSerie = nombrePvSerie;
		this.nombrePvParallele = nombrePvParallele;
		this.tensionPv = tensionPv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getHauteurNano() {
		return hauteurNano;
	}

	public void setHauteurNano(double hauteurNano) {
		this.hauteurNano = hauteurNano;
	}

	public double getVolumeEau() {
		return volumeEau;
	}

	public void setVolumeEau(double volumeEau) {
		this.volumeEau = volumeEau;
	}

	public double getConsommationTotal() {
		return consommationTotal;
	}

	public void setConsommationTotal(double consommationTotal) {
		this.consommationTotal = consommationTotal;
	}

	public double getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(double nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	public double getConsommationJour() {
		return consommationJour;
	}

	public void setConsommationJour(double consommationJour) {
		this.consommationJour = consommationJour;
	}

	public double getPcp() {
		return pcp;
	}

	public void setPcp(double pcp) {
		this.pcp = pcp;
	}

	public double getEnergieHydraulique() {
		return energieHydraulique;
	}

	public void setEnergieHydraulique(double energieHydraulique) {
		this.energieHydraulique = energieHydraulique;
	}

	public double getEnsoillemenentGlobal() {
		return ensoillemenentGlobal;
	}

	public void setEnsoillemenentGlobal(double ensoillemenentGlobal) {
		this.ensoillemenentGlobal = ensoillemenentGlobal;
	}

	public double getEnsoillement() {
		return ensoillement;
	}

	public void setEnsoillement(double ensoillement) {
		this.ensoillement = ensoillement;
	}

	public double getCapaciteTotalBatterie() {
		return capaciteTotalBatterie;
	}

	public void setCapaciteTotalBatterie(double capaciteTotalBatterie) {
		this.capaciteTotalBatterie = capaciteTotalBatterie;
	}

	public double getNbreJourAutonomie() {
		return nbreJourAutonomie;
	}

	public void setNbreJourAutonomie(double nbreJourAutonomie) {
		this.nbreJourAutonomie = nbreJourAutonomie;
	}

	public double getTensionChamp() {
		return tensionChamp;
	}

	public void setTensionChamp(double tensionChamp) {
		this.tensionChamp = tensionChamp;
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

	public double getNombreBatterieParallele() {
		return nombreBatterieParallele;
	}

	public void setNombreBatterieParallele(double nombreBatterieParallele) {
		this.nombreBatterieParallele = nombreBatterieParallele;
	}

	public double getCapaciteBatterie() {
		return capaciteBatterie;
	}

	public void setCapaciteBatterie(double capaciteBatterie) {
		this.capaciteBatterie = capaciteBatterie;
	}

	public double getNombreBatterie() {
		return nombreBatterie;
	}

	public void setNombreBatterie(double nombreBatterie) {
		this.nombreBatterie = nombreBatterie;
	}

	public double getNombrePv() {
		return nombrePv;
	}

	public void setNombrePv(double nombrePv) {
		this.nombrePv = nombrePv;
	}

	public double getNombrePvSerie() {
		return nombrePvSerie;
	}

	public void setNombrePvSerie(double nombrePvSerie) {
		this.nombrePvSerie = nombrePvSerie;
	}

	public double getNombrePvParallele() {
		return nombrePvParallele;
	}

	public void setNombrePvParallele(double nombrePvParallele) {
		this.nombrePvParallele = nombrePvParallele;
	}

	public double getTensionPv() {
		return tensionPv;
	}

	public void setTensionPv(double tensionPv) {
		this.tensionPv = tensionPv;
	}

	@Override
	public String toString() {
		return "FeuillePompage [id=" + id + ", hauteurNano=" + hauteurNano
				+ ", volumeEau=" + volumeEau + ", consommationTotal="
				+ consommationTotal + ", nombrePersonne=" + nombrePersonne
				+ ", consommationJour=" + consommationJour + ", pcp=" + pcp
				+ ", energieHydraulique=" + energieHydraulique
				+ ", ensoillemenentGlobal=" + ensoillemenentGlobal
				+ ", ensoillement=" + ensoillement + ", capaciteTotalBatterie="
				+ capaciteTotalBatterie + ", nbreJourAutonomie="
				+ nbreJourAutonomie + ", tensionChamp=" + tensionChamp
				+ ", nombreBatterieSerie=" + nombreBatterieSerie
				+ ", tensionBatterie=" + tensionBatterie
				+ ", nombreBatterieParallele=" + nombreBatterieParallele
				+ ", capaciteBatterie=" + capaciteBatterie
				+ ", nombreBatterie=" + nombreBatterie + ", nombrePv="
				+ nombrePv + ", nombrePvSerie=" + nombrePvSerie
				+ ", nombrePvParallele=" + nombrePvParallele + ", tensionPv="
				+ tensionPv + "]";
	}

}
