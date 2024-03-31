function consultarTodosLosProductos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/productlines',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarLineasDeProducto(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener las líneas de producto:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar las líneas de producto en la interfaz de usuario
function mostrarLineasDeProducto(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre los datos recibidos para mostrar las líneas de producto
    data.forEach(function(productLine) {
        var productLineName = productLine.productLine;
        var productLineDescription = productLine.textDescription;

        var cardHTML = '<div class="card green">';
        cardHTML += '<p>Línea de Producto: ' + productLineName + '</p>';
        cardHTML += '<p>Descripción: ' + productLineDescription + '</p>';
        cardHTML += '</div>';

        // Agregar el HTML al contenido existente en lugar de reemplazarlo
        resultados.innerHTML += cardHTML;
    });
}
