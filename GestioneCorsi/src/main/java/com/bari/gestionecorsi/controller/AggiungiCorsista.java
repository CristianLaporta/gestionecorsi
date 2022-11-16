package com.bari.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.bari.gestionecorsi.businesscomponent.model.Corsista;

/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/aggiungiCorsista")
public class AggiungiCorsista extends HttpServlet {
	private static final long serialVersionUID = 2157686077894055323L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Corsista corsista = getCorsista(request);
		if (corsista != null) {
			try {
				AdminFacade.getInstance().createOrUpdate(corsista);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			response.sendRedirect("admin.jsp");
		}
		
	}
	
	private Corsista getCorsista(HttpServletRequest request) {
		Corsista corsista = null;
		try {
			long id = Long.valueOf(request.getParameter("id"));
			String nome = request.getParameter("nome_corsista");
			String cognome = request.getParameter("cognome_corsista");
			String precedenti = request.getParameter("precedenti");
			corsista = new Corsista();
			corsista.setIdCorsista(id);
			corsista.setNomeCorsista(nome);
			corsista.setCognomeCorsista(cognome);
			corsista.setPrecedentiCorsista(precedenti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return corsista;
	}
	
	

}
