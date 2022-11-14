package com.bari.gestionecorsi.businesscomponent.model;

public class Admin {
	private long idAdmin;
	private String nomeAdmin;
	private String cognomeAdmin;
	private String username;
	private String password;
	
	public long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}
	public String getCognomeAdmin() {
		return cognomeAdmin;
	}
	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", nomeAdmin=" + nomeAdmin + ", cognomeAdmin=" + cognomeAdmin
				+ ", username=" + username + ", password=" + password + "]";
	}
}
