<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3">
	<c:forEach items="${peliculas}" var="pelicula">
		<div class="col mb-4">
			<div class="card h-100">
				<img src="imgs-pelis/${pelicula.id}.jpg" class="card-img-top" alt="">
				<div class="card-body">
					<h5 class="card-title">${pelicula.titulo}</h5>
					<p class="card-text">${pelicula.genero.nombre}</p>


					<p class="card-text">
						<fmt:parseDate value="${pelicula.fechaEstreno}"
							pattern="yyyy-MM-dd" var="fechaEstreno" type="date" />

						<fmt:formatDate value="${fechaEstreno}" type="date"
							pattern="dd / MM / yyyy" />
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
