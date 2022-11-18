package com.bari.gestionecorsi.businesscomponent.facade;

import java.io.IOException;
import java.util.Date;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.businesscomponent.CorsistaBC;
import com.bari.gestionecorsi.businesscomponent.CorsistaCorsoBC;
import com.bari.gestionecorsi.businesscomponent.CorsoBC;
import com.bari.gestionecorsi.businesscomponent.DocenteBC;
import com.bari.gestionecorsi.businesscomponent.model.Corsista;
import com.bari.gestionecorsi.businesscomponent.model.CorsistaCorso;
import com.bari.gestionecorsi.businesscomponent.model.Corso;
import com.bari.gestionecorsi.businesscomponent.model.Docente;

public class AdminFacade {
	private static AdminFacade aF;
	private CorsistaBC corsista;
	private CorsoBC corso;
	private DocenteBC docente; 
	private CorsistaCorsoBC corsistacorso;
	
	private AdminFacade() {}
	
	public static AdminFacade getInstance() {
		if(aF == null)
			aF = new AdminFacade();
		return aF;
	}
	
	public void createOrUpdate(Corsista c) throws ClassNotFoundException, DAOException, IOException {
		corsista = new CorsistaBC();
		corsista.createOrUpdate(c);
	}
	
	public void delete(Corsista c) throws DAOException, ClassNotFoundException, IOException {
		corsista = new CorsistaBC();
		corsista.delete(c);
	}
	
	public Corsista[] getCorsisti() throws ClassNotFoundException, DAOException, IOException {
		corsista = new CorsistaBC();
		return corsista.getAll();
	}
	
	public Corsista findById(long id) throws ClassNotFoundException, DAOException, IOException {
		corsista = new CorsistaBC();
		return corsista.getById(id);
	}
	
	public void create(Corso c) throws ClassNotFoundException, DAOException, IOException {
		corso = new CorsoBC();
		corso.create(c);
	}
	
	public void update(Corso c) throws ClassNotFoundException, DAOException, IOException {
		corso = new CorsoBC();
		corso.update(c);
	}
	
	public void delete(Corso c) throws ClassNotFoundException, DAOException, IOException {
		corso = new CorsoBC();
		corso.delete(c);
	}
	
	public Corso[] getCorsi() throws ClassNotFoundException, DAOException, IOException {
		corso = new CorsoBC();
		return corso.getCorsi();
	}
	
	public Corso getById(long id) throws ClassNotFoundException, DAOException, IOException {
		corso = new CorsoBC();
		return corso.getById(id);
	}
	
	public Date getUltimoCorso() throws ClassNotFoundException, DAOException, IOException {
		corso = new CorsoBC();
		return corso.getUltimoCorso();
	}
	
	public int getMediaCorsi() throws ClassNotFoundException, DAOException, IOException {
		corso = new CorsoBC();
		return corso.getMediaCorsi();
	}
	
	public void update(Docente d) throws ClassNotFoundException, DAOException, IOException {
		docente = new DocenteBC();
		docente.update(d);
	}
	
	public Docente[] getDocenti() throws ClassNotFoundException, DAOException, IOException {
		docente = new DocenteBC();
		return docente.getDocenti();
	}
	
	public Docente getDocenteById(long id) throws ClassNotFoundException, DAOException, IOException {
		docente = new DocenteBC();
		return docente.findById(id);
	}
	
	public void create(CorsistaCorso c) throws ClassNotFoundException, DAOException, IOException {
		corsistacorso = new CorsistaCorsoBC();
		corsistacorso.create(c);
	}
	
	public CorsistaCorso findCorsoById(long id) throws ClassNotFoundException, DAOException, IOException {
		corsistacorso = new CorsistaCorsoBC();
		return corsistacorso.getById(id);
	}
	
	public int getPostiOccupati(long id) throws DAOException, ClassNotFoundException, IOException {
		corsistacorso = new CorsistaCorsoBC();
		return corsistacorso.getPostiOccupati(id);
	}
	
	public int getCorsiFreq(long id) throws DAOException, ClassNotFoundException, IOException {
		corsistacorso = new CorsistaCorsoBC();
		return corsistacorso.getCorsiFreq(id);
	}
	
	public String CorsiMaxFreq() throws ClassNotFoundException, DAOException, IOException {
		corsistacorso = new CorsistaCorsoBC();
		return corsistacorso.getCorsiMaxFreq();
	}
}
