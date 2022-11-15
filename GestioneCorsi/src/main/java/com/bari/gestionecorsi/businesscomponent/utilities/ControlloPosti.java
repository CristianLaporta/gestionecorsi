package com.bari.gestionecorsi.businesscomponent.utilities;

import java.io.IOException;
import java.sql.SQLException;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.businesscomponent.CorsistaCorsoBC;
import com.bari.gestionecorsi.businesscomponent.CorsoBC;


public class ControlloPosti {
	
	private CorsistaCorsoBC ccBC;
	private CorsoBC cBC;
	
	
	
	public int controllaPosti(long id) throws DAOException, ClassNotFoundException, IOException {
		int posti = 0;
		
		try {
			ccBC = new CorsistaCorsoBC();
			cBC = new CorsoBC();
			int postiOccupati = ccBC.getPostiOccupati(id);
			System.out.println("posti ccBC:" + postiOccupati);
			int postiDisponibili = cBC.getPostiCorso(id);
			System.out.println("posti cBC:" + postiDisponibili);
			if ((postiDisponibili - postiOccupati) <= 0)
				posti = 0;
			else
				posti = postiDisponibili-postiOccupati;
		} catch (SQLException e) {
			throw new DAOException(e);
			
		}
		
		return posti;
	}
	
}
