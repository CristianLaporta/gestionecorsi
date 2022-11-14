package com.bari.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.bari.gestionecorsi.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {
	private CachedRowSet rowSet;

	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}

	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdCorso());
			rowSet.updateString(2, entity.getNomeCorso());
			rowSet.updateDate(3, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getDataFineCorso().getTime()));
			rowSet.updateDouble(5, entity.getCostoCorso());
			rowSet.updateString(6, entity.getCommentiCorso());
			rowSet.updateString(7, entity.getAulaCorso());
			rowSet.updateDouble(8, entity.getIdDocente());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSO);
			ps.setString(1, entity.getNomeCorso());
			ps.setDate(2, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			ps.setDate(3, new java.sql.Date(entity.getDataFineCorso().getTime()));
			ps.setDouble(4, entity.getCostoCorso());
			ps.setString(5, entity.getCommentiCorso());
			ps.setString(6, entity.getAulaCorso());
			ps.setLong(7, entity.getIdDocente());
			ps.setLong(8, entity.getIdCorso());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void delete(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, entity.getIdCorso());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public Corso getById(Connection conn, long id) throws DAOException {
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_BYID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				corso = new Corso();
				corso.setIdCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(rs.getDate(3));
				corso.setDataFineCorso(rs.getDate(4));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setIdDocente(rs.getLong(8));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			rs.last();
					
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corso corso = new Corso();
				corso.setIdCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(rs.getDate(3));
				corso.setDataFineCorso(rs.getDate(4));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setIdDocente(rs.getLong(8));
				corsi[i] = corso;
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}
}