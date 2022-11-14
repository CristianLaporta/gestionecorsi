package com.bari.gestionecorsi.businesscomponent.model;

public class CorsistaCorso {
	private int idCorsista;
	private int idCorso;
	
	public int getIdCorsista() {
		return idCorsista;
	}
	public void setIdCorsista(int idCorsista) {
		this.idCorsista = idCorsista;
		
	}
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	
	@Override
	public String toString() {
		return "CorsistaCorso [idCorsista=" + idCorsista + ", idCorso=" + idCorso + "]";
	}
}
