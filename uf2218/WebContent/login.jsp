<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp" %>

	<form action="login" method="post">
		<input type="email" name="email" placeholder="Email" value="${email}" />
		<input type="password" name="password" placeholder="Contraseña" />
		<button>Login</button>
		
		<div class="error">${error}</div>
	</form>

<%@ include file="includes/pie.jsp" %>