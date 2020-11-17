$(function () {
    $('#btn-datos').click(function () {
        $.getJSON('json/datos.json', function (datos) {
            $(datos).each(function() {
                $('pre').append(this);     
            });

            $('body').append('<h1>' + datos[0] + '</h1>')
                .append('<p>' + datos[1] + '</p>')
                .append($('<input>').val(datos[2]));
        })
    });

    $('#btn-personas').click(function () {
        $.getJSON('json/personas.json', function (personas) {
            
            var persona = personas[$('#numero').val()];

            $('#nombre, #calle').val('');

            persona.nombre && $('#nombre').val(persona.nombre);
            persona.direccion && persona.direccion.calle && $('#calle').val(persona.direccion.calle);
        })
    });
});
