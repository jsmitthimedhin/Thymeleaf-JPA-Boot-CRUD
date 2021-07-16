# Thymeleaf-JPA-Boot-CRUD
This application allows users to create, read, update, and delete members in a table, hooked up to a SQL database, built using Thymeleaf on the front-end and Spring Boot's Data JPA on the backend

## Process
The application is built using Spring initializr and allowed me to explore building on the front-end with Thymeleaf rather than JSP. It also solidified concepts of how the Spring MVC model works and how I can use Spring Data JPA to do the grunt work of a DAO class without having to configure everything from scratch. 

I also learned how to define the DataSource using Spring Boot's ".properties" file instead of defining it using annotations and hard-coded configurations (which is so much easier and less error-prone!). The rest is just creating the REST controller, DAO, Service class, and entity class, and mapping each class with Spring or Hibernate annotations, similar to other projects I've worked on.

## How to Run
Download and install Postman or any other program that allows you to perform HTTP requests to a web server.
Run the two SQL scripts; first one creates a user in SQL and grants the user permission for CRUD methods, second one creates and populates the database.
Run "CrudApplication" as a Java Application using with your JRE/JDK.
Use Postman to request a GET method from [your web server]/api/members
