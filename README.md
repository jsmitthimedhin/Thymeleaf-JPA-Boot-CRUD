# Thymeleaf-JPA-Boot-CRUD
This application allows users to create, read, update, and delete members in a table, built using Thymeleaf on the front-end and Spring Boot's Data JPA on the backend, which is hooked up to a SQL database.

## Process
The application is built using Spring initializr and allowed me to explore building on the front-end with Thymeleaf rather than JSP. It also solidified concepts of how the Spring MVC model works and how I can use Spring Data JPA to do the grunt work of a DAO class without having to configure all the different methods and JDBC connection from scratch. 

Spring Data JPA has built-in methods that I can use in the Service class to get, add/update, and delete items in the database, and the rest is just a matter of mapping the objects in the database with the objects that appear as models in the front-end of the webapp using a Controller. 

## How to Run
1. Run the two SQL scripts; first one creates a user in SQL and grants the user permission to access the database, and the second one creates and populates the database.
2. Run "ThymeleafdemoApplication" as a Java Application with your JRE/JDK.
3. Access the server (http://localhost:8080 or another port, depending on your configuration) on your web browser.
