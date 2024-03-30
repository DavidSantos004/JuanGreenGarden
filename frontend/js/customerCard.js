function consultarClientes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultados(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

function mostrarResultados(data) {
    // Mostrar el contenedor de resultados
    document.getElementById('resultados').style.display = 'flex';

    // Limpiar el contenido previo en el contenedor de resultados
    document.getElementById('resultados').innerHTML = '';

    // Iterar sobre cada cliente en los datos recibidos
    data.forEach(function(cliente) {
        // Crear una tarjeta HTML para cada cliente
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + cliente.customerName + '</p>';
        cardHTML += '<p class="second-text">País: ' + cliente.country + '</p>';
        cardHTML += '<p>Contacto: ' + cliente.contactFirstName + ' ' + cliente.contactLastName + '</p>';
        cardHTML += '<p>Teléfono: ' + cliente.phone + '</p>';
        cardHTML += '<p>Dirección: ' + cliente.addressLine1 + ', ' + cliente.city + ', ' + cliente.country + '</p>';
        cardHTML += '<p>Código Postal: ' + cliente.postalCode + '</p>';
        cardHTML += '<p>Límite de Crédito: ' + cliente.creditLimit + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        document.getElementById('resultados').innerHTML += cardHTML;
    });
}


function consultarClientesEspañoles() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/spanish-customers',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultados(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes españoles:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}


function consultarClientesEnMadridConRepresentanteDeVentas() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/madrid-representatives',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesEnMadridConRepresentanteDeVentas(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes en Madrid con representantes de ventas:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Esta función puede ser reutilizada para mostrar los resultados de diferentes consultas
function mostrarResultadosClientesEnMadridConRepresentanteDeVentas(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada cliente en los datos recibidos
    data.forEach(function(cliente) {
        // Crear una tarjeta HTML para cada cliente
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + cliente.customerName + '</p>';
        cardHTML += '<p class="second-text">País: ' + cliente.country + '</p>';
        cardHTML += '<p>Contacto: ' + cliente.contactFirstName + ' ' + cliente.contactLastName + '</p>';
        cardHTML += '<p>Teléfono: ' + cliente.phone + '</p>';
        cardHTML += '<p>Dirección: ' + cliente.addressLine1 + ', ' + cliente.city + ', ' + cliente.country + '</p>';
        cardHTML += '<p>Código Postal: ' + cliente.postalCode + '</p>';
        cardHTML += '<p>Límite de Crédito: ' + cliente.creditLimit + '</p>';
        cardHTML += '<p>Representante de ventas: ' + cliente.employeeField.firstName + ' ' + cliente.employeeField.lastName1 + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarClientesConPagos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/with-payments',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesConPagos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes con pagos realizados:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Esta función puede ser reutilizada para mostrar los resultados de diferentes consultas
function mostrarResultadosClientesConPagos(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada cliente en los datos recibidos
    data.forEach(function(cliente) {
        // Crear una tarjeta HTML para cada cliente
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + cliente.customerName + '</p>';
        cardHTML += '<p class="second-text">País: ' + cliente.country + '</p>';
        cardHTML += '<p>Contacto: ' + cliente.contactFirstName + ' ' + cliente.contactLastName + '</p>';
        cardHTML += '<p>Teléfono: ' + cliente.phone + '</p>';
        cardHTML += '<p>Dirección: ' + cliente.addressLine1 + ', ' + cliente.city + ', ' + cliente.country + '</p>';
        cardHTML += '<p>Código Postal: ' + cliente.postalCode + '</p>';
        cardHTML += '<p>Límite de Crédito: ' + cliente.creditLimit + '</p>';
        // Añadir más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarClientesSinPagos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/without-payments',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesSinPagos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes sin pagos realizados:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Esta función puede ser reutilizada para mostrar los resultados de diferentes consultas
function mostrarResultadosClientesSinPagos(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada cliente en los datos recibidos
    data.forEach(function(cliente) {
        // Crear una tarjeta HTML para cada cliente
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + cliente.customerName + '</p>';
        cardHTML += '<p class="second-text">País: ' + cliente.country + '</p>';
        cardHTML += '<p>Contacto: ' + cliente.contactFirstName + ' ' + cliente.contactLastName + '</p>';
        cardHTML += '<p>Teléfono: ' + cliente.phone + '</p>';
        cardHTML += '<p>Dirección: ' + cliente.addressLine1 + ', ' + cliente.city + ', ' + cliente.country + '</p>';
        cardHTML += '<p>Código Postal: ' + cliente.postalCode + '</p>';
        cardHTML += '<p>Límite de Crédito: ' + cliente.creditLimit + '</p>';
        // Añadir más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarClientesSinPedidos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/without-orders',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesSinPedidos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes sin pedidos realizados:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Esta función puede ser reutilizada para mostrar los resultados de diferentes consultas
function mostrarResultadosClientesSinPedidos(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada cliente en los datos recibidos
    data.forEach(function(cliente) {
        // Crear una tarjeta HTML para cada cliente
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + cliente.customerName + '</p>';
        cardHTML += '<p class="second-text">País: ' + cliente.country + '</p>';
        cardHTML += '<p>Contacto: ' + cliente.contactFirstName + ' ' + cliente.contactLastName + '</p>';
        cardHTML += '<p>Teléfono: ' + cliente.phone + '</p>';
        cardHTML += '<p>Dirección: ' + cliente.addressLine1 + ', ' + cliente.city + ', ' + cliente.country + '</p>';
        cardHTML += '<p>Código Postal: ' + cliente.postalCode + '</p>';
        cardHTML += '<p>Límite de Crédito: ' + cliente.creditLimit + '</p>';
        // Añadir más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarClientesSinPedidosYPagos() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/without-orders-and-payments',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesSinPedidosYPagos(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes sin pedidos ni pagos realizados:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

function mostrarResultadosClientesSinPedidosYPagos(data) {
    // Limpiar el contenido previo en el contenedor de resultados
    var resultadosContainer = document.getElementById('resultados');
    resultadosContainer.innerHTML = '';

    // Verificar si hay resultados para mostrar
    if (data.length === 0) {
        // Mostrar un mensaje indicando que no hay resultados
        resultadosContainer.innerHTML = '<p>No se encontraron clientes sin pedidos ni pagos realizados.</p>';
        return;
    }

    // Iterar sobre cada cliente en los datos recibidos
    data.forEach(function(cliente) {
        // Crear una tarjeta HTML para cada cliente
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + cliente.customerName + '</p>';
        cardHTML += '<p class="second-text">Contacto: ' + cliente.contactFirstName + ' ' + cliente.contactLastName + '</p>';
        cardHTML += '<p>Teléfono: ' + cliente.phone + '</p>';
        cardHTML += '<p>Dirección: ' + cliente.addressLine1 + ', ' + cliente.city + ', ' + cliente.country + '</p>';
        cardHTML += '<p>Código Postal: ' + cliente.postalCode + '</p>';
        cardHTML += '<p>Límite de Crédito: ' + cliente.creditLimit + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultadosContainer.innerHTML += cardHTML;
    });

    // Mostrar el contenedor de resultados
    resultadosContainer.style.display = 'flex';
}

// Función para realizar la consulta de clientes con pedidos no pagados
function consultarClientesConPedidosNoPagados() {
    // Realizar la solicitud HTTP al servidor
    fetch('http://localhost:8080/api/customers/unpaid-orders')
        .then(function(response) {
            // Verificar si la respuesta es exitosa (código de estado 200)
            if (response.ok) {
                // Parsear la respuesta JSON
                return response.json();
            } else {
                // Mostrar un mensaje de error si la respuesta no es exitosa
                throw new Error('Error al obtener los datos de clientes con pedidos no pagados.');
            }
        })
        .then(function(data) {
            // Mostrar los resultados obtenidos
            mostrarResultadosClientesConPedidosNoPagados(data);
        })
        .catch(function(error) {
            // Capturar y mostrar cualquier error que ocurra durante la solicitud
            console.error('Error:', error);
        });
}

// Función para mostrar los resultados de la consulta
function mostrarResultadosClientesConPedidosNoPagados(data) {
    // Limpiar el contenido previo en el contenedor de resultados
    var resultadosContainer = document.getElementById('resultados');
    resultadosContainer.innerHTML = '';

    // Verificar si hay resultados para mostrar
    if (data.length === 0) {
        // Mostrar un mensaje indicando que no hay resultados
        resultadosContainer.innerHTML = '<p>No se encontraron clientes con pedidos no pagados.</p>';
        return;
    }

    // Iterar sobre cada cliente en los datos recibidos
    data.forEach(function(cliente) {
        // Crear una tarjeta HTML para cada cliente
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + cliente.customerName + '</p>';
        cardHTML += '<p class="second-text">País: ' + cliente.country + '</p>';
        cardHTML += '<p>Contacto: ' + cliente.contactFirstName + ' ' + cliente.contactLastName + '</p>';
        cardHTML += '<p>Teléfono: ' + cliente.phone + '</p>';
        cardHTML += '<p>Dirección: ' + cliente.addressLine1 + ', ' + cliente.city + ', ' + cliente.country + '</p>';
        cardHTML += '<p>Código Postal: ' + cliente.postalCode + '</p>';
        cardHTML += '<p>Límite de Crédito: ' + cliente.creditLimit + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultadosContainer.innerHTML += cardHTML;
    });

    // Mostrar el contenedor de resultados
    resultadosContainer.style.display = 'flex';
}

function consultarClientesConPedidosNoPagados() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/unpaid-orders',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesConPedidosNoPagados(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes con pedidos no pagados:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

function consultarCantidadClientesPorPais() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/count-by-country',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosCantidadClientesPorPais(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener la cantidad de clientes por país:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados de la cantidad de clientes por país
function mostrarResultadosCantidadClientesPorPais(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    

    // Iterar sobre cada arreglo de objeto en los datos recibidos
    data.forEach(function(item) {
        // Crear una tarjeta HTML para cada país y cantidad de clientes
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">País: ' + item[0] + '</p>';
        cardHTML += '<p class="second-text">Clientes: ' + item[1] + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de tarjetas
        resultados.innerHTML += cardHTML;
    });
}

function consultarNumeroTotalClientes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/count-customers',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadoNumeroTotalClientes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el número total de clientes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el resultado del número total de clientes
function mostrarResultadoNumeroTotalClientes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una tarjeta HTML para mostrar el número total de clientes
    var cardHTML = '<div class="card green">';
    cardHTML += '<p class="tip">Número Total de Clientes: ' + data + '</p>';
    cardHTML += '</div>';

    // Agregar la tarjeta al contenedor de resultados
    resultados.innerHTML += cardHTML;
}

function consultarNumeroClientesEnMadrid() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/count-customers-madrid',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadoNumeroClientesEnMadrid(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el número de clientes en Madrid:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar el resultado del número de clientes en Madrid
function mostrarResultadoNumeroClientesEnMadrid(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una tarjeta HTML para mostrar el número de clientes en Madrid
    var cardHTML = '<div class="card green">';
    cardHTML += '<p class="tip">Número de Clientes en Madrid: ' + data + '</p>';
    cardHTML += '</div>';

    // Agregar la tarjeta al contenedor de resultados
    resultados.innerHTML += cardHTML;
}

function consultarClientesPorCiudadQueEmpiezaConM() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/count-by-city-starting-with-m',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesPorCiudadQueEmpiezaConM(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el número de clientes por ciudad que comienza con "M":', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados del número de clientes por ciudad que comienza con "M"
function mostrarResultadosClientesPorCiudadQueEmpiezaConM(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre los datos recibidos y mostrar el número de clientes por ciudad
    data.forEach(function(item) {
        // Crear una tarjeta HTML para mostrar el número de clientes por ciudad que comienza con "M"
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Clientes en ciudades que comienzan con "M": ' + item[0] + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarClientesSinRepresentanteDeVentas() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/count-without-sales-representative',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesSinRepresentanteDeVentas(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener el número de clientes sin representante de ventas asignado:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados del número de clientes sin representante de ventas asignado
function mostrarResultadosClientesSinRepresentanteDeVentas(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Mostrar el número de clientes sin representante de ventas asignado
    var cardHTML = '<div class="card green">';
    cardHTML += '<p class="tip">Clientes sin representante de ventas asignado: ' + data + '</p>';
    cardHTML += '</div>';

    // Agregar la tarjeta al contenedor de resultados
    resultados.innerHTML = cardHTML;
}

function consultarClientesConRepresentantesDeVentas() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/sales-representatives',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesConRepresentantesDeVentas(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener la lista de clientes con información de sus representantes de ventas:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados de la lista de clientes con información de sus representantes de ventas
function mostrarResultadosClientesConRepresentantesDeVentas(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada objeto DTO en los datos recibidos
    data.forEach(function(item) {
        // Crear una tarjeta HTML para cada cliente con su representante de ventas
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Cliente: ' + item.customerName + '</p>';
        cardHTML += '<p class="second-text">Representante de Ventas: ' + item.salesRepName + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarClientesSinPagosConRepresentantes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/without-payments-with-city-sales-representative',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosClientesSinPagosConRepresentantes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los clientes sin pagos y con representantes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados de los clientes sin pagos y con representantes
function mostrarResultadosClientesSinPagosConRepresentantes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada arreglo de objeto en los datos recibidos
    data.forEach(function(item) {
        // Crear una tarjeta HTML para cada cliente sin pagos y con representantes
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Cliente: ' + item[0] + '</p>';
        cardHTML += '<p class="second-text">Representante: ' + item[1] + ' ' + item[2] + '</p>';
        cardHTML += '<p>Ciudad: ' + item[3] + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarNombresClientesConRepresentantes() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/customers/names-representatives-customers-city',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosNombresClientesConRepresentantes(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los nombres de clientes con representantes:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados de los nombres de clientes con representantes
function mostrarResultadosNombresClientesConRepresentantes(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada objeto en los datos recibidos
    data.forEach(function(item) {
        // Crear una tarjeta HTML para cada nombre de cliente con representante
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Cliente: ' + item.customerName + '</p>';
        cardHTML += '<p class="second-text">Representante: ' + item.representativeFirstName + ' ' + item.representativeLastName + '</p>';
        cardHTML += '<p>Ciudad: ' + item.representativeOfficeCity + '</p>';
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}
