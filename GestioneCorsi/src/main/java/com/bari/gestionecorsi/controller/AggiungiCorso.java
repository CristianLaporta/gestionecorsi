package com.bari.gestionecorsi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.bari.gestionecorsi.businesscomponent.model.Corso;
import com.bari.gestionecorsi.businesscomponent.utilities.Validator;

@WebServlet("/aggiungiCorso")
public class AggiungiCorso extends HttpServlet {
	private static final long serialVersionUID = -4436121848615229022L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corso c = getCorso(request,response);
		try {
			AdminFacade.getInstance().create(c);
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
		response.sendRedirect("gestiscicorsi.jsp");
	}
	
	private Corso getCorso(HttpServletRequest request, HttpServletResponse response) {
		Corso c = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String nome = request.getParameter("nome");
			String dataInizio = request.getParameter("dataInizio");
			String dataFine = request.getParameter("dataFine");
			String costo = request.getParameter("costo");
			String commenti = request.getParameter("commenti");
			String aula = request.getParameter("aula");
			String idDocente = request.getParameter("idDocente");
			if (Validator.getInstance().validString(nome) == true) {
				c = new Corso();
				c.setNomeCorso(nome);
				c.setDataInizioCorso(formato.parse(dataInizio));
				c.setDataFineCorso(formato.parse(dataFine));
				c.setCostoCorso(Double.parseDouble(costo));
				c.setCommentiCorso(commenti);
				c.setAulaCorso(aula);
				c.setPostiDisponibili(12);
				c.setIdDocente(Long.valueOf(idDocente));
			} else {
				//response.sendRedirect("inseriscicorsi.jsp");
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return c;
	}
}
