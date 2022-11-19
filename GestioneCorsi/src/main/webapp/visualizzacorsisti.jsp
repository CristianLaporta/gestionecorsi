<%@page import="com.bari.gestionecorsi.businesscomponent.model.CorsistaCorso"%>
<%@page import="com.bari.gestionecorsi.businesscomponent.model.Corsista"%>
<%@page import="com.bari.gestionecorsi.businesscomponent.model.Docente"%>
<%@page import="com.bari.gestionecorsi.businesscomponent.model.Corso"%>
<%@page import="com.bari.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%
	if(session.getAttribute("admin") != null){	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- CSS only -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/admin.css">
<title>Gestione Corsi</title>
</head>
<body>
	<header>
		<jsp:include page="nav.jsp" />
	</header>
	<table class="table">
		<thead>
		
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Precedenti</th>
				<th>Corso Frequentato</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
		<%
			Corsista[] corsisti = null;
			corsisti = AdminFacade.getInstance().getCorsisti();
			for (Corsista c : corsisti) {
				CorsistaCorso cc = null;
				Corso corso = null;
				cc = AdminFacade.getInstance().findCorsoById(c.getIdCorsista());
				corso = AdminFacade.getInstance().getById(cc.getIdCorso());
		%>
			<tr>
				<th><%=c.getNomeCorsista() %></th>
				<th><%=c.getCognomeCorsista() %></th>
				<th><%=c.getPrecedentiCorsista() %></th>
				<th><%= corso.getNomeCorso()%></th>
			</tr>
		</tbody>
		<%
			}
		%>
	</table>
</body>
</html>
<%
	} else {
		response.sendRedirect("nonloggato.jsp");
	}
%>
