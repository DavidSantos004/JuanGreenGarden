function consultarTodasLasOficinas() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/offices',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTodasLasOficinas(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todas las oficinas:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar todas las oficinas
function mostrarTodasLasOficinas(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada oficina y crear una tarjeta HTML para cada una
    data.forEach(function(oficina) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Código de oficina: ' + oficina.officeCode + '</p>';
        cardHTML += '<p>Ciudad: ' + oficina.city + '</p>';
        cardHTML += '<p>País: ' + oficina.country + '</p>';
        cardHTML += '<p>Región: ' + oficina.region + '</p>';
        cardHTML += '<p>Código postal: ' + oficina.postalCode + '</p>';
        cardHTML += '<p>Teléfono: ' + oficina.phone + '</p>';
        cardHTML += '<p>Dirección: ' + oficina.addressLine1 + ', ' + oficina.addressLine2 + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarCodigosDeOficinaYCiudades() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/offices/office-code-and-city',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarCodigosDeOficinaYCiudades(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los códigos de oficina y ciudades:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los códigos de oficina y las ciudades
function mostrarCodigosDeOficinaYCiudades(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada objeto y crear una tarjeta HTML para cada uno
    data.forEach(function(oficina) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Código de oficina: ' + oficina.officeCode + '</p>';
        cardHTML += '<p>Ciudad: ' + oficina.officeCity + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarOficinasEnEspana() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/offices/offices-in-spain',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarOficinasEnEspana(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las oficinas en España:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las oficinas en España
function mostrarOficinasEnEspana(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada arreglo y crear una tarjeta HTML para cada uno
    data.forEach(function(oficina) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Ciudad: ' + oficina[0] + '</p>';
        cardHTML += '<p>Teléfono: ' + oficina[1] + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarDireccionesDeOficinasEnFuenlabrada() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/offices/addresses-in-fuenlabrada',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarDireccionesEnFuenlabrada(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las direcciones en Fuenlabrada:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las direcciones en Fuenlabrada
function mostrarDireccionesEnFuenlabrada(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada dirección y crear una tarjeta HTML para cada una
    data.forEach(function(direccion) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Dirección: ' + direccion + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function encontrarOficinasSinRepresentantesDeVentas() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/offices/no-sales-representatives-for-fruit-products',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarOficinasSinRepresentantesDeVentas(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las oficinas sin representantes de ventas para productos de frutas:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las oficinas sin representantes de ventas para productos de frutas
function mostrarOficinasSinRepresentantesDeVentas(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada oficina y crear una tarjeta HTML para cada una
    data.forEach(function(oficina) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Código de oficina: ' + oficina.officeCode + '</p>';
        cardHTML += '<p>Ciudad: ' + oficina.city + '</p>';
        cardHTML += '<p>País: ' + oficina.country + '</p>';
        cardHTML += '<p>Región: ' + oficina.region + '</p>';
        cardHTML += '<p>Código postal: ' + oficina.postalCode + '</p>';
        cardHTML += '<p>Teléfono: ' + oficina.phone + '</p>';
        cardHTML += '<p>Dirección: ' + oficina.addressLine1 + ', ' + oficina.addressLine2 + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}
