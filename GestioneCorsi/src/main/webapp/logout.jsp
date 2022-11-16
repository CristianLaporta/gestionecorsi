<%
	if(session.getAttribute("admin") != null ) {
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
%>


