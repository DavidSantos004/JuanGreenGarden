function consultarTodosLosEmpleados() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/employees',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosTodosLosEmpleados(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener todos los empleados:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados de todos los empleados
function mostrarResultadosTodosLosEmpleados(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada objeto en los datos recibidos
    data.forEach(function(empleado) {
        // Crear una tarjeta HTML para cada empleado
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + empleado.firstName + ' ' + empleado.lastName1 + ' ' + empleado.lastName2 + '</p>';
        cardHTML += '<p class="second-text">Puesto: ' + empleado.jobTitle + '</p>';
        cardHTML += '<p>Correo electrónico: ' + empleado.email + '</p>';
        cardHTML += '<p>Extensión: ' + empleado.extension + '</p>';
        // Añadir más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarEmpleadosDeUnJefe() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/employees/boss-employees',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarResultadosEmpleadosDeUnJefe(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los empleados de un jefe:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los resultados de los empleados de un jefe
function mostrarResultadosEmpleadosDeUnJefe(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada objeto en los datos recibidos
    data.forEach(function(empleado) {
        // Crear una tarjeta HTML para cada empleado
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + empleado.firstName + ' ' + empleado.lastName1 + ' ' + empleado.lastName2 + '</p>';
        cardHTML += '<p class="second-text">Puesto: ' + empleado.jobTitle + '</p>';
        cardHTML += '<p>Correo electrónico: ' + empleado.email + '</p>';
        cardHTML += '<p>Extensión: ' + empleado.extension + '</p>';
        // Añadir más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarDetallesDelJefe() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/employees/boss',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarDetallesDelJefe(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los detalles del jefe:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los detalles del jefe
function mostrarDetallesDelJefe(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Crear una tarjeta HTML para los detalles del jefe
    var cardHTML = '<div class="card green">';
    cardHTML += '<p class="tip">Nombre: ' + data.firstName + ' ' + data.lastName1 + ' ' + data.lastName2 + '</p>';
    cardHTML += '<p class="second-text">Puesto: ' + data.jobTitle + '</p>';
    cardHTML += '<p>Correo electrónico: ' + data.email + '</p>';
    cardHTML += '<p>Extensión: ' + data.extension + '</p>';
    // Añadir más campos según sea necesario
    cardHTML += '</div>';

    // Agregar la tarjeta al contenedor de resultados
    resultados.innerHTML = cardHTML;
}

function consultarEmpleadosNoRepresentantesDeVentas() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/employees/non-sales-representatives',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarEmpleadosNoRepresentantesDeVentas(data);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener los empleados que no son representantes de ventas:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los empleados que no son representantes de ventas
function mostrarEmpleadosNoRepresentantesDeVentas(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    // Iterar sobre cada empleado y crear una tarjeta HTML para cada uno
    data.forEach(function(employee) {
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">Nombre: ' + employee.firstName + ' ' + employee.lastName1 + ' ' + employee.lastName2 + '</p>';
        cardHTML += '<p class="second-text">Puesto: ' + employee.jobTitle + '</p>';
        cardHTML += '<p>Correo electrónico: ' + employee.email + '</p>';
        cardHTML += '<p>Extensión: ' + employee.extension + '</p>';
        // Agregar más campos según sea necesario
        cardHTML += '</div>';

        // Agregar la tarjeta al contenedor de resultados
        resultados.innerHTML += cardHTML;
    });
}

function consultarEmpleadosSinOficina() {
    // Obtener el token JWT del sessionStorage del navegador
    var token = sessionStorage.getItem('jwtToken');

    // Verificar si el token JWT está presente
    if (token) {
        // Incluir el token JWT en la cabecera de la solicitud AJAX
        $.ajax({
            url: 'http://localhost:8080/api/employees/without-office',
            type: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(data) {
                mostrarEmpleadosSinOficina(data);
            },
            error: function(xhr, status, error) {
                mostrarEmpleadosSinOficina();
                console.error('Error al obtener los empleados sin oficina asociada:', error);
            }
        });
    } else {
        console.error('Token JWT no encontrado en sessionStorage');
    }
}

// Función para mostrar los empleados que no tienen una oficina asociada
function mostrarEmpleadosSinOficina(data) {
    // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">No se encontraron empleados sin una oficina asociada.</p>';
        cardHTML += '</div>';

        resultados.innerHTML += cardHTML;

    } 
    
    function consultarEmpleadosSinClientes() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/without-customers',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarEmpleadosSinClientes(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error al obtener los empleados sin clientes asociados:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar los empleados que no tienen clientes asociados
    function mostrarEmpleadosSinClientes(data) {
        // Mostrar el contenedor de resultados si está oculto
        var resultados = document.getElementById('resultados');
        if (resultados.style.display === 'none') {
            resultados.style.display = 'flex';
        }
    
        // Limpiar el contenido previo en el contenedor de resultados
        resultados.innerHTML = '';
    
        // Verificar si se encontraron empleados sin clientes asociados
        if (data.length === 0) {
            resultados.innerHTML = '<p>No se encontraron empleados sin clientes asociados.</p>';
        } else {
            // Iterar sobre cada empleado y crear una tarjeta HTML para cada uno
            data.forEach(function(employee) {
                var cardHTML = '<div class="card green">';
                cardHTML += '<p class="tip">Nombre: ' + employee.firstName + ' ' + employee.lastName1 + ' ' + employee.lastName2 + '</p>';
                cardHTML += '<p class="second-text">Puesto: ' + employee.jobTitle + '</p>';
                cardHTML += '<p>Correo electrónico: ' + employee.email + '</p>';
                cardHTML += '<p>Extensión: ' + employee.extension + '</p>';
                // Agregar más campos según sea necesario
                cardHTML += '</div>';
    
                // Agregar la tarjeta al contenedor de resultados
                resultados.innerHTML += cardHTML;
            });
        }
    }
    
    function consultarEmpleadosSinClientesYConOficina() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/without-customers-and-office',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarEmpleadosSinClientesYConOficina(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error al obtener los empleados sin clientes y con oficina:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar los empleados que no tienen clientes asociados y tienen una oficina asignada
    function mostrarEmpleadosSinClientesYConOficina(data) {
        // Mostrar el contenedor de resultados si está oculto
        var resultados = document.getElementById('resultados');
        if (resultados.style.display === 'none') {
            resultados.style.display = 'flex';
        }
    
        // Limpiar el contenido previo en el contenedor de resultados
        resultados.innerHTML = '';
    
        // Verificar si se encontraron empleados sin clientes y con oficina
        if (data.length === 0) {
            resultados.innerHTML = '<p>No se encontraron empleados sin clientes y con oficina asignada.</p>';
        } else {
            // Iterar sobre cada empleado y crear una tarjeta HTML para cada uno
            data.forEach(function(employee) {
                var cardHTML = '<div class="card green">';
                cardHTML += '<p class="tip">Nombre: ' + employee.firstName + ' ' + employee.lastName1 + ' ' + employee.lastName2 + '</p>';
                cardHTML += '<p class="second-text">Puesto: ' + employee.jobTitle + '</p>';
                cardHTML += '<p>Correo electrónico: ' + employee.email + '</p>';
                cardHTML += '<p>Extensión: ' + employee.extension + '</p>';
                cardHTML += '<p>Oficina: ' + employee.officeField.city + ', ' + employee.officeField.country + '</p>';
                // Agregar más campos según sea necesario
                cardHTML += '</div>';
    
                // Agregar la tarjeta al contenedor de resultados
                resultados.innerHTML += cardHTML;
            });
        }
    }
    

    function consultarEmpleadosSinOficinaYClientes() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/without-office-and-customer',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarEmpleadosSinOficinaYClientes(data);
                },
                error: function(xhr, status, error) {
                    mostrarEmpleadosSinOficinaYClientes()
                    console.error('Error al obtener los empleados sin oficina y clientes:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar los empleados que no tienen una oficina asociada ni un cliente asociado
    function mostrarEmpleadosSinOficinaYClientes(data) {
        console.log("aaaaaaaaaa")
        // Mostrar el contenedor de resultados si está oculto
    var resultados = document.getElementById('resultados');
    if (resultados.style.display === 'none') {
        resultados.style.display = 'flex';
    }

    // Limpiar el contenido previo en el contenedor de resultados
    resultados.innerHTML = '';

    
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class="tip">No se encontraron empleados sin una oficina asociada ni un cliente asociado.</p>';
        cardHTML += '</div>';

        resultados.innerHTML += cardHTML;

    } 
    
    function consultarNumeroTotalEmpleados() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/count-employees',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarNumeroTotalEmpleados(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error al obtener el número total de empleados:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar el número total de empleados
    function mostrarNumeroTotalEmpleados(totalEmpleados) {
        // Mostrar el contenedor de resultados si está oculto
        var resultados = document.getElementById('resultados');
        if (resultados.style.display === 'none') {
            resultados.style.display = 'flex';
        }
    
        // Limpiar el contenido previo en el contenedor de resultados
        resultados.innerHTML = '';
    
        // Mostrar el número total de empleados en el contenedor de resultados
        var cardHTML = '<div class="card green">';
        cardHTML += '<p class ="tip">El número total de empleados en la compañía es: ' + totalEmpleados + '</p>';
        cardHTML += '</div>';

        resultados.innerHTML += cardHTML;
    }
    
    function consultarClientesPorRepresentanteDeVentas() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/count-customers-by-sales-representative',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarClientesPorRepresentanteDeVentas(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error al recuperar los representantes de ventas y el número de clientes:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar los representantes de ventas y el número de clientes que atienden
    function mostrarClientesPorRepresentanteDeVentas(data) {
        // Mostrar el contenedor de resultados si está oculto
        var resultados = document.getElementById('resultados');
        if (resultados.style.display === 'none') {
            resultados.style.display = 'flex';
        }
    
        // Limpiar el contenido previo en el contenedor de resultados
        resultados.innerHTML = '';
    
        // Iterar sobre cada representante de ventas y mostrar su nombre y número de clientes atendidos
        data.forEach(function(representante) {
            var cardHTML = '<div class="card green">';
            cardHTML += '<p>Representante de Ventas: ' + representante[0] + '</p>';
            cardHTML += '<p>Número de Clientes Atendidos: ' + representante[1] + '</p>';
            cardHTML += '</div>';
    
            // Agregar la tarjeta al contenedor de resultados
            resultados.innerHTML += cardHTML;
        });
    }
    
    function consultarNombresEmpleadosYJefes() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/names-and-bosses',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarNombresEmpleadosYJefes(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error al obtener los nombres de los empleados y sus jefes:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar los nombres de los empleados y sus jefes
    function mostrarNombresEmpleadosYJefes(data) {
        // Mostrar el contenedor de resultados si está oculto
        var resultados = document.getElementById('resultados');
        if (resultados.style.display === 'none') {
            resultados.style.display = 'flex';
        }
    
        // Limpiar el contenido previo en el contenedor de resultados
        resultados.innerHTML = '';
    
        // Iterar sobre cada array de objetos y mostrar los nombres de los empleados y sus jefes
        data.forEach(function(empleado) {
            var cardHTML = '<div class="card green">';
            cardHTML += '<p>Empleado: ' + empleado[0] + ' ' + empleado[1] + '</p>';
            cardHTML += '<p>Jefe: ';
            if (empleado[2] && empleado[3]) {
                cardHTML += empleado[2] + ' ' + empleado[3];
            } else {
                cardHTML += 'N/A';
            }
            cardHTML += '</p>';
            cardHTML += '</div>';
    
            // Agregar la tarjeta al contenedor de resultados
            resultados.innerHTML += cardHTML;
        });
    }

    function consultarNombresEmpleadosJefesYJefesSuperiores() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/names-bosses-grandbosses',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarNombresEmpleadosJefesYJefesSuperiores(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error al obtener los nombres de los empleados, sus jefes y sus jefes superiores:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar los nombres de los empleados, sus jefes y sus jefes superiores
    function mostrarNombresEmpleadosJefesYJefesSuperiores(data) {
        // Mostrar el contenedor de resultados si está oculto
        var resultados = document.getElementById('resultados');
        if (resultados.style.display === 'none') {
            resultados.style.display = 'flex';
        }
    
        // Limpiar el contenido previo en el contenedor de resultados
        resultados.innerHTML = '';
    
        // Iterar sobre cada array de objetos y mostrar los nombres de los empleados, sus jefes y sus jefes superiores
        data.forEach(function(empleado) {
            var cardHTML = '<div class="card green">';
            cardHTML += '<p>Empleado: ' + empleado[0] + '</p>';
            cardHTML += '<p>Jefe: ' + empleado[1] + '</p>';
            cardHTML += '<p>Jefe Superior: ' + empleado[2] + '</p>';
            cardHTML += '</div>';
    
            // Agregar la tarjeta al contenedor de resultados
            resultados.innerHTML += cardHTML;
        });
    }

    function consultarEmpleadosSinClientes() {
        // Obtener el token JWT del sessionStorage del navegador
        var token = sessionStorage.getItem('jwtToken');
    
        // Verificar si el token JWT está presente
        if (token) {
            // Incluir el token JWT en la cabecera de la solicitud AJAX
            $.ajax({
                url: 'http://localhost:8080/api/employees/without-customers-nameBooses',
                type: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + token
                },
                success: function(data) {
                    mostrarEmpleadosSinClientes(data);
                },
                error: function(xhr, status, error) {
                    console.error('Error al obtener los empleados sin clientes asociados:', error);
                }
            });
        } else {
            console.error('Token JWT no encontrado en sessionStorage');
        }
    }
    
    // Función para mostrar los empleados que no tienen clientes asociados
    function mostrarEmpleadosSinClientes(data) {
        // Mostrar el contenedor de resultados si está oculto
        var resultados = document.getElementById('resultados');
        if (resultados.style.display === 'none') {
            resultados.style.display = 'flex';
        }
    
        // Limpiar el contenido previo en el contenedor de resultados
        resultados.innerHTML = '';
    
        // Iterar sobre cada empleado y crear una tarjeta HTML para cada uno
        data.forEach(function(empleado) {
            var cardHTML = '<div class="card green">';
            cardHTML += '<p>Nombre: ' + empleado.firstName + ' ' + empleado.lastName1 + ' ' + empleado.lastName2 + '</p>';
            cardHTML += '<p>Puesto: ' + empleado.jobTitle + '</p>';
            cardHTML += '<p>Correo electrónico: ' + empleado.email + '</p>';
            cardHTML += '<p>Extensión: ' + empleado.extension + '</p>';
            // Agregar más campos según sea necesario
            cardHTML += '</div>';
    
            // Agregar la tarjeta al contenedor de resultados
            resultados.innerHTML += cardHTML;
        });
    }
    
    
    