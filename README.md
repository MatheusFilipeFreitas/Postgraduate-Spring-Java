# Postgraduate Spring Java

Spring Boot project for the postgraduate course, built with Java and Maven. It implements a layered REST API with reusable CRUD abstractions and an in-memory persistence layer.

## Tech stack

- **Java 25**
- **Spring Boot 4.1.0**
- **Spring Web MVC** — REST endpoints
- **Spring Boot DevTools** — faster development with automatic restarts
- **Lombok** — reduces boilerplate in models and services
- **Maven** — dependency management and build (wrapper included)

## Prerequisites

- JDK 25
- Git

Maven is optional; the project includes the Maven Wrapper (`./mvnw`).

## Getting started

Clone the repository:

```bash
git clone git@github.com:MatheusFilipeFreitas/Postgraduate-Spring-Java.git
cd Postgraduate-Spring-Java
```

Run the application:

```bash
./mvnw spring-boot:run
```

The app starts on `http://localhost:8080` by default.

Run tests:

```bash
./mvnw test
```

Build a runnable JAR:

```bash
./mvnw package
java -jar target/unipds-spring-0.0.1-SNAPSHOT.jar
```

## Architecture

The project follows a layered structure with generic CRUD building blocks:

```
Controller  →  Service  →  Repository  →  In-memory store
     ↓            ↓
   DTOs        Mappers
```

| Layer | Responsibility |
|-------|----------------|
| **Controller** | HTTP mapping and request/response handling |
| **Service** | Business logic and DTO ↔ entity conversion |
| **Repository** | Data access (in-memory `LinkedHashMap`) |
| **DTO** | API contracts for create, update, and response payloads |
| **Mapper** | Transforms between DTOs and domain models |

Reusable abstractions live under `common/` packages and can be extended for new resources.

## API

### Products

Base path: `/products`  
Content type: `application/json`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/products` | List all products |
| `GET` | `/products/{id}` | Get a product by ID |
| `POST` | `/products` | Create a product |
| `PUT` | `/products/{id}` | Update a product |
| `DELETE` | `/products/{id}` | Delete a product |

**Create request**

```json
{
  "name": "Book",
  "price": 29.90
}
```

**Update request**

```json
{
  "name": "Updated Book",
  "price": 39.90
}
```

**Response**

```json
{
  "id": 1,
  "name": "Book",
  "price": 29.90,
  "audit": {
    "createdAt": "2026-06-11T10:00:00",
    "updatedAt": "2026-06-11T10:00:00"
  }
}
```

## Project structure

```
src/
├── main/
│   ├── java/com/mathffreitas/spring/
│   │   ├── UnipdsSpringApplication.java
│   │   ├── controller/
│   │   │   ├── common/CrudController.java
│   │   │   └── product/ProductController.java
│   │   ├── service/
│   │   │   ├── common/CrudService.java
│   │   │   └── product/
│   │   ├── repository/
│   │   │   ├── common/CrudRepository.java
│   │   │   └── product/ProductRepository.java
│   │   ├── model/
│   │   │   ├── common/BaseIdModel.java
│   │   │   └── product/Product.java
│   │   ├── dto/
│   │   └── utils/mapper/
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/mathffreitas/spring/
        └── UnipdsSpringApplicationTests.java
```

## Configuration

Application settings live in `src/main/resources/application.properties`:

```properties
spring.application.name=unipds-spring
```

## Author

Matheus Filipe Freitas
