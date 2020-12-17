### Taco Application 🌮
Here is an application for ordering tacos.

It uses the following technologies:
- Spring Boot,
- Spring Security,
- Spring Data JPA,
- Liquibase,
- Thymeleaf,
- Bootstrap.

The application is based on ideas from the book **Spring in Action** (5th edition).

The app allows you to create your own tacos from different ingredients and place an order.

The administrator can view all orders, change their status, and view reports.

## Database

This project uses a PostgreSQL database. The database name can be changed easily in the application.properties.
In this example the database is called 'tacocloud'.
You **have to** create the database before running the project.

## Liquibase

Master changelog file contains references to init.sql and data.sql.

File init.sql contains scripts to:
   - create tables: ingredient, roles, taco_type, taco, taco_type_ingredients, taco_order, users, users_roles, 
   - insert values to ingredient, roles, 
   - create default user admin/1
File data.sql inserts some example rows to database.

## Getting started

1) You need Java 8 installed.

2) Clone git repository using command
    > git clone https://github.com/lenapot/taco

3) In intellij idea open File -> New project from existing sources -> Choose gradle file

4) To run the application use command
	> ./gradlew bootRun

5) To test that it works, open a browser tab at http://localhost:8080/ .

## Run test
The repository contains some test cases to cover both api test and service test
> ./gradlew test

