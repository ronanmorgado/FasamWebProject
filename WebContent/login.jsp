<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./js/script.js"></script>
<link rel="stylesheet" type="text/css" href="./css/estiloLogin.css" />
<link rel="stylesheet" type="text/css"
	href="./css/estiloBarraSuperior.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stranger - Login</title>
</head>
<body>
	<header> <jsp:include page="barra_superior.jspf" /> </header>
	<div class="login">
		<form action="./ServletLogin" method="post">
			<fieldset>
				<label> <span>Login</span> <input type="text" name="Login"
					id="login" placeholder="Seu e-mail">
				</label> <label> <span>Senha</span> <input type="password"
					name="Senha" id="Senha" placeholder="Sua senha">
				</label> <label>
					<button>Entrar</button>
				</label>
			</fieldset>
		</form>
	</div>
</html>