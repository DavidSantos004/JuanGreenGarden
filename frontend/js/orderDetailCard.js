function consultarTodosLosDetallesDeOrdenes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orderdetails',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTodosLosDetallesDeOrdenes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todos los detalles de órdenes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar todos los detalles de órdenes
function mostrarTodosLosDetallesDeOrdenes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada detalle de orden y crear una tarjeta HTML para cada uno
    data.forEach(function(detalle) {
        var cardHTML = '<div class="card  green">';
        cardHTML += '<p>Número de orden: ' + detalle.orderDetailId.orderNumber + '</p>';
        cardHTML += '<p>Número de línea de orden: ' + detalle.orderDetailId.orderLineNumber + '</p>';
        cardHTML += '<p>Cantidad ordenada: ' + detalle.quantityOrdered + '</p>';
        cardHTML += '<p>Precio unitario: ' + detalle.priceEach + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarNumeroDeProductosDiferentesEnCadaPedido() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orderdetails/count-distinct-products-in-orders',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarNumeroDeProductosDiferentesEnCadaPedido(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el número de productos diferentes en cada pedido:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el número de productos diferentes en cada pedido
function mostrarNumeroDeProductosDiferentesEnCadaPedido(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada array y crear una tarjeta HTML para cada uno
    data.forEach(function(pedido) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de pedido: ' + pedido[0] + '</p>';
        cardHTML += '<p>Número de productos diferentes: ' + pedido[1] + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarSumaCantidadTotalEnCadaPedido() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orderdetails/sum-total-quantity-in-orders',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarSumaCantidadTotalEnCadaPedido(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener la suma de la cantidad total en cada pedido:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar la suma de la cantidad total en cada pedido
function mostrarSumaCantidadTotalEnCadaPedido(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada array y crear una tarjeta HTML para cada uno
    data.forEach(function(pedido) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de pedido: ' + pedido[0] + '</p>';
        cardHTML += '<p>Suma de la cantidad total: ' + pedido[1] + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarResumenDeFacturacion() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orderdetails/billing-summary',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResumenDeFacturacion(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el resumen de facturación:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el resumen de facturación
function mostrarResumenDeFacturacion(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una tarjeta HTML para mostrar el resumen de facturación
    var cardHTML = '<div class="card green">';
    cardHTML += '<p>Base Imponible: ' + data.baseImponible + '</p>';
    cardHTML += '<p>IVA: ' + data.iva + '</p>';
    cardHTML += '<p>Total Facturado: ' + data.totalFacturado + '</p>';
    cardHTML += '</div>';

    // Agregar la tarjeta al contenedor de resultados
    resultados.innerHTML = cardHTML;
}

function consultarResumenDeFacturacionPorProducto() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orderdetails/summary-by-product',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResumenDeFacturacionPorProducto(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el resumen de facturación por producto:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el resumen de facturación por producto
function mostrarResumenDeFacturacionPorProducto(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada producto y crear una tarjeta HTML para mostrar su resumen de facturación
    Object.keys(data).forEach(function(productCode) {
        var productSummary = data[productCode];
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Código de Producto: ' + productSummary.productCode + '</p>';
        cardHTML += '<p>Base Imponible: ' + productSummary.baseImponible + '</p>';
        cardHTML += '<p>IVA: ' + productSummary.iva + '</p>';
        cardHTML += '<p>Total Facturado: ' + productSummary.totalFacturado + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarResumenDeFacturacionFiltradoPorProducto() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orderdetails/summary-by-product-filtered',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResumenDeFacturacionFiltradoPorProducto(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el resumen de facturación filtrado por producto:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el resumen de facturación filtrado por producto
function mostrarResumenDeFacturacionFiltradoPorProducto(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una tarjeta HTML para mostrar el resumen de facturación filtrado por producto
    var cardHTML = '<div class="card green">';
    cardHTML += '<p>Base Imponible: ' + data.baseImponible + '</p>';
    cardHTML += '<p>IVA: ' + data.iva + '</p>';
    cardHTML += '<p>Total Facturado: ' + data.totalFacturado + '</p>';
    cardHTML += '</div>';

    // Agregar la tarjeta al contenedor de resultados
    resultados.innerHTML += cardHTML;
}

function consultarDetallesDelPedidoConTotalMayor3000() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/orderdetails/total-sales-over-3000',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarDetallesDelPedidoConTotalMayor3000(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los detalles del pedido con total mayor a 3000 euros:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los detalles del pedido con total mayor a 3000 euros
function mostrarDetallesDelPedidoConTotalMayor3000(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada detalle del pedido y crear una tarjeta HTML para cada uno
    data.forEach(function(detalle) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Número de Pedido: ' + detalle.orderDetailId.orderNumber + '</p>';
        cardHTML += '<p>Número de Línea de Pedido: ' + detalle.orderDetailId.orderLineNumber + '</p>';
        cardHTML += '<p>Cantidad Solicitada: ' + detalle.quantityOrdered + '</p>';
        cardHTML += '<p>Precio Unitario: ' + detalle.priceEach + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}
