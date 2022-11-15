package com.bari.gestionecorsi.architecture.dao;

public interface DAOConstants {
	String SELECT_ADMIN_PASS = "select password_admin from admin where username_admin= ?";

	// -----------CORSISTA--------------
	String SELECT_CORSISTA = "select * from corsista";
	String UPDATE_CORSISTA = "update corsista set nome_corsista = ? , cognome_corsista = ? , precedenti_formativi_corsista = ? where id_corsista=?";
	String DELETE_CORSISTA = "delete from corsista where id_corsista=?";
	String SELECT_CORSISTA_BYID = "select * from corsista where id_corsista = ?";

	// -----------DOCENTE--------------
	String SELECT_DOCENTE = "select * from docente";
	String UPDATE_DOCENTE = "update docente set nome_docente = ? , cognome_docente = ? , cv_docente = ? where id_docente=?";
	String DELETE_DOCENTE = "delete from docente where id_docente=?";
	String SELECT_DOCENTE_BYID = "select * from docente where id_docente = ?";

	
	// -----------CORSO--------------
	String SELECT_CORSO = "select * from corso";
	String UPDATE_CORSO = "update corso set nome_corso = ?, data_inizio_corso = ?, data_fine_corso = ? , costo_corso = ? , commenti_corso = ?, aula_corso = ?, posti_disponibili =?, id_docente = ? where id_corso=?";
	String DELETE_CORSO = "delete from corso where id_corso=?";
	String SELECT_CORSO_BYID = "select * from corso where id_corso = ?";
	String SELECT_POSTICORSO = "select posti_disponibili from corso where id_corso=?";
	
	//------CORSISTACORSO---------
	String SELECT_CORSISTACORSO= "select * from corsista_corso";
	String SELECT_POSTIOCCUPATI = "select count(id_corso) from corsista_corso where id_corso = ?";
	
	//----------SEQUENZE----------
	String SELECT_CORSISTASEQ = "select corsista_seq.nextval from dual"; // per recuperare id sequenza
	String SELECT_CORSOSEQ = "select corso_seq.nextval from dual";
	
	

}
