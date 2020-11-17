var op1, op2, op;

$(function () {
    var display = $('#display');

    var botones = $('#botones');

    for (var i = 0; i < 10; i++) {
        $('<button>')
            .addClass('btn btn-default col-4')
            .text(i)
            .click(function () {
                display.val(display.val() + $(this).text());
            }).appendTo(botones);
    }

    $('<button class="btn btn-default col-4">=</button>').click(
        function () {
            op2 = parseInt(display.val());

            switch (op) {
                case '+': display.val(op1 + op2);
                    break;
                case '-': display.val(op1 - op2);
                    break;
                case '*': display.val(op1 * op2);
                    break;
                case '/': display.val(op1 / op2);
                    break;
                default:
                    alert('OPERACIÓN NO DEFINIDA');
            }
        }

    ).appendTo(botones);

    $('<button class="btn btn-default col-4">CE</button>').click(
        function () {
            display.val('');
        }).appendTo(botones);

    var labelOperaciones = ['+', '-', '*', '/'];

    for (var i = 0; i < labelOperaciones.length; i++) {
        $('<button class="btn btn-default col-12">'
            + labelOperaciones[i] + '</button>').click(

                function () {
                    op1 = parseInt(display.val());
                    display.val('');
                    op = $(this).text();
                }).appendTo($('#operaciones'));
    }
});
