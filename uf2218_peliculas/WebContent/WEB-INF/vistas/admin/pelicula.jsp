<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<h1 class="col-12">Edición de película</h1>

	<div class="col-12">
		<form action="index.html" class="needs-validation" novalidate>
			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
					value="${pelicula.id}"
						readonly>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Título</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="titulo" name="titulo"
						required minlength="3" pattern="[\p{L} ]+"
						placeholder="El título de la película" value="${pelicula.titulo}">
					<div class="invalid-feedback">El título debe utilizar sólo
						letras o espacios y debe tener una longitud mínima de tres
						caracteres</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="genero" class="col-sm-2 col-form-label">Género</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="genero" name="genero" value="${pelicula.genero}">
				</div>
			</div>

			<div class="form-group row">
				<label for="fecha-estreno" class="col-sm-2 col-form-label">Fecha
					de estreno</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="fecha-estreno"
						name="fecha-estreno" value="${pelicula.fechaEstreno}">
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a class="btn btn-danger" href="admin/listado">Cancelar</a>
				</div>
			</div>
		</form>

		<script>
			// Example starter JavaScript for disabling form submissions if there are invalid fields
			(function() {
				'use strict';
				window
						.addEventListener(
								'load',
								function() {
									// Fetch all the forms we want to apply custom Bootstrap validation styles to
									var forms = document
											.getElementsByClassName('needs-validation');
									// Loop over them and prevent submission
									var validation = Array.prototype.filter
											.call(
													forms,
													function(form) {
														form
																.addEventListener(
																		'submit',
																		function(
																				event) {
																			if (form
																					.checkValidity() === false) {
																				event
																						.preventDefault();
																				event
																						.stopPropagation();
																			}
																			form.classList
																					.add('was-validated');
																		},
																		false);
													});
								}, false);
			})();
		</script>
	</div>


</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
