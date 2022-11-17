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
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">First</th>
				<th scope="col">Last</th>
				<th scope="col">Handle</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<tr>
				<th scope="row">1</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Jacob</td>
				<td>Thornton</td>
				<td>@fat</td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td colspan="2">Larry the Bird</td>
				<td>@twitter</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
<%
	} else {
		response.sendRedirect("nonloggato.jsp");
		}
%>
