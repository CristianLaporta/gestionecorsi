package com.bari.gestionecorsi.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long idCorso;
	private String nomeCorso;
	private Date dataInizioCorso;
	private Date dataFineCorso;
	private double costoCorso;
	private String commentiCorso;
	private String aulaCorso;
	private long idDocente;
	
	public long getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(long idCorso) {
		this.idCorso = idCorso;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public Date getDataInizioCorso() {
		return dataInizioCorso;
	}
	public void setDataInizioCorso(Date dataInizioCorso) {
		this.dataInizioCorso = dataInizioCorso;
	}
	public Date getDataFineCorso() {
		return dataFineCorso;
	}
	public void setDataFineCorso(Date dataFineCorso) {
		this.dataFineCorso = dataFineCorso;
	}
	public double getCostoCorso() {
		return costoCorso;
	}
	public void setCostoCorso(double costoCorso) {
		this.costoCorso = costoCorso;
	}
	public String getCommentiCorso() {
		return commentiCorso;
	}
	public void setCommentiCorso(String commentiCorso) {
		this.commentiCorso = commentiCorso;
	}
	public String getAulaCorso() {
		return aulaCorso;
	}
	public void setAulaCorso(String aulaCorso) {
		this.aulaCorso = aulaCorso;
	}
	public long getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(long idDocente) {
		this.idDocente = idDocente;
	}
	
	@Override
	public String toString() {
		return "Corso [idCorso=" + idCorso + ", nomeCorso=" + nomeCorso + ", dataInizioCorso=" + dataInizioCorso
				+ ", dataFineCorso=" + dataFineCorso + ", costoCorso=" + costoCorso + ", commentiCorso=" + commentiCorso
				+ ", aulaCorso=" + aulaCorso + ", idDocente=" + idDocente + "]";
	}
}
