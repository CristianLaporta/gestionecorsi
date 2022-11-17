package com.bari.gestionecorsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.bari.gestionecorsi.businesscomponent.model.Corso;


@WebServlet("/rimuoviCorso")
public class RimuoviCorso extends HttpServlet {
	private static final long serialVersionUID = -590794806177909979L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Corso c = null;
			if(id != null) 
				c = new Corso();
				c.setIdCorso(Long.valueOf(id));
				AdminFacade.getInstance().delete(c);
			response.sendRedirect("gestiscicorsi.jsp");
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}