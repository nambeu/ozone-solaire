package com.paperjais.ozone.service;

import org.springframework.stereotype.Service;

@Service
public class AlimentationDomestic {
	
	private final double rendement = 0.96;
	private final double facteurCorrection = 0.75;
	private final double constanceSolaire = 1;
	private final double profondeur = 0.75;
	private final double tensionSortie = 230;
   
	public AlimentationDomestic() {
	super();
}

	/* 1- Calcul de la puissance crete panneau, energieProduite = somme des energies de l'ensemble des equipements */
	public double puissanceCrete(double ensoillement, double energieProduite){
		return (energieProduite * constanceSolaire) / (ensoillement * facteurCorrection * rendement) ;
	}
	
	/* 2- Calcul de la valeur la tension du Champs Pv  */
	public long tensionChampPv(double pcp ){
		long tension;
		if(pcp > 0 && pcp <= 800){
			tension = 12 ;
		}else if(pcp > 800 && pcp <= 1200){
			tension = 24;
		} else if(pcp > 1200 && pcp <= 5000) {
			tension = 48;
		}
		else if(pcp > 5000 && pcp <= 10000){
			tension = 96;
		} else {
			tension = 220;
		}
		return tension;
	}
	
	/* 3- Calcul de la valeur du nombre de PV en serie */
	public double nombrePvSerie(long tensionChamp,double tensionPv){
		return Math.ceil(tensionChamp / tensionPv) ;
	}
	
	/* 4- Calcul de la valeur du nombre de PV en parallele */
	public double nombrePvParallele(double nombrePanneau, double nombrePvSerie){
		return Math.ceil(nombrePanneau / nombrePvSerie);
	}
      // nombre de panneaux
	public double nombrePanneau(double pcp, double pubv){
		return Math.ceil(pcp / pubv);
	}
	 // puissance utilisation pour une bonne durée de vie (pubv) : la PuissanceMaximum étant la somme des puissances des équipements
	public double puissanceUtileVie(double puissanceMax){
		return (puissanceMax * 0.97 );
	}
	
	/* 4- valeur réel des PV */
	public double nombreReelPv(double nombrePvSerie, double nombrePvParallele ){
		return Math.ceil(nombrePvSerie / nombrePvParallele) ;
	}
	
	/* 5- Capacité totale des Batteries , nbreJourAutonomie est entreé au clavier*/
	public double capaciteTotalBatterie(double energieProduite, long nbreJourAutonomie, long tensionChampPv){
		 double capacite = (energieProduite * nbreJourAutonomie) / (rendement * profondeur * tensionChampPv);
		return (((int)(capacite * 1000)) / 1000);
	}
	
	/* 6- Nombre de batterie en Serie, tensionBatterie: entrée clavier */
	 public double nombreBatterieSerie(double tensionBatterie, long tensionChampPv){
		 return Math.ceil(tensionChampPv / tensionBatterie);
	 }
	 /* 7- Nombre de Batteries en parallele, capaciteBatterie : entrée clavier */
	 public double nombreBatterieParallele(double capaciteTotalBatterie, double capaciteBatterie){
		 return Math.ceil(capaciteTotalBatterie / capaciteBatterie) ;
	 }
	 /* 8- Nombre de Batterie totale pour le site */
	 public double nombreBatterie(double nombreBatterieSerie, double nombreBatterieParallele){
		 return Math.ceil(nombreBatterieParallele * nombreBatterieSerie);
	 }
	 /*              Section Controlleur Charge ...
	  *  
	  *  Tension entree regulateur = tension du champ Batterie = Tension du champ Pv = tension entrée
	  *  
	  *  9- Intensite d'Entrée
	  */
	 public double intensiteEntree(double nombrePvParallele){
		   return nombrePvParallele * 8.79 ;
	   }
	   /* 10- Intensité de sortie */
	 public double intensiteSortie(double puissanceMax){
		return puissanceMax / tensionSortie;
	 }
	 /* 11- puissance Maximun de l'onduleur */
	 public double puissanceOnduleur(double puissanceMax){
		 return (1.5 * puissanceMax);
	 }
	 
	 /* Panneux solaires
	  * Dimensionnement du panneau ...
	  */
	 public double epaisseurCalcul(double longeur, double largeur){
		 return (longeur * largeur);
	 }
	 
	 public double surfaceChampPv(double epaisseur, double nbrePv){
		 return (epaisseur * nbrePv);
	 }
	 
	 public double surfaceDisponible(double surfaceChamps, double puissancePv, double epaisseur){
		 return ((surfaceChamps * puissancePv) / epaisseur);
	 }
}
