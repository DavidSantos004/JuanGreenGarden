const homeLink = document.querySelector(".link.active");
const queriesAboutTableLink = document.querySelector(".linkQueriesAboutTable");
const multiTableQueriesLink = document.querySelector(".linkMultiTableQueries");
const summaryQueriesLink = document.querySelector(".linkSummaryQueries");

const mainContent = document.querySelector(".main-content");
const queriesContent = document.getElementById("queries-about-a-table");
const multiTableQueriesContent = document.getElementById("multi-table-queries");
const summaryQueriesContent = document.getElementById("summary-queries");
const wrapper = document.getElementById("wrapper");
const queriesOptions = document.getElementById("content-container");


queriesAboutTableLink.addEventListener("click", function(event) {
    event.preventDefault();
    // Ocultar contenido principal
    mainContent.style.display = "none";
    // Mostrar contenido de consultas sobre una tabla
    queriesContent.classList.remove("hidden");
    queriesContent.style.display = "contents";
    wrapper.style.justifyContent = "flex-start";
    queriesOptions.style.display = "flex";
    multiTableQueriesContent.style.display = "none"
    summaryQueriesContent.style.display = "none"
});

multiTableQueriesLink.addEventListener("click", function(event) {
    event.preventDefault();
    // Ocultar contenido principal
    mainContent.style.display = "none";
    multiTableQueriesContent.style.display = "flex"

    // Mostrar contenido de consultas de múltiples tablas
    queriesContent.classList.remove("hidden");
    queriesContent.style.display = "contents";
    wrapper.style.justifyContent = "flex-start";
    queriesOptions.style.display = "flex";
    summaryQueriesContent.style.display = "none"

    generateQueryOptionsMultiTableQueries(); 
});

summaryQueriesLink.addEventListener("click", function(event) {
    event.preventDefault();
    // Ocultar contenido principal
    mainContent.style.display = "none";
    // Mostrar contenido de consultas de resumen
    queriesContent.style.display = "none"
    wrapper.style.justifyContent = "flex-start";
    queriesOptions.style.display = "flex";
    summaryQueriesContent.style.display = "flex"
    multiTableQueriesContent.style.display = "none"
    queriesAboutTableLink.style.display = "none"
    queriesAboutTableLink.style.display = "flex"

    generateQueryOptionsSummaryQueries();

});

homeLink.addEventListener("click", function(event) {
    // Mostrar contenido principal
    mainContent.style.display = "block";
    // Ocultar contenido de consultas
    queriesContent.classList.add("hidden");
    queriesContent.style.display = "none";
    wrapper.style.justifyContent = "center";
    queriesOptions.style.display = "none";
});

// ...................................................................................
   
const queryResult = document.getElementById("query-result");

const queryOptionsAboutTable = [
    "List of offices and cities",
    "Offices and phones in Spain",
    "Employees under a specific boss",
    "Data of the company's boss",
    "Employees who are not sales representatives",
    "Spanish clients",
    "Order statuses",
    "Clients with payments in 2008",
    "Orders not delivered on time",
    "Orders delivered before the expected date",
    "Orders rejected in 2009",
    "Orders delivered in January",
    "Payments made in 2008 via PayPal",
    "Unique payment methods",
    "Ornamental products with more than 100 units in stock",
    "Madrid clients with specific representatives"
];

const queryOptionsMultiTableQueries = [
    "Clients and Sales Representatives",
    "Clients with Payments and their Representatives",
    "Clients without Payments and their Representatives",
    "Clients, Representatives, and Offices",
    "Clients without Payments, Representatives, and Offices",
    "Offices with Clients in Fuenlabrada",
    "Clients, Representatives, and Offices",
    "Employees and Managers",
    "Employees, Managers, and Managers' Managers",
    "Clients with Late Deliveries",
    "Product Ranges Purchased by Client",
    "Clients without Payments",
    "Clients without Orders",
    "Clients without Payments and Orders",
    "Employees without Offices",
    "Employees without Clients",
    "Employees without Clients and Offices",
    "Products Never Ordered",
    "Details of Products Never Ordered",
    "Offices without Sales of Fruit Trees",
    "Clients with Orders but No Payments",
    "Employees without Clients and their Managers"
];


const queryOptionsSummaryQueries = [
    "Total Employees in the Company",
    "Number of Customers per Country",
    "Average Payment in 2009",
    "Number of Orders in Each State (Descending Order)",
    "Price of Most Expensive and Least Expensive Products",
    "Total Number of Customers",
    "Customers in Madrid",
    "Customers in Cities Starting with 'M'",
    "Sales Representatives and Number of Customers",
    "Customers without Sales Representatives",
    "First and Last Payment Dates for Each Customer",
    "Number of Different Products in Each Order",
    "Total Quantity of Products in Each Order",
    "Top 20 Best Selling Products and Total Units Sold",
    "Total Revenue of the Company",
    "Total Revenue by Product Code",
    "Total Revenue by Product Code (Filtered by Codes Starting with 'OR')",
    "Total Sales of Products with Revenue over €3000",
    "Total Payments for Each Year"
];

function generateQueryOptionsSummaryQueries() {
    const optionsList = document.createElement("ul");
    optionsList.classList.add("query-options");

    queryOptionsSummaryQueries.forEach((option, index) => {
        const optionItem = document.createElement("li");
        optionItem.textContent = `Summary Query ${index + 1}: ${option}`;
        optionItem.addEventListener("click", function() {
            showQueryOption(option);
        });
        optionsList.appendChild(optionItem);
    });

    summaryQueriesContent.innerHTML = ""; // Borra el contenido anterior
    summaryQueriesContent.appendChild(optionsList);
}

function generateQueryOptionsMultiTableQueries() {
    const optionsList = document.createElement("ul");
    optionsList.classList.add("query-options");

    queryOptionsMultiTableQueries.forEach((option, index) => {
        const optionItem = document.createElement("li");
        optionItem.textContent = `Query ${index + 1}: ${option}`;
        optionItem.addEventListener("click", function() {
            showQueryOption(option);
        });
        optionsList.appendChild(optionItem);
    });

    queriesContent.innerHTML = ""; // Borra el contenido anterior
    queriesContent.appendChild(optionsList);
}

// Función para mostrar la opción seleccionada
function showQueryOption(option) {
    queryResult.innerHTML = `<p>${option}</p>`;
}

// Genera la lista de opciones de consulta
function generateQueryOptionsAboutTable() {
    const optionsList = document.createElement("ul");
    optionsList.classList.add("query-options");

    queryOptionsAboutTable.forEach((option, index) => {
        const optionItem = document.createElement("li");
        optionItem.textContent = `Consulta ${index + 1}: ${option}`;
        optionItem.addEventListener("click", function() {
            showQueryOption(option);
        });
        optionsList.appendChild(optionItem);
    });

    queriesContent.innerHTML = ""; // Borra el contenido anterior
    queriesContent.appendChild(optionsList);
}

queriesAboutTableLink.addEventListener("click", function(event) {
    event.preventDefault();
    queriesContent.classList.remove("hidden"); // Mostrar área de contenido
    generateQueryOptionsAboutTable();
});

//....................................................

multiTableQueriesLink.addEventListener("click", function(event) {
    event.preventDefault();
    // Ocultar contenido principal
    mainContent.style.display = "none";
    // Mostrar contenido de consultas de múltiples tablas
    multiTableQueriesContent.classList.remove("hidden");
    generateQueryOptionsMultiTableQueries();
});
