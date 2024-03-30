document.addEventListener("DOMContentLoaded", function() {
  const linkQueries = document.querySelector(".icon");
  const container = document.querySelector(".cards-container");

  linkQueries.addEventListener("click", function(event) {
    event.preventDefault(); // Previene el comportamiento predeterminado del enlace

    // Muestra u oculta el contenedor dependiendo de su estado actual
    if (container.style.display === "none") {
      container.style.display = "flex";
      container.style.flexWrap= "wrap"
      container.style.justifyContent = "center"
      container.style.alignItems = "center"
    } else {
      container.style.display = "none";
    }
  });

  // Llama a la función para generar las tarjetas de las diferentes entidades cuando se hace clic en el enlace de "Queries"
  linkQueries.addEventListener("click", function(event) {
    event.preventDefault();

    container.innerHTML = "";

    // Genera tarjetas para las entidades especificadas con IDs únicos basados en la entidad
    generateEntityCards("Customer", "customerCard", "pages/customerQueries.html");
    generateEntityCards("Employee", "employeeCard", "employeeQueries.html");
    generateEntityCards("Office", "officeCard", "officeQueries.html");
    generateEntityCards("Order", "orderCard", "orderQueries.html");
    generateEntityCards("OrderDetail", "orderDetailCard", "orderDetailQueries.html");
    generateEntityCards("Payment", "paymentCard", "paymentQueries.html");
    generateEntityCards("Product", "productCard", "productQueries.html");
    generateEntityCards("ProductLine", "productLineCard", "productLineQueries.html");
  });
});

// Función para generar las tarjetas de las diferentes entidades con IDs únicos
function generateEntityCards(entityName, entityId, destinationLink) {
  const container = document.querySelector(".cards-container");

  const cardLink = document.createElement("a");
  cardLink.href = destinationLink; // Establecer el enlace de destino
  cardLink.classList.add("card-link");
  cardLink.style.margin = "40px";
  cardLink.id = entityId; // Asignar ID único a la tarjeta

  const card = document.createElement("div");
  card.classList.add("card");

  const cardHead = document.createElement("div");
  cardHead.classList.add("card-head");

  const cardLogo = document.createElement("img");
  cardLogo.src = "https://cdn.icon-icons.com/icons2/3252/PNG/512/database_search_regular_icon_205400.png";
  cardLogo.alt = "logo";
  cardLogo.classList.add("card-logo");

  const productDetail = document.createElement("div");
  productDetail.classList.add("product-detail");

  const entityHeader = document.createElement("h2");
  entityHeader.textContent = entityName;

  const backText = document.createElement("span");
  backText.classList.add("back-text");
  backText.textContent = "ries";

  const productColor = document.createElement("div");
  productColor.classList.add("product-color");

  const queryCaption = document.createElement("h4");
  queryCaption.textContent = `Queries ${entityName}`;

  // Agregar elementos al DOM
  productDetail.appendChild(entityHeader);
  cardHead.appendChild(cardLogo);
  cardHead.appendChild(productDetail);
  cardHead.appendChild(backText);
  productColor.appendChild(queryCaption);
  card.appendChild(cardHead);
  card.appendChild(productColor);
  cardLink.appendChild(card);
  container.appendChild(cardLink);

  // Después de agregar la tarjeta al DOM, establecer la opacidad a 1 con un pequeño retraso para permitir que se aplique la transición
  setTimeout(() => {
      cardLink.style.opacity = "1";
  }, 100); // Retraso pequeño para permitir que se aplique la transición

  // Agregar evento de escucha a la tarjeta recién creada
  cardLink.addEventListener("click", function(event) {
    console.log(`Soy una card de ${entityName}`);
  });
}

// Llama a la función para generar las tarjetas de las diferentes entidades cuando se hace clic en el enlace de "Queries"
document.querySelector(".icon").addEventListener("click", function(event) {

  console.log("aaaaaaa");
  const container = document.querySelector(".cards-container");
  container.innerHTML = "";

  // Genera tarjetas para las entidades especificadas con IDs únicos basados en la entidad
  generateEntityCards("Customer", "customerCard");
  generateEntityCards("Employee", "employeeCard");
  generateEntityCards("Office", "officeCard");
  generateEntityCards("Order", "orderCard");
  generateEntityCards("OrderDetail", "orderDetailCard");
  generateEntityCards("Payment", "paymentCard");
  generateEntityCards("Product", "productCard");
  generateEntityCards("ProductLine", "productLineCard");
});
