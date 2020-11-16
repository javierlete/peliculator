window.onload = function () {
    var display = document.getElementById('display');
    var botones = document.getElementsByTagName('button');

    for(boton of botones) {
        boton.onclick = function () {
            display.value += this.innerText;
        };
    }
};
