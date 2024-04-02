<h2 style="color: #4CAF50; text-align: center; font-size: 24px;">JUAN GREEN GARDEN</h2>

![Texto](/readme/web/img_%20(4).png)

## Canva Slides

![Canva](/readme/web/canva.png)

[<button style="background-color:#4CAF50; border:none; color:white; padding:15px 32px; text-align:center; text-decoration:none; display:inline-block; font-size:16px; margin:4px 2px; cursor:pointer; border-radius:10px;">Go to Canva</button>](https://www.canva.com/design/DAGBP0tF2pg/C-4y4MzfNqD2WdaKfr-Yag/view?utm_content=DAGBP0tF2pg&utm_campaign=designshare&utm_medium=link&utm_source=editor)




## Introduction
Juan Green Garden is a website where you can make a series of queries to the database through an API developed in Java with Spring Boot.

## Technologies

- Java
- PostgreSQL
- JavaScript
- HTML/CSS
- Spring Boot
- Spring Security
- Spring Data JPA


## Usage
### To use and run the project in a better way we recommend you have installed an IDE such as IntelliJ or VSCode.

1. Clone the repository.

        git clone https://github.com/DavidSantos004/JuanGreenGarden.git


2. run the database creation script called `jardineria` in the `data.sql` file.

3. Change the  `application.properties` if you have modified your PostgreSQL properties like host, port, username, or password.

4. Use the software

## Database

Postgresql was used for the database.

This is a relational database structure designed for a sales management system for a gardening company. Here's a summary of the tables and their fields:

1. **Office (`office`):**
   - `office_code`: Unique identifier of the office.
   - `city`: City where the office is located.
   - `country`: Country where the office is located.
   - `region`: Region where the office is located (optional).
   - `postal_code`: Postal code of the office address.
   - `phone`: Office phone number.
   - `address_line1` and `address_line2`: Office address lines.

2. **Employee (`employee`):**
   - `employee_code`: Unique identifier of the employee.
   - `first_name`, `last_name1`, `last_name2`: Employee's first name and last names.
   - `extension`: Employee's phone extension.
   - `email`: Employee's email address.
   - `office_code`: Foreign key referencing the `office` table.
   - `manager_code`: Foreign key referencing another employee in the `employee` table (the employee's manager).
   - `position`: Employee's position (optional).

3. **Product Line (`product_line`):**
   - `line`: Name of the product line.
   - `text_description`: Description of the product line in text.
   - `html_description`: Description of the product line in HTML format (optional).
   - `image`: Path to the image associated with the product line (optional).

4. **Customer (`customer`):**
   - `customer_code`: Unique identifier of the customer.
   - `customer_name`: Customer's name.
   - `contact_first_name`, `contact_last_name`: Contact person's first and last name (optional).
   - `phone`, `fax`: Customer's phone and fax numbers.
   - `address_line1`, `address_line2`, `city`, `region`, `country`, `postal_code`: Customer's address details.
   - `sales_rep_employee_code`: Foreign key referencing the `employee` table (customer's sales representative).
   - `credit_limit`: Customer's credit limit (optional).

5. **Order (`order`):**
   - `order_code`: Unique identifier of the order.
   - `order_date`, `expected_date`, `delivery_date`: Dates associated with the order.
   - `status`: Order status.
   - `comments`: Additional comments about the order.
   - `customer_code`: Foreign key referencing the `customer` table.

6. **Product (`product`):**
   - `product_code`: Unique identifier of the product.
   - `name`: Product name.
   - `product_line`: Foreign key referencing the `product_line` table.
   - `dimensions`, `supplier`, `description`: Additional product details.
   - `quantity_in_stock`, `sale_price`, `supplier_price`: Information about product stock and prices.

7. **Order Detail (`order_detail`):**
   - `order_code`, `product_code`: Foreign keys referencing the `order` and `product` tables respectively.
   - `quantity`, `unit_price`, `line_number`: Specific details of the order.

8. **Payment (`payment`):**
   - `customer_code`: Foreign key referencing the `customer` table.
   - `payment_method`, `transaction_id`, `payment_date`, `total`: Details of the payment made by the customer.

This structure allows for managing offices, employees, customers, products, orders, and payments, maintaining relationships between them for a comprehensive management system.

## Model

Dive into the intricate architecture of our database schema, where every table and relationship has been meticulously designed to facilitate efficient data management and retrieval. Gain insights into how various entities interact within our system, empowering you to better understand the inner workings of Juan Green Garden.


![image](/readme/database/Diagrama%20SQL.png)



<!-- # Query

## Customer
### Get all
- **URL:** http://localhost:8080/customers
- **Description:** Return a list with the names of all Spanish clients. -->





## Class Diagram UML

Explore the breakdown of our system's components in the Unified Modeling Language (UML) representation:


* **Controller**: Navigate the endpoints and actions responsible for handling incoming requests and orchestrating the flow of data.

![photo](/readme/uml/Controller.png)

* **Entity**: Discover the core entities within our system, representing the essential objects and data structures.

![photo](/readme/uml/Entity.png)

* **DTO (Data Transfer Object)**: Delve into the DTOs designed to transfer data between layers of our application, ensuring efficient communication.

![photo](/readme/uml/DTO.png)

* **Exceptions**: Understand the exceptional scenarios handled within our system, ensuring robust error management and graceful degradation.

![photo](/readme/uml/Exceptions.png)

* **Repository**: Explore the interfaces and implementations responsible for database interactions, providing seamless data persistence.

![photo](/readme/uml/Repository.png)

* **Security**: Examine the security measures implemented to safeguard our application, protecting against unauthorized access and data breaches.

![photo](/readme/uml/Security.png)

* **Service**: Uncover the business logic encapsulated within our service layer, orchestrating complex operations and ensuring system functionality.

![photo](/readme/uml/Service.png)

<!-- * Complete UML:  -->
<!-- ![photo](/readme/uml/TodoUML.png) -->



# Frontend

Explore the captivating user interface and functionality of our frontend:

###  Designs

Dive into the meticulously crafted designs that form the visual identity of our application, blending aesthetics with usability for an immersive user experience.

![image](/readme/bct/LOGIN.png)
![image](/readme/bct/QUERY.png)
![image](/readme/bct/QUERIS.png)



## Web

Experience the web interface of our application, where intuitive design meets seamless navigation, empowering users to effortlessly interact with our platform from any device or browser.

![image](/readme/web/img_%20(4).png)
![image](/readme/web/img_%20(3).png)
![image](/readme/web/img_%20(1).png)
![image](/readme/web/img_%20(2).png)
![image](/readme/web/img_%20(7).png)

---
Thank you for visiting our project! We hope you find what we've created at Juan Green Garden helpful and exciting! 

Thank you for your interest and support!

Happy gardening!

---
