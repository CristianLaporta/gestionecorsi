package com.bari.gestionecorsi.businesscomponent.model;

public class Docente {
	private long idDocente;
	private String nomeDocente;
	private String cognomeDocente;
	private String cvDocente;
	
	public long getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(long idDocente) {
		this.idDocente = idDocente;
	}
	public String getNomeDocente() {
		return nomeDocente;
	}
	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}
	public String getCognomeDocente() {
		return cognomeDocente;
	}
	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}
	public String getCvDocente() {
		return cvDocente;
	}
	public void setCvDocente(String cvDocente) {
		this.cvDocente = cvDocente;
	}
	
	@Override
	public String toString() {
		return "Docente [idDocente=" + idDocente + ", nomeDocente=" + nomeDocente + ", cognomeDocente=" + cognomeDocente
				+ ", cvDocente=" + cvDocente + "]";
	}
}
