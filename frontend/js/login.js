console.log("--[ login js connected ]-- ");

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

/* Animation */
signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});




/* Logica */
document.addEventListener("DOMContentLoaded", function () {
    const loginButton = document.getElementById("loginBtn");
    const registerButton = document.getElementById("registerBtn");





    if (loginButton && registerButton) {
        loginButton.addEventListener("click", async function (event) {
            event.preventDefault();
            console.log("Login...");
            // Aquí puedes ejecutar la lógica para el inicio de sesión
            // Por ejemplo, puedes obtener los datos del formulario y enviarlos al servidor para autenticación
            
            const loginForm = document.getElementById("loginForm"); // Cambiar "loginForm" al ID del formulario real
            const loginUsernameInput = document.getElementById("loginUsername");
            const loginPasswordInput = document.getElementById("loginPassword");
    
            //loginForm.addEventListener("submit", async function (event) {
                //event.preventDefault();
                //console.log("entrar en lisstener");
    
                const username = loginUsernameInput.value;
                const password = loginPasswordInput.value;
                const loginFormData = new FormData();
                loginFormData.append("username", username);
                loginFormData.append("password", password);
                //console.log(loginFormData)
    
                try {
                    const response = await fetch("http://localhost:8080/login", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/x-www-form-urlencoded",
                        },
                        body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`,
                    });
    
                    if (!response.ok) {
                        console.log("ERROR: Incorrect username or password")
                        alert("Incorrect username or password");
                        throw new Error("Error obtaining login token. HTTP status code:" + response.status);

                    }
    
                    const token = await response.text();
                    sessionStorage.setItem("jwtToken", token.trim());
                    alert("Successfully generated token");
                    window.location.href = "../index.html";
                } catch (error) {
                    console.error("Error obtaining login token:", error);
                    loginUsernameInput.value = '';
                    loginPasswordInput.value = '';
                }
                //console.log("salir de lisstener");
            //});
            
            
            
            
            
            
            
            
            console.log("...Login");
        });

        registerButton.addEventListener("click", async function (event) {
            event.preventDefault();
            console.log("Registrar...");
            // Aquí puedes ejecutar la lógica para el registro
            // Por ejemplo, puedes obtener los datos del formulario y enviarlos al servidor para crear una nueva cuenta de usuario
            


            const registerButton = document.getElementById("registerBtn");
            const registerUsernameInput = document.getElementById("registerUsername");
            const registerPasswordInput = document.getElementById("registerPassword");

            //registerButton.addEventListener("click", async function (event) {
                //event.preventDefault();

                const username = registerUsernameInput.value;
                const password = registerPasswordInput.value;

                const registerFormData = {
                    username: username,
                    password: password,
                };

                //console.log(username);
                //console.log(password);
                //console.log(registerFormData);
                await fetch("http://localhost:8080/register", {
                    method: "POST",
                    headers: {
                    "Content-Type": "application/json",
                    },
                    body: JSON.stringify(registerFormData),
                })
                .then((response) => response.json())
                .then((data) => {
                    //console.log("Success:", data);
                    console.log("Success!");
                    alert("Successful Register");
                    window.location.href = "login.html";
                })
                .catch((error) => {
                    console.error("Registry error:", error);
                });
                //});
                


            
            console.log("...Registrar");
        });
    } else {
        console.error("No se encontraron los botones de inicio de sesión y/o registro");
    }
});

//console.log("...login3");
