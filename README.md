# Notes API

A Spring Boot REST API for managing notes with CRUD operations, pagination, validation, and custom exception handling.

## Features
- Create, update, delete notes
- Pagination support
- Input validation
- Global exception handling
- MySQL integration

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL

## API Endpoints

POST /api/notes  
GET /api/notes?page=0&size=5  
GET /api/notes/{id}  
PUT /api/notes/{id}  
DELETE /api/notes/{id}

## How to Run
1. Clone the repo
2. Configure MySQL in application.properties
3. Run Spring Boot app
4. Test APIs using Postman
