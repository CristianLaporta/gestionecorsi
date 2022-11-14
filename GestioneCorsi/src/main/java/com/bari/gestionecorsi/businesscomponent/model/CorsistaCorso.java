package com.bari.gestionecorsi.businesscomponent.model;

public class CorsistaCorso {
	private long idCorsista;
	private long idCorso;
	
	public long getIdCorsista() {
		return idCorsista;
	}
	public void setIdCorsista(long idCorsista) {
		this.idCorsista = idCorsista;
		
	}
	public long getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(long idCorso) {
		this.idCorso = idCorso;
	}
	
	@Override
	public String toString() {
		return "CorsistaCorso [idCorsista=" + idCorsista + ", idCorso=" + idCorso + "]";
	}
}
