package com.bari.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.bari.gestionecorsi.businesscomponent.model.CorsistaCorso;

public class CorsistaCorsoDAO extends GenericDAOAdapter<CorsistaCorso> implements DAOConstants {
	public static CorsistaCorsoDAO getFactory() throws DAOException {
		return new CorsistaCorsoDAO();
	}

	private CachedRowSet rowSet;

	private CorsistaCorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, CorsistaCorso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTACORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdCorsista());
			rowSet.updateLong(2, entity.getIdCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public CorsistaCorso getById(Connection conn, long id) throws DAOException {
		CorsistaCorso cc = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTACORSO_BYID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cc = new CorsistaCorso();
				cc.setIdCorsista(rs.getLong(1));
				cc.setIdCorso(rs.getLong(2));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return cc;
	}
	
	public int getPostiDisponibili(Connection conn, long id) throws DAOException {
		int posti = 0;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_POSTIDISPONIBILI);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				posti = rs.getInt(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return posti;
	}

	public int getPostiOccupati(Connection conn, long id) throws DAOException {
		int postiDisponibili;
		int postiOccupati = 0;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_POSTIOCCUPATI);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				postiOccupati = rs.getInt(1);
			postiDisponibili = getPostiDisponibili(conn, id);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return postiDisponibili - postiOccupati;
	}

	public int getCorsiFreq(Connection conn, long id) throws DAOException {
		int posti = 0;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_NUMCORSI);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				posti = rs.getInt(1);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return posti;
	}

	public String corsiFreq(Connection conn) throws DAOException {
		String corsoFreq = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_FREQ);
			ResultSet rs = ps.executeQuery();
			rs.next();
			corsoFreq = rs.getString(1);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsoFreq;
	}

}
