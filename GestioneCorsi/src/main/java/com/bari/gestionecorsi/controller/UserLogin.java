package com.bari.gestionecorsi.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static HttpSession session;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie ck[] = request.getCookies();
		if (ck != null) {
			for (int i = 0; i < ck.length; i++) {
				System.out.println("Cookies: " + ck[i].getName() + " " + ck[i].getValue());
				if (ck[i].getName().equals("userLogged") && ck[i].getValue().equals("true")) {
					System.out.println("Benvenuto: " + ck[i].getName() + " " + ck[i].getValue());
					//session.setAttribute("admin", );
					response.sendRedirect("admin.jsp");
				}
			}

		} else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}

}
