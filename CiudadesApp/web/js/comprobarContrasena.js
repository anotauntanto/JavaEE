
function comprobarSeguridad()
{
    //Variables true/false para saber los tipos de caracteres presentes
    var minuscula = false;
    var mayuscula = false;
    var numero = false;
    var simbolo = false;
    //Almacenar la contraseña en una variable
    var pass1 = document.getElementById('pass1');
    //Almacenar la cadena de la contraseña en una variable
    var cadena = document.getElementById('pass1').value;
    //Almacenar el objeto mensaje
    var mensaje = document.getElementById('mensaje2');
    //Establecer los colores que usaremos para el fondo de la contraseña
    var color4 = "#00ff00";
    var color3 = "#ffff00";
    var color2 = "#ff0066";
    var color1 = "#ff0000";

    //Recorrer cada caracter de la cadena
    for (i = 0; i < cadena.length; i++) {
        //Si el codigo ASCII del caracter i es el de las minusculas, pone a true el flag de minusculas
        if (cadena.charCodeAt(i) >= 97 && cadena.charCodeAt(i) <= 122) {
            minuscula = true;
            //Si el codigo ASCII del caracter i es el de las mayusculas, pone a true el flag de mayusculas
        } else if (cadena.charCodeAt(i) >= 65 && cadena.charCodeAt(i) <= 90) {
            mayuscula = true;
            //Si el codigo ASCII del caracter i es el de los numeros, pone a true el flag de numeros
        } else if (cadena.charCodeAt(i) >= 48 && cadena.charCodeAt(i) <= 57) {
            numero = true;
            //Si el codigo ASCII del caracter i no es ninguno de los anteriores, a true el flag de caracter simbolico
        } else 
            simbolo = true;
    }

    if ((simbolo === true && numero === true && minuscula === true && mayuscula === true && cadena.length > 8) || (cadena.length > 10)) {
        //La contraseña es segura
        //Cambiar el color de fondo e informar al usuario a través del objeto mensaje
        //pass1.style.backgroundColor = color4;
        mensaje.innerHTML = "Seguridad máxima";
        //mensaje.backgroundColor = color4;
        mensaje.style.color = color4;
        
    } else if ((simbolo === true && numero === true && minuscula === true && mayuscula === true && cadena.length > 6) || (cadena.length > 8)) {
        //La contraseña es aceptable
        //Cambiar el color de fondo e informar al usuario a través del objeto mensaje
        //pass1.style.backgroundColor = color3;
        mensaje.innerHTML = "Seguridad aceptable";
        mensaje.style.color = color3;
    } else {
        //La contraseña no es segura
        //Cambiar el color de fondo e informar al usuario a través del objeto mensaje
        //pass1.style.backgroundColor = color1;
        mensaje.innerHTML = "Seguridad nula";
        mensaje.style.color = color1;
    }
}

function comprobarCoinciden()
{
    //Almacenar las contraseñas en variables
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    //Almacenar el objeto mensaje
    var mensaje = document.getElementById('mensaje3');
    //Establecer los colores que usaremos para el fondo de la contraseña
    var colorBien = "#00ff00";
    var colorMal = "#ff0000";
    //Comparar los valores en los campos de contraseña y confirmación
    if (pass1.value === pass2.value) {
        //Las contraseñas coinciden. 
        //Cambiar el color de fondo e informar al usuario a través del objeto mensaje
        mensaje.style.color = colorBien;
        mensaje.innerHTML = "¡Contraseñas correctas!";
    } else {
        //Las contraseñas no coinciden. 
        //Cambiar el color de fondo e informar al usuario a través del objeto mensaje
        mensaje.style.color = colorMal;
        mensaje.innerHTML = "¡Contraseñas incorrectas!";
    }
}  