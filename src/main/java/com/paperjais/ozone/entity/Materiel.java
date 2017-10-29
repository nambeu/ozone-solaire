package com.paperjais.ozone.entity;

import org.springframework.stereotype.Service;

@Service
public class Materiel {

	private Long id = (long) 1;
	private String designation;
	private long quantite;
	private long temps;
	private double puissance;
	private double puissanceMax;
	private double puissanceMaximun;

	public Materiel() {
		super();
	}

	public Materiel(Long id, String designation, long quantite, long temps,
			double puissance, double puissanceMax, double puissanceMaximun) {
		super();
		this.id = id;
		this.designation = designation;
		this.quantite = quantite;
		this.temps = temps;
		this.puissance = puissance;
		this.puissanceMax = puissanceMax;
		this.puissanceMaximun = puissanceMaximun;
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

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public long getTemps() {
		return temps;
	}

	public void setTemps(long temps) {
		this.temps = temps;
	}

	public double getPuissance() {
		return puissance;
	}

	public void setPuissance(double puissance) {
		this.puissance = puissance;
	}

	public double getPuissanceMax() {
		return puissanceMax;
	}

	public void setPuissanceMax(double puissanceMax) {
		this.puissanceMax = puissanceMax;
	}

	public double getPuissanceMaximun() {
		return puissanceMaximun;
	}

	public void setPuissanceMaximun(double puissanceMaximun) {
		this.puissanceMaximun = puissanceMaximun;
	}

	@Override
	public String toString() {
		return "Materiel [id=" + id + ", designation=" + designation
				+ ", quantite=" + quantite + ", temps=" + temps
				+ ", puissance=" + puissance + ", puissanceMax=" + puissanceMax
				+ ", puissanceMaximun=" + puissanceMaximun + "]";
	}

	
}
