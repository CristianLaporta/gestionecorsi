<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<title>Accesso Negato!</title>
</head>
<body>

	<nav class="navbar navbar-expand-md fixed-top navbar">
		<div class="container-fluid">
			<img id="logo" src="assets/img/logo.png" alt="">
			<div class="nav">
				<p class="link">
					<a href="login.jsp">Accedi</a><i
						class=" bi bi-arrow-right-circle-fill"></i>
				</p>
			</div>
		</div>
	</nav>

	<div class="container">
		<header class="page-header">
			<h3>Non puoi accedere a questa pagina</h3>
		</header>

		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Risorsa non disponibile</h3>
			</div>
			<div class="panel-body">
				<p>Effettuare la registrazione</p>
				<p>
					<a href="registra.jsp">Sign-up</a>
				</p>
				<p>Oppure se registrati effettuare l'accesso</p>
				<p>
					<a href="login.jsp">Login</a>
				</p>
			</div>
		</div>
	</div>

</body>

<footer>
	<p class="footerc">&copy;Copyright by Betacom, sede: Bari</p>
</footer>
</html>