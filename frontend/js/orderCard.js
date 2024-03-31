function consultarTodasLasOrdenes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTodasLasOrdenes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todas las órdenes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar todas las órdenes
function mostrarTodasLasOrdenes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada orden y crear una tarjeta HTML para cada una
    data.forEach(function(orden) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de Orden: ' + orden.orderNumber + '</p>';
        cardHTML += '<p>Fecha de Orden: ' + orden.orderDate + '</p>';
        cardHTML += '<p>Fecha Requerida: ' + orden.requiredDate + '</p>';
        cardHTML += '<p>Fecha de Envío: ' + orden.shippedDate + '</p>';
        cardHTML += '<p>Estado: ' + orden.status + '</p>';
        cardHTML += '<p>Comentarios: ' + orden.comments + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerOrdenesRetrasadas() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders/delayed',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarOrdenesRetrasadas(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las órdenes retrasadas:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las órdenes retrasadas
function mostrarOrdenesRetrasadas(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada orden retrasada y crear una tarjeta HTML para cada una
    data.forEach(function(orden) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de Orden: ' + orden[0] + '</p>';
        cardHTML += '<p>Número de Productos: ' + orden[1] + '</p>';
        cardHTML += '<p>Fecha Requerida: ' + orden[2] + '</p>';
        cardHTML += '<p>Fecha de Envío: ' + orden[3] + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerOrdenesEntregadasTemprano() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders/delivered-early',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarOrdenesEntregadasTemprano(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las órdenes entregadas temprano:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las órdenes entregadas temprano
function mostrarOrdenesEntregadasTemprano(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada orden entregada temprano y crear una tarjeta HTML para cada una
    data.forEach(function(orden) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de Orden: ' + orden[0] + '</p>';
        cardHTML += '<p>Número de Productos: ' + orden[1] + '</p>';
        cardHTML += '<p>Fecha Requerida: ' + orden[2] + '</p>';
        cardHTML += '<p>Fecha de Envío: ' + orden[3] + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerOrdenesRechazadasEn2009() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders/rejected-in-2009',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarOrdenesRechazadasEn2009(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las órdenes rechazadas en 2009:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las órdenes rechazadas en 2009
function mostrarOrdenesRechazadasEn2009(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada orden rechazada en 2009 y crear una tarjeta HTML para cada una
    data.forEach(function(orden) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de Orden: ' + orden.orderNumber + '</p>';
        cardHTML += '<p>Fecha de Orden: ' + orden.orderDate + '</p>';
        cardHTML += '<p>Fecha Requerida: ' + orden.requiredDate + '</p>';
        cardHTML += '<p>Fecha de Envío: ' + (orden.shippedDate ? orden.shippedDate : 'No enviado') + '</p>';
        cardHTML += '<p>Estado: ' + orden.status + '</p>';
        cardHTML += '<p>Comentarios: ' + orden.comments + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerOrdenesEntregadasEnEnero() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders/delivered-in-january',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarOrdenesEntregadasEnEnero(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las órdenes entregadas en enero:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las órdenes entregadas en enero
function mostrarOrdenesEntregadasEnEnero(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada orden entregada en enero y crear una tarjeta HTML para cada una
    data.forEach(function(orden) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de Orden: ' + orden.orderNumber + '</p>';
        cardHTML += '<p>Fecha de Orden: ' + orden.orderDate + '</p>';
        cardHTML += '<p>Fecha Requerida: ' + orden.requiredDate + '</p>';
        cardHTML += '<p>Fecha de Envío: ' + orden.shippedDate + '</p>';
        cardHTML += '<p>Estado: ' + orden.status + '</p>';
        cardHTML += '<p>Comentarios: ' + (orden.comments ? orden.comments : 'Ninguno') + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerNombresClientesEntregaTardia() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders/late-delivery',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarNombresClientesEntregaTardia(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los nombres de clientes con entregas tardías:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los nombres de clientes con entregas tardías
function mostrarNombresClientesEntregaTardia(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada nombre de cliente con entrega tardía y crear un elemento de lista HTML para cada uno
    data.forEach(function(cliente) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">' + cliente + '</li>';
        cardHTML += '</div>';

        // Agregar el elemento de lista al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerGamasProductosCompradasPorClientes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders/product-lines-purchased',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarGamasProductosCompradasPorClientes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las gamas de productos compradas por clientes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las gamas de productos compradas por clientes
function mostrarGamasProductosCompradasPorClientes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una lista desordenada para mostrar las gamas de productos compradas por clientes
    var listaHTML = '<ul>';
    data.forEach(function(gama) {
    var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">' + gama + '</li>';
        cardHTML += '</div>';

        // Agregar el elemento de lista al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });

}

function recuperarNumeroPedidosPorEstado() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orders/status-count',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarNumeroPedidosPorEstado(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al recuperar el número de pedidos por estado:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el número de pedidos por estado
function mostrarNumeroPedidosPorEstado(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una tabla para mostrar el número de pedidos por estado
    var cardHTML = '<div class="card green">';
     cardHTML += '<table>';
    cardHTML += '<tr><th>Estado</th><th>Número de Pedidos</th></tr>';
    data.forEach(function(estado) {
        cardHTML += '<tr>';
        cardHTML += '<td>' + estado[0] + '</td>';
        cardHTML += '<td>' + estado[1] + '</td>';
        cardHTML += '</tr>';
    });
    cardHTML += '</table>';
    cardHTML += '</div>';

    // Agregar la tabla al contenedor de resultados
    resultados.innerHTML = cardHTML;
}
