package com.paperjais.ozone.entity;

import org.springframework.stereotype.Service;

@Service
public class Equipement {

	private Long id = (long) 1;
	private String designation;
	private String technique;
	private long quantite;
	private long prixUnitaire;
	private long montantHt;
	public Equipement(String designation, String technique, long quantite,
			long prixUnitaire, long montantHt) {
		super();
		this.designation = designation;
		this.technique = technique;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.montantHt = montantHt;
	}
	public Equipement() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getTechnique() {
		return technique;
	}
	public void setTechnique(String technique) {
		this.technique = technique;
	}
	public long getQuantite() {
		return quantite;
	}
	public void setQuantité(long quantite) {
		this.quantite = quantite;
	}
	public long getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(long prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public long getMontantHt() {
		return montantHt;
	}
	public void setMontantHt(long montantHt) {
		this.montantHt = montantHt;
	}
	@Override
	public String toString() {
		return "Equipement [id=" + id + ", designation=" + designation
				+ ", technique=" + technique + ", quantité=" + quantite
				+ ", prixUnitaire=" + prixUnitaire + ", montantHt=" + montantHt
				+ "]";
	}

	
}
