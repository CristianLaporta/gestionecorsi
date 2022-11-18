<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><img id="logo"
			src="assets/img/logo.png" alt=""></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span></span> <span></span> <span></span>

		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item active"><a href="inserisci.jsp">Inserisci
						Corsista</a></li>
				<li class="nav-item"><a href="admin.jsp">Visualizza
						Statistiche</a></li>
				<li class="nav-item dropdown"><a class="dropdown-toggle"
					role="button" data-bs-toggle="dropdown" href="#">Corsi</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="gestiscicorsi.jsp">Gestisci
								Corsi</a></li>
						<li><a class="dropdown-item" href="inseriscicorsi.jsp">Nuovo
								Corso</a></li>
					</ul></li>
			</ul>
			<ul class="ml-auto mb-2 mb-lg-0 flex" style="margin-right: 30px;">
				<li class="nav-item"><a aria-current="page" href="#"><i
						class="bi bi-person-circle"></i> <%=session.getAttribute("admin")%></a></li>
				<li class="nav-item"><a href="logout.jsp"><i
						class="bi bi-door-closed-fill"></i> Logout</a></li>
			</ul>
		</div>
	</div>
</nav>