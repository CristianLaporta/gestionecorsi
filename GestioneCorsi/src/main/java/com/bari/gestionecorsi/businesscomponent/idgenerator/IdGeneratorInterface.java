package com.bari.gestionecorsi.businesscomponent.idgenerator;

import java.io.IOException;

import com.bari.gestionecorsi.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	
	long getNextId() throws DAOException, IOException, ClassNotFoundException;

}
