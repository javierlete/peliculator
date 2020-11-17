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

(function () {
    'use strict';

    function ejemplosBasicos() {
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
        var arr = [5, 6, 7, 8];

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

        for (var i = 0; i < arr.length; i++) {
            console.log(arr[i]);
        }

        for (var clave in arr) {
            console.log(clave, arr[clave]);
        }

        //ES2015
        for (var dato of arr) {
            console.log(dato);
        }
    }

    function funcionesComoVariables() {
        var alerta = alert;

        console.log(typeof alerta);

        console.log(alerta);

        alerta('Hola desde ALERTA');

        var operacion = suma;

        console.log(operacion);

        console.log(operacion(5, 7));

        operacion = resta;

        console.log(operacion(5, 7));

        console.log(typeof suma);

        operacion = function (a, b) {
            alerta(a * b);
            return a * b;
        };

        console.log(operacion(5, 7));

        //ES2015
        operacion = (a, b) => a / b;

        console.log(operacion(10, 5));

        operacion = (a) => -a;

        console.log(operacion(5));

        function suma(a, b) {
            return a + b;
        }

        function resta(a, b) {
            return a - b;
        }
    }

    function objetos() {
        var persona = {};

        persona.nombre = 'Javier';
        persona.apellidos = {};
        persona.apellidos.primero = 'Lete';
        persona.apellidos.segundo = 'García';

        console.log(persona['nombre']);

        console.log(persona);

        console.log(JSON.stringify(persona));

        persona.nombreCompleto = function() {
            return this.nombre + ' ' + this.apellidos.primero + ' ' + this.apellidos.segundo;
        };

        console.log(persona.nombreCompleto());
        // var persona2 = { 
        //     nombre: prompt('Nombre'), 
        //     apellidos: { 
        //         primero: prompt('Primer apellido'), 
        //         segundo: prompt('Segundo apellido') 
        //     } 
        // };

        // console.log(persona2);

        function Persona(nombre, apellidos) {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

        Persona.prototype.nombreCompleto = function() {
            return this.nombre + ' ' + this.apellidos;
        }

        var p = new Persona('Javier', 'Lete');
        
        console.log(p.nombreCompleto());

        var p2 = new Persona('Pepe', 'Pérez');

        p2.pedorrear = function() {
            console.log('PRRRRRR');
        };

        p2.pedorrear();
    }

    objetos();

    //funcionesComoVariables();

    //arrays();

    //ejemplosBasicos();
})();

function diasMes(mes) {
    var dias;

    switch (mes) {
        case 2: dias = 28; break;
        case 4:
        case 6:
        case 9:
        case 11: dias = 30; break;
        default: dias = 31;
    }

    return dias;
}
