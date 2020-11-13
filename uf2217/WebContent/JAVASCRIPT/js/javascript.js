// https://www.ecma-international.org/publications/standards/Ecma-262.htm

/*jslint devel: true */
/*eslint no-console: "off" */
/*eslint-env browser */

//console.error('error');
//console.warn('warn');
//console.log('log');
//console.info('info');
//console.trace('trace');
//console.debug('debug');
//
//alert('alert');
//console.log(confirm('confirm'));
//console.log(prompt('prompt'));


function ejemplosBasicos() {
    'use strict';

    var estaSeguro, numero;

    estaSeguro = confirm('¿Estás seguro?');
    console.log(estaSeguro);

    numero = prompt('Introduce un número');

    console.log(typeof numero);
    numero = parseInt(numero, 10);

    if (isNaN(numero)) {//numero === NaN) {
        alert('Ya te vale. La próxima vez mete un número');

        return;
    }

    if (numero === 0) {
        alert('¡Mira que guay, es cero!');
    }

    console.log(typeof numero);
    console.log(5 + numero);

    console.log(+'5');
    //console.log(!!'5');
    //console.log(!!window.console);
}

function arrays() {
    'use strict';

    var i, clave, arr = [5, 6, 7, 8];

    console.log(arr[0]);
    console.log(arr[4]);

    arr[1] = 10;

    arr[4] = 20;

    arr[5] = 'Yepa';

    arr[8] = 'Despitorreeeeeee';

    arr['Casa'] = 'Home';

    arr.Coche = 'Car';

    arr.alerta = alert;

    arr.push(new Date());

    console.log(arr);

    console.log(arr.length);

    var funcion = arr.alerta;

    funcion('Hola desde funcion');

    for (i = 0; i < arr.length; i++) {
        console.log(arr[i]);
    }

    for (clave in arr) {
        console.log(clave, arr[clave]);
    }

    //    for (var dato of arr) {
    //        console.log(dato);
    //    }
}

arrays();

//ejemplosBasicos();
