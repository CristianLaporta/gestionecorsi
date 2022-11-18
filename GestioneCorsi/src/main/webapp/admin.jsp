<%@page import="java.text.DateFormat"%>

<%@page import="com.bari.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%@page import="com.bari.gestionecorsi.businesscomponent.model.Corsista"%>
<%
	DateFormat formato = DateFormat.getDateInstance(DateFormat.LONG);
	if(session.getAttribute("admin") != null) {
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
<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top navbar">
		<div class="container-fluid">
			<img id="logo" src="assets/img/logo.png" alt="">
			<div class="nav">
				<p class="link">
					<a href="#">
						<i class="bi bi-person-circle"></i>
						 <%= session.getAttribute("admin") %>
					</a>
				</p>
				<p class="link">
					<a href="logout.jsp">Logout <i class="bi bi-door-closed-fill"></i></a>
				</p>
			</div>
			<ul class="navd">
				<li class="link">
					<a href="inserisci.jsp">Inserisci Corsista</a>
				</li>
				<li class="link">
					<a class="active" href="admin.jsp">Visualizza Statistiche</a>
				</li>
				<li class="link dropdown">
					<a class="dropdown-toggle" role="button" data-bs-toggle="dropdown" href="#">Corsi</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="gestiscicorsi.jsp">Gestisci Corsi</a></li>
						<li><a class="dropdown-item" href="inseriscicorsi.jsp">Nuovo Corso</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</header>
<body>
	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Statistiche</th>
					<th scope="col">Valore</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<%
				Corsista[] corsisti = null;
				corsisti = AdminFacade.getInstance().getCorsisti();
				%>
				<tr>

					<td>Corsisti totali</td>
					<td><%=corsisti.length%></td>
				</tr>
				<tr>

					<td>Corso più frequentato</td>
					<td><%= AdminFacade.getInstance().CorsiMaxFreq() %></td>
				</tr>
				<tr>

					<td>Inizio ultimo corso</td>
					<td><%= formato.format(AdminFacade.getInstance().getUltimoCorso()) %></td>
				</tr>

				<tr>

					<td>Durata media corsi</td>
					<td><%= AdminFacade.getInstance().getMediaCorsi() %></td>
				</tr>

				<tr>
					<td>Elenco corsisti</td>

					<td><a href="visualizzacorsisti.jsp" class="btn btn-primary">Visualizza</a>


					</td>

				</tr>


				<tr>

					<td>Corsi con posti disponibili</td>
					<td>
						<a href ="corsipostidisponibili.jsp" type="submit" class="btn btn-danger btn-sm">
							 Visualizza
						</a>
					</td>
				</tr>

			</tbody>

		</table>




	</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("nonloggato.jsp");
	}
%>
