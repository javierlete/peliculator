<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-bordered table-hover table-sm">
	<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Título</th>
			<th>Género</th>
			<th>Fecha de estreno</th>
			<th class="text-right">Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${peliculas}" var="pelicula">
			<tr>
				<th>${pelicula.id}</th>
				<td>${pelicula.titulo}</td>
				<td>${pelicula.genero}</td>
				<td>${pelicula.fechaEstreno}</td>
				<td class="text-right"><a class="btn btn-primary"
					href="empleado.html">Editar</a> <a class="btn btn-danger"
					onclick="return confirm('¿Estás seguro?')"
					href="javascript:alert('BORRADO 1')">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
