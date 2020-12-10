<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<h1 class="col-12">Edición de película</h1>

	<div class="col-12">
		<form action="admin/guardar" method="post" class="needs-validation" novalidate>
			<input type="hidden" name="id" value="${pelicula.id}" />
			
			<%-- <div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control ${pelicula.errorId != null ? 'is-invalid' : '' }" id="id" name="id"
						value="${pelicula.id}" readonly>
					<div class="invalid-feedback">${pelicula.errorId}</div>
				</div>
			</div> --%>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Título</label>
				<div class="col-sm-10">
					<input type="text"
						class="form-control ${pelicula.errorTitulo != null ? 'is-invalid' : '' }"
						id="titulo" name="titulo" placeholder="El título de la película"
						value="${pelicula.titulo}" minlength="3" required>
					<div class="invalid-feedback">${pelicula.errorTitulo != null ? pelicula.errorTitulo : 'El título de película es requerido y tiene que tener 3 caracteres como mínimo' }</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="genero" class="col-sm-2 col-form-label">Género</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="genero" name="genero"
						value="${pelicula.genero}">
				</div>
			</div>

			<div class="form-group row">
				<label for="fecha-estreno" class="col-sm-2 col-form-label">Fecha
					de estreno</label>
				<div class="col-sm-10">
					<input type="date"
						class="form-control ${pelicula.errorFechaEstreno != null ? 'is-invalid' : '' }"
						id="fecha-estreno" name="fecha-estreno"
						value="${pelicula.fechaEstreno}">
					<div class="invalid-feedback">${pelicula.errorFechaEstreno != null ? 'is-invalid' : 'Sólo se admiten fechas de estreno anteriores o iguales a hoy' }</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a class="btn btn-danger" href="admin/listado">Cancelar</a>
				</div>
			</div>
		</form>

	</div>


</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
