package com.bari.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.bari.gestionecorsi.businesscomponent.model.Docente;


public class DocenteDAO extends GenericDAOAdapter<Docente> implements DAOConstants{
	
	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}

	private CachedRowSet rowSet;
	
	private DocenteDAO() throws DAOException {
		
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}


	@Override
	public void update(Connection conn, Docente entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_DOCENTE);
			ps.setString(1, entity.getNomeDocente());
			ps.setString(2, entity.getCognomeDocente());
			ps.setString(3, entity.getCvDocente());
			ps.setLong(4, entity.getIdDocente());
			ps.execute();
			conn.commit();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

	@Override
	public void delete(Connection conn, Docente entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_DOCENTE);
			ps.setLong(1, entity.getIdDocente());
			ps.execute();
			conn.commit();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

	@Override
	public Docente getById(Connection conn, long id) throws DAOException {
		Docente docente = null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BYID);
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				docente = new Docente();
				docente.setIdDocente(rs.getLong(1));
				docente.setNomeDocente(rs.getString(2));
				docente.setCognomeDocente(rs.getString(3));
				docente.setCvDocente(rs.getString(4));	
			}	
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return docente;
	}

	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY
					);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE);
			rs.last();
			
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Docente docente = new Docente();
				docente .setIdDocente(rs.getLong(1));
				docente .setNomeDocente(rs.getString(2));
				docente .setCognomeDocente( rs.getString(3));
				docente .setCvDocente(rs.getString(4));
				docenti[i] = docente;
			}
			
		}  catch (SQLException e) {
			throw new DAOException(e);
		}
		return docenti;
	}

}

