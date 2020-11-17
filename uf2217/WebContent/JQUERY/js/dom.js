var emails = ['uno@uno.com', 'dos@dos.com'];

$(function () {
    'use strict';

    $('#boton1, #boton2').click(botonOnClick);

    $('form').submit(formularioAceptar); //Bootstrap);
});

function formularioBootstrap(e) {
    e.preventDefault();

    var correcto = true;

    var email = $('#email');
    var password = $('#password');

    if (emails.includes(email.val())) {
        email.removeClass('is-invalid');
        email.addClass('is-valid');
    } else {
        correcto = false;
        email.removeClass('is-valid');
        email.addClass('is-invalid');
    }

    if(validarNif(password.val())) {
        password.removeClass('is-invalid');
        password.addClass('is-valid');
    } else {
        correcto = false;
        password.removeClass('is-valid');
        password.addClass('is-invalid');
    }

    if(correcto) {
        $(this).addClass('was-validated');
        this.submit();
    }
}

function formularioAceptar(e) {
    e.preventDefault();

    var errores = [];

    var email = $('#email');

    console.log(email.val());

    if (!emails.includes(email.val())) {
        errores.push('Email');
    }

    var password = $('#password');

    if (!validarNif(password.val())) {
        errores.push('Contraseña');
    }

    if (errores.length === 0) {
        this.submit();
    } else {
        var divErrores = $('#errores');

        if (divErrores.length === 0) {
            divErrores = $('<div id="errores" class="errores">');

            // $('form').append(divErrores);

            divErrores.appendTo($('form'));
        }

        var ul = divErrores.html('Hay errores en los siguientes campos: ')
            .append('<ul>');

        $(errores).each(function() {
            ul.append('<li>' + this + '</li>');
        });

        console.log(divErrores);
    }

    //return false;
}

function botonOnClick() {
    $('h1').each(function () {
        console.log($(this).text());

        $(this).text('Cambiado');
    }).css('background-color', 'darkgray');

    $('h1:last-of-type').css('background-color', 'lightgray');

    $(this).text('Pulsado');
    $(this).css('display', 'none');
}

function validarNif(nif) {
    if (!/[a-zA-Z0-9][0-9]{7}[a-zA-Z0-9]/.test(nif)) {
        return false;
    }

    var numero = nif.substring(0, 8);
    var letra = nif[8];

    console.log(numero);
    numero = numero.replace('X', 0).replace('Y', 1).replace('Z', 2);

    console.log(numero);

    return calcularLetraNif(numero) === letra;
}

var LETRAS = 'TRWAGMYFPDXBNJZSQVHLCKE';

function calcularLetraNif(numero) {
    return LETRAS[numero % 23];
}
