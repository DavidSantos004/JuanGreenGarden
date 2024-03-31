function consultarTodosLosProductos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/products',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTodosLosProductos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todos los productos:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar todos los productos en la interfaz de usuario
function mostrarTodosLosProductos(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada producto y crear una tarjeta HTML para cada uno
    data.forEach(function(producto) {
        var cardHTML = '<div class="card green" style="width: 550px;">';
        cardHTML += '<p>Código de Producto: ' + producto.productCode + '</p>';
        cardHTML += '<p>Nombre: ' + producto.productName + '</p>';
        cardHTML += '<p>Escala: ' + producto.productScale + '</p>';
        cardHTML += '<p>Proveedor: ' + producto.productVendor + '</p>';
        cardHTML += '<p>Descripción: ' + producto.productDescription + '</p>';
        cardHTML += '<p>Cantidad en Stock: ' + producto.quantityInStock + '</p>';
        cardHTML += '<p>Precio de Compra: ' + producto.buyPrice + '</p>';
        cardHTML += '<p>Precio Sugerido de Venta: ' + producto.msrp + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerProductosOrnamentalesConStockMas100() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/products/products-ornamentales',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarProductosOrnamentalesConStockMas100(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener productos ornamentales con stock mayor a 100:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar productos ornamentales con stock mayor a 100 en la interfaz de usuario
function mostrarProductosOrnamentalesConStockMas100(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada producto ornamental y crear una tarjeta HTML para cada uno
    data.forEach(function(producto) {
        var cardHTML = '<div class="card green" style="width: 550px;">';
        cardHTML += '<p>Código de Producto: ' + producto.productCode + '</p>';
        cardHTML += '<p>Nombre: ' + producto.productName + '</p>';
        cardHTML += '<p>Escala: ' + producto.productScale + '</p>';
        cardHTML += '<p>Proveedor: ' + producto.productVendor + '</p>';
        cardHTML += '<p>Descripción: ' + producto.productDescription + '</p>';
        cardHTML += '<p>Cantidad en Stock: ' + producto.quantityInStock + '</p>';
        cardHTML += '<p>Precio de Compra: ' + producto.buyPrice + '</p>';
        cardHTML += '<p>Precio Sugerido de Venta: ' + producto.msrp + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerProductosNoEnOrdenes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/products/not-in-orders',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarProductosNoEnOrdenes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener productos no incluidos en órdenes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar productos no incluidos en órdenes en la interfaz de usuario
function mostrarProductosNoEnOrdenes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada producto y crear una tarjeta HTML para cada uno
    data.forEach(function(producto) {
        var cardHTML = '<div class="card green" style="width: 550px;">';
        cardHTML += '<p>Código de Producto: ' + producto.productCode + '</p>';
        cardHTML += '<p>Nombre: ' + producto.productName + '</p>';
        cardHTML += '<p>Escala: ' + producto.productScale + '</p>';
        cardHTML += '<p>Proveedor: ' + producto.productVendor + '</p>';
        cardHTML += '<p>Descripción: ' + producto.productDescription + '</p>';
        cardHTML += '<p>Cantidad en Stock: ' + producto.quantityInStock + '</p>';
        cardHTML += '<p>Precio de Compra: ' + producto.buyPrice + '</p>';
        cardHTML += '<p>Precio Sugerido de Venta: ' + producto.msrp + '</p>';
        // Agregar más detalles según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function obtenerPrecioVentaMasCaraMasBarata() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/products/precio-min-max',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarPrecioVentaMasCaraMasBarata(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el precio de venta más caro y más barato:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el precio de venta más caro y más barato en la interfaz de usuario
function mostrarPrecioVentaMasCaraMasBarata(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Mostrar el producto más caro
    var productoMasCaro = data[0];
    var cardHTMLMasCaro = '<div class="card green" style="width: 550px;">';
    cardHTMLMasCaro += '<p>Producto más caro:</p>';
    cardHTMLMasCaro += '<p>Código de Producto: ' + productoMasCaro.productCode + '</p>';
    cardHTMLMasCaro += '<p>Nombre: ' + productoMasCaro.productName + '</p>';
    cardHTMLMasCaro += '<p>Precio de Venta: ' + productoMasCaro.msrp + '</p>';
    cardHTMLMasCaro += '</div>';
    resultados.innerHTML += cardHTMLMasCaro;

    // Mostrar el producto más barato
    var productoMasBarato = data[1];
    var cardHTMLMasBarato = '<div class="card green" style="width: 550px;">';
    cardHTMLMasBarato += '<p>Producto más barato:</p>';
    cardHTMLMasBarato += '<p>Código de Producto: ' + productoMasBarato.productCode + '</p>';
    cardHTMLMasBarato += '<p>Nombre: ' + productoMasBarato.productName + '</p>';
    cardHTMLMasBarato += '<p>Precio de Venta: ' + productoMasBarato.msrp + '</p>';
    cardHTMLMasBarato += '</div>';
    resultados.innerHTML += cardHTMLMasBarato;
}


function obtenerTop20ProductosMasVendidos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/products/best-sellers',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarTop20ProductosMasVendidos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los 20 productos más vendidos:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los 20 productos más vendidos en la interfaz de usuario
function mostrarTop20ProductosMasVendidos(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre los datos recibidos para mostrar los productos más vendidos
    data.forEach(function(producto) {
        var productCode = producto[0].productCode;
        var productName = producto[0].productName;
        var quantitySold = producto[1];

        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Código de Producto: ' + productCode + '</p>';
        cardHTML += '<p>Nombre: ' + productName + '</p>';
        cardHTML += '<p>Cantidad Vendida: ' + quantitySold + '</p>';
        cardHTML += '</div>';

        // Agregar el HTML al contenido existente en lugar de reemplazarlo
        resultados.innerHTML += cardHTML;
    });
}

function encontrarProductosNoEnOrdenesConNombreDescripcionImagen() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/products/not-in-orders-name-descripcion-image',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarProductosNoEnOrdenes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los productos no presentes en ninguna orden:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

function mostrarProductosNoEnOrdenes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre los datos recibidos para mostrar los productos
    data.forEach(function(producto) {
        var cardHTML = '<div class="card green" style="width: 550px;">';
        cardHTML += '<p>Nombre: ' + producto.productName + '</p>';
        cardHTML += '<p>Descripción: ' + producto.productDescription + '</p>';
        // Agregar la imagen si está disponible
        // Asegúrate de descomentar estas líneas y proporcionar la URL correcta
        cardHTML += '<img src="https://cocktailmarketing.com.mx/wp-content/uploads/2020/05/como-configurar-shopify-2020-1024x683.jpg" style="width: 400px; height: 300px;">';
        cardHTML += '</div>';

        // Agregar el HTML al contenido existente en lugar de reemplazarlo
        resultados.innerHTML += cardHTML;
    });
}

