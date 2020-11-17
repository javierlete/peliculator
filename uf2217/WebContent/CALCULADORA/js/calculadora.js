var op1, op2, op;

window.onload = function () {
    var display = document.getElementById('display');
    //var botones = document.getElementsByTagName('button');

    // for(boton of botones) {
    //     boton.onclick = function () {
    //         display.value += this.innerText;
    //     };
    // }

    var botones = document.getElementById('botones');
    var boton;

    for (var i = 0; i < 10; i++) {
        boton = document.createElement('button');
        boton.className = 'btn btn-default col-4';
        boton.innerText = i;

        boton.onclick = function () {
            display.value += this.innerText;
        };

        botones.appendChild(boton);
    }

    boton = document.createElement('button');
    boton.className = 'btn btn-default col-4';
    boton.innerText = '=';

    boton.onclick = function () {
        op2 = parseInt(display.value);

        switch (op) {
            case '+': display.value = op1 + op2;
                break;
            case '-': display.value = op1 - op2;
                break;
            case '*': display.value = op1 * op2;
                break;
            case '/': display.value = op1 / op2;
                break;
            default:
                alert('OPERACIÓN NO DEFINIDA');
        }
    }

    botones.appendChild(boton);

    boton = document.createElement('button');
    boton.className = 'btn btn-default col-4';
    boton.innerText = 'CE';

    boton.onclick = function () {
        display.value = '';
    };

    botones.appendChild(boton);

    var operaciones = document.getElementById('operaciones');
    var labelOperaciones = ['+', '-', '*', '/'];

    for (var i = 0; i < labelOperaciones.length; i++) {
        boton = document.createElement('button');
        boton.className = 'btn btn-default col-12';
        boton.innerText = labelOperaciones[i];

        boton.onclick = function () {
            op1 = parseInt(display.value);
            display.value = '';
            op = this.innerText;
        };

        operaciones.appendChild(boton);
    }
};
