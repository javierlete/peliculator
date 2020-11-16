var emails = ['uno@uno.com', 'dos@dos.com'];

window.onload = function () {
    'use strict';

    var boton1 = document.getElementById('boton1');

    boton1.onclick = botonOnClick;

    document.getElementById('boton2').onclick = botonOnClick;

    document.forms[0].onsubmit = formularioBootstrap;
};

function formularioBootstrap(e) {
    e.preventDefault();

    var correcto = true;

    var email = document.getElementById('email');
    var password = document.getElementById('password');

    if (emails.includes(email.value)) {
        email.classList.remove('is-invalid');
        email.classList.add('is-valid');
    } else {
        correcto = false;
        email.classList.remove('is-valid');
        email.classList.add('is-invalid');
    }

    if(validarNif(password.value)) {
        password.classList.remove('is-invalid');
        password.classList.add('is-valid');
    } else {
        correcto = false;
        password.classList.remove('is-valid');
        password.classList.add('is-invalid');
    }

    if(correcto) {
        this.classList.add('was-validated');
        this.submit();
    }
}

function formularioAceptar(e) {
    e.preventDefault();

    var errores = [];

    var email = document.getElementById('email');

    console.log(email.value);

    if (!emails.includes(email.value)) {
        errores.push('Email');
    }

    var password = document.getElementById('password');

    if (!validarNif(password.value)) {
        errores.push('Contraseña');
    }

    if (errores.length === 0) {
        this.submit();
    } else {
        //document.getElementById('errores').innerHTML = 'Hay errores en los siguientes campos: ' + errores.join(',');

        var divErrores = document.getElementById('errores');

        if (!divErrores) {
            divErrores = document.createElement('div');

            divErrores.id = 'errores';

            divErrores.className = 'errores';

            document.forms[0].appendChild(divErrores);
        }

        //divErrores.innerHTML = 'Hay errores en los siguientes campos: ' + errores.join(',');

        divErrores.innerHTML = 'Hay errores en los siguientes campos: ';

        divErrores.innerHTML += '<ul>';

        for (error of errores) {
            divErrores.innerHTML += '<li>' + error + '</li>';
        }

        divErrores.innerHTML += '</ul>';

        console.log(divErrores);
    }

    //return false;
}

function botonOnClick() {
    var h1s = document.getElementsByTagName('h1');

    console.log(h1s);

    for (var h1 of h1s) {
        console.log(h1.innerText);

        h1.innerText = 'Cambiado';
    }

    h1.style = 'background-color: lightgray';

    this.innerText = 'Pulsado';
    this.style.display = 'none';
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
