<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action="login" method="post">
		<input type="email" name="email" placeholder="Email" value="${email}" />
		<input type="password" name="password" placeholder="Contraseña" />
		<button>Login</button>
		
		<div class="error">${error}</div>
	</form>

</body>
</html>