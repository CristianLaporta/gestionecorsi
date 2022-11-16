<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="css/about.css">
<title>Gestione Corsi</title>
</head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="css/login.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top navbar">
			<div class="container-fluid">
				<img id="logo" src="assets/img/logo.png" alt="">
				<div class="nav">
					<p class="link">
						<a href="index.jsp">Home</a><i
							class=" bi bi-arrow-right-circle-fill"></i>
					</p>
				</div>
			</div>
		</nav>
	</header>
	<div class="gradient"></div>
	<video autoplay muted loop id="myVideo">
		<source src="assets/video/backgroundlogin.mp4" type="video/mp4">
	</video>
	<div id="login">
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form needs-validation" novalidate action="/<%=application.getServletContextName()%>/controlloLogin" method="post">
							<img class="logo" src="assets/img/logo.png" alt="">
							
							<%
								if(session.getAttribute("cont") != null){	
							%>
							<div class="control_label col-md-12 is-invalid">
								Username/password errate, tentativi restanti: <%=session.getAttribute("cont") %>
							</div>
							
						<%
								}
						%>
							
							<div class="form-group">
								<label for="username" class="text-info ara">Username:</label><br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info ara">Password:</label><br>
								<input type="password" name="password" id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<input type="submit" name="submit" class="btn btn-info btn-md"
									value="Accedi">
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>