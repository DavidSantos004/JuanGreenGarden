document.addEventListener("DOMContentLoaded", function () {
    const currentUrl = window.location.pathname;
    if (currentUrl.includes("login.html")) {
        const loginForm = document.getElementById("loginForm"); // Cambiar "loginForm" al ID del formulario real
        const loginUsernameInput = document.getElementById("loginUsername");
        const loginPasswordInput = document.getElementById("loginPassword");

        loginForm.addEventListener("submit", async function (event) {
            event.preventDefault();

            const username = loginUsernameInput.value;
            const password = loginPasswordInput.value;
            const loginFormData = new FormData();
            loginFormData.append("username", username);
            loginFormData.append("password", password);
            console.log(loginFormData)

            try {
                const response = await fetch("http://localhost:8080/login", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded",
                    },
                    body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`,
                });

                if (!response.ok) {
                    alert("Incorrect username or password");
                    throw new Error("Error obtaining login token. HTTP status code:" + response.status);
                }

                const token = await response.text();
                sessionStorage.setItem("jwtToken", token.trim());
                alert("Successfully generated token");
                window.location.href = "index.html";
            } catch (error) {
                console.error("Error obtaining login token:", error);
                loginUsernameInput.value = '';
                loginPasswordInput.value = '';
            }
        });
    } else if (currentUrl.includes("register.html")) {
        const registerButton = document.getElementById("registerBtn");
        const registerUsernameInput = document.getElementById("registerUsername");
        const registerPasswordInput = document.getElementById("registerPassword");

        registerButton.addEventListener("click", async function (event) {
            event.preventDefault();

            const username = registerUsernameInput.value;
            const password = registerPasswordInput.value;

            const registerFormData = {
                username: username,
                password: password,
            };

            console.log(username);
            console.log(password);
            console.log(registerFormData);
            await fetch("http://localhost:8080/register", {
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                },
                body: JSON.stringify(registerFormData),
            })
            .then((response) => response.json())
            .then((data) => {
                console.log("Success:", data);
                alert("Successful Register");
                window.location.href = "login.html";
            })
            .catch((error) => {
                console.error("Registry error:", error);
            });
            });
    }    
});
