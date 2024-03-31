function consultarTodosLosPagos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTodosLosPagos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todos los pagos:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar todos los pagos en la interfaz de usuario
function mostrarTodosLosPagos(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una tabla para mostrar todos los pagos
    var tablaHTML = '<div class = "card green" style="width: 100rem;">';
    tablaHTML += '<table>';
    tablaHTML += '<tr><th>Número de Cliente</th><th>ID de Transacción</th><th>Fecha de Pago</th><th>Monto</th><th>Método de Pago</th></tr>';
    data.forEach(function(pago) {
        tablaHTML += '<tr>';
        tablaHTML += '<td>' + pago.customerNumber + '</td>';
        tablaHTML += '<td>' + pago.transactionId + '</td>';
        tablaHTML += '<td>' + pago.paymentDate + '</td>';
        tablaHTML += '<td>' + pago.amount + '</td>';
        tablaHTML += '<td>' + pago.paymentMethod + '</td>';
        tablaHTML += '</tr>';
    });
    tablaHTML += '</table>';
    tablaHTML += '</div>';

    // Agregar la tabla al contenedor de resultados
    resultados.innerHTML = tablaHTML;
}

function obtenerNumerosClientesUnicosEn2008() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments/unique-customers-2008',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarNumerosClientesUnicosEn2008(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los números de cliente únicos en 2008:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los números de cliente únicos en 2008 en la interfaz de usuario
function mostrarNumerosClientesUnicosEn2008(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una lista para mostrar los números de cliente únicos en 2008
    data.forEach(function(numeroCliente) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>' + numeroCliente + '</p>';
        cardHTML += '</div>';

        // Agregar el HTML al contenido existente en lugar de reemplazarlo
        resultados.innerHTML += cardHTML;
    });
}

function obtenerTodosLosPagosEn2008PorPayPal() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments/payments-2008',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTodosLosPagosEn2008PorPayPal(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todos los pagos en 2008 por PayPal:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar todos los pagos en 2008 por PayPal en la interfaz de usuario
function mostrarTodosLosPagosEn2008PorPayPal(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada pago en 2008 por PayPal y crear una tarjeta HTML para cada uno
    data.forEach(function(pago) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de Cliente: ' + pago.customerNumber + '</p>';
        cardHTML += '<p>ID de Transacción: ' + pago.transactionId + '</p>';
        cardHTML += '<p>Fecha de Pago: ' + pago.paymentDate + '</p>';
        cardHTML += '<p>Monto: ' + pago.amount + '</p>';
        cardHTML += '<p>Método de Pago: ' + pago.paymentMethod + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerTodosLosMetodosDePagoDistintos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments/payment-methods',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTodosLosMetodosDePagoDistintos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todos los métodos de pago distintos:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar todos los métodos de pago distintos en la interfaz de usuario
function mostrarTodosLosMetodosDePagoDistintos(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada método de pago distinto y mostrarlo
    data.forEach(function(metodoPago) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>' + metodoPago + '</p>';
        cardHTML += '</div>';

        // Agregar el HTML al contenido existente en lugar de reemplazarlo
        resultados.innerHTML += cardHTML;
    });
}

function obtenerPagoMedioParaAnioFijo2009() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments/average-2009',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarPagoMedioParaAnioFijo2009(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el pago medio para el año 2009:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el pago medio para el año fijo 2009 en la interfaz de usuario
function mostrarPagoMedioParaAnioFijo2009(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear un elemento de párrafo para mostrar el resultado
    
    var cardHTML = '<div class="card green" style="width: 25rem;">';
        cardHTML += '<p>' + data + '</p>';
        cardHTML += '</div>';

        // Agregar el HTML al contenido existente en lugar de reemplazarlo
        resultados.innerHTML += cardHTML;

    
}

function obtenerFechaPrimerYUltimoPagoPorCliente() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments/first-and-last-payment-dates-for-customers',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarFechaPrimerYUltimoPagoPorCliente(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener la fecha del primer y último pago por cliente:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar la fecha del primer y último pago por cliente en la interfaz de usuario
function mostrarFechaPrimerYUltimoPagoPorCliente(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada entrada de datos y crear una tarjeta HTML para cada una
    data.forEach(function(cliente) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Cliente: ' + cliente[0] + ' ' + cliente[1] + ' ' + cliente[2] + '</p>';
        cardHTML += '<p>Fecha del primer pago: ' + (cliente[3] ? cliente[3] : 'N/A') + '</p>';
        cardHTML += '<p>Fecha del último pago: ' + (cliente[4] ? cliente[4] : 'N/A') + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerSumaTotalPagosAgrupadosPorAnio() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments/total-by-year',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarSumaTotalPagosAgrupadosPorAnio(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener la suma total de los pagos agrupados por año:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar la suma total de los pagos agrupados por año en la interfaz de usuario
function mostrarSumaTotalPagosAgrupadosPorAnio(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada entrada de datos y crear una tarjeta HTML para cada una
    data.forEach(function(anio) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Año: ' + anio[0] + '</p>';
        cardHTML += '<p>Suma total de pagos: ' + anio[1] + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerNombreClientesConPagosYRepresentantes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/payments/customer-representative-city',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarClientesConPagosYRepresentantes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes con pagos y representantes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los clientes con pagos y representantes en la interfaz de usuario
function mostrarClientesConPagosYRepresentantes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada entrada de datos y crear una tarjeta HTML para cada una
    data.forEach(function(cliente) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Cliente: ' + cliente[0] + '</p>';
        cardHTML += '<p>Representante: ' + cliente[1] + ' ' + cliente[2] + '</p>';
        cardHTML += '<p>Ciudad de la oficina: ' + cliente[3] + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}
