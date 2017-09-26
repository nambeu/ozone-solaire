package com.paperjais.ozone.entity;

import org.springframework.stereotype.Service;

@Service
public class Facture {

	private Long id = (long) 1;
	private long montantTotal;
	private long taxe;
	private long montantTTC;

	public Facture(long montantTotal, long taxe, long montantTTC) {
		super();
		this.montantTotal = montantTotal;
		this.taxe = taxe;
		this.montantTTC = montantTTC;
	}

	public Facture() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(long montantTotal) {
		this.montantTotal = montantTotal;
	}

	public long getTaxe() {
		return taxe;
	}

	public void setTaxe(long taxe) {
		this.taxe = taxe;
	}

	public long getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(long montantTTC) {
		this.montantTTC = montantTTC;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", montantTotal=" + montantTotal
				+ ", taxe=" + taxe + ", montantTTC=" + montantTTC + "]";
	}

}
