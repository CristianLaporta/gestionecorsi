package com.bari.gestionecorsi.businesscomponent.model;

public class Corsista {
	private long idCorsista;
	private String nomeCorsista;
	private String cognomeCorsista;
	private String precedentiCorsista;
	
	public long getIdCorsista() {
		return idCorsista;
	}
	public void setIdCorsista(long idCorsista) {
		this.idCorsista = idCorsista;
	}
	public String getNomeCorsista() {
		return nomeCorsista;
	}
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	public String getPrecedentiCorsista() {
		return precedentiCorsista;
	}
	public void setPrecedentiCorsista(String precedentiCorsista) {
		this.precedentiCorsista = precedentiCorsista;
	}
	
	@Override
	public String toString() {
		return "Corsista [idCorsista=" + idCorsista + ", nomeCorsista=" + nomeCorsista + ", cognomeCorsista="
				+ cognomeCorsista + ", precedentiCorsista=" + precedentiCorsista + "]";
	}
}
