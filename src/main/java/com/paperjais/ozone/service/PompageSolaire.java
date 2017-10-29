package com.paperjais.ozone.service;

import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;


@Service
public class PompageSolaire {
	
	private final double rendementPompe = 0.6;
	private final double rendementConvertisseur = 0.9;
	private double rendement;
	private double profondeur;
	public PompageSolaire() {
		super();
	}
	
	// 1- energie Hydraulique	
	public double getEnergieHydraulique(double hauteurNanometrique, double volumeEau){
		double energie = (hauteurNanometrique * volumeEau * 1000 * 9.8) / 3600 ;
		return energie;
	}

	// 2- consommation totale en Eau 
	public double getConsommation(double nombrePersonne, double consommationJour){
		double consommation = nombrePersonne * consommationJour ;
		return consommation;
	}
	
	// 3- volume d'eau population
	public double getVolumeEau(double consommationTotal) {
		return consommationTotal / 1000;
	}
	
	// 4- puissance crete panneau
	public double getPcp(double energieHydraulique, double ensoillementGlobal, double ensoillementDef) {
		double pcp = (energieHydraulique * ensoillementGlobal) / (ensoillementDef * rendementPompe *rendementConvertisseur * 0.8);
		return pcp;
	}
	
	// 5- capacite total des batteries
	public double getCapaciteTotalBatterie(double energieHydraulique, double nbreJourAutonomie, double tensionChamp){
		double capacite = (energieHydraulique * nbreJourAutonomie) / (rendement * profondeur * tensionChamp);
		return capacite;
	}
	
	// 6- nombre de Batterie en serie
	public double getNombreBatterieSerie(double tensionChamp, double tensionBatterie){
		double nbreBatterieSerie = tensionChamp / tensionBatterie;
		return nbreBatterieSerie;
	}
	
	// 7- nombre de Batterie parallele
	public double getNombreBatterieParallele(double capaciteTotal, double capaciteBatterie){
		double nbreBatterieParallele = capaciteTotal / capaciteBatterie;
		return nbreBatterieParallele;
	}
	
	//8- nombre de Batterie réel
	public double getNombreBatterie(double nombreBatterieSerie, double nombreBatterieParallele){
		double nombreBatterie = nombreBatterieSerie * nombreBatterieParallele ;
		return nombreBatterie;
	}
	
	// 9- nombre de Pv
	public double getNombrePv(double nbrePvSerie, double nbrePvParallele){
		 double nombrePv = nbrePvSerie * nbrePvParallele;
		 return nombrePv;
	}
	
	// 10- nombre de Pv en serie
	public double getNombrePvSerie(double tensionChamp, double tensionPv){
		double nbrePvSerie = tensionChamp / tensionPv;
		return nbrePvSerie;
	}
	
	// 11- nombre de Pv en parallele
	public double getNombrePvParallele(){
		double nbrePvParallele = 1;
		return nbrePvParallele;
	}
}
