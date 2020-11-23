<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp" %>

	<h1>Preferencias</h1>
	
	<form action="preferencias" method="post">
		<select name="colores">
			<option value="light">Claros</option>
			<option value="gray">Grises</option>
			<option value="dark">Oscuros</option>
		</select>
		
		<button>Establecer colores por defecto</button>
	</form>
	
	<ul>
		<li><a href="preferencias?colores=light">Claros</a></li>
		<li><a href="preferencias?colores=gray">Grises</a></li>
		<li><a href="preferencias?colores=dark">Oscuros</a></li>
	</ul>

<%@ include file="includes/pie.jsp" %>
