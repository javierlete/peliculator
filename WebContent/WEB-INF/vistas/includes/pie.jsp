<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</main>
<footer>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-bottom">
		<a class="navbar-brand" href="#">&copy; 2020 Javier Lete</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>
</footer>

<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('table').dataTable({
			"language" : {
				"url" : "js/Spanish.json"
			}
		});
	});
</script>
<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>

<script>
	$('#fecha-estreno')[0].max = new Date().toISOString().slice(0,10);
</script>

</body>
</html>