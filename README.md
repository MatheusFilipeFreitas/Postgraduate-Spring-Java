# unipds-spring

Spring Boot project for the postgraduate course, built with Java and Maven. It implements a layered REST API with reusable CRUD abstractions, URL-based API versioning, and an in-memory persistence layer.

## Tech stack

- **Java 25**
- **Spring Boot 4.1.0**
- **Spring Web MVC** — REST endpoints
- **Spring Boot DevTools** — faster development with automatic restarts
- **Lombok** — reduces boilerplate in models and services
- **Maven** — dependency management and build (wrapper included)
- **springdoc-openapi** — API docs at `/api/swagger-ui.html` when the app is running

## Prerequisites

- JDK 25
- Git

Maven is optional; the project includes the Maven Wrapper (`./mvnw`).

## Getting started

Clone the repository:

```bash
git clone git@github.com:MatheusFilipeFreitas/Postgraduate-Spring-Java.git
cd unipds-spring
```

Run the application:

```bash
./mvnw spring-boot:run
```

The app starts on `http://localhost:8080`. All REST endpoints are served under the `/api` context path (see Configuration).

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

The project follows a layered structure with generic CRUD building blocks and version-aware service routing:

```
Controller  →  ServiceFactory  →  Service (V1/V2/V3)  →  Repository  →  In-memory store
     ↓                                    ↓
   DTOs                               Mappers
```

| Layer | Responsibility |
|-------|----------------|
| **Controller** | HTTP mapping; resolves API version from URL path |
| **ServiceFactory** | Maps `ApiVersions` enum to the correct service bean |
| **Service** | Business logic and DTO ↔ entity conversion |
| **Repository** | Data access (in-memory `LinkedHashMap`) |
| **DTO** | API contracts for create, update, and response payloads |
| **Mapper** | Transforms between DTOs and domain models |

Reusable abstractions live under `common/` packages and can be extended for new resources.

## API versioning

All product endpoints are versioned via the URL path under the `/api` context path:

**Base path:** `/api/v{apiVersion}/products`  
**Content type:** `application/json`

Supported versions: `v1`, `v2`, `v3`. Unknown versions (e.g. `v99`) return **404 Not Found**.

| Version | CRUD | `GET /total-prices` |
|---------|------|---------------------|
| **v1** | Stable — full CRUD | **501 Not Implemented** (feature added in v2) |
| **v2** | Stable — inherits v1 CRUD | **200 OK** — sum of all product prices |
| **v3** | **501 Not Implemented** — in development | **501 Not Implemented** |

### Products — CRUD

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/v1/products` | List all products (v1) |
| `GET` | `/api/v1/products/{id}` | Get a product by ID (v1) |
| `POST` | `/api/v1/products` | Create a product (v1) |
| `PUT` | `/api/v1/products/{id}` | Update a product (v1) |
| `DELETE` | `/api/v1/products/{id}` | Delete a product (v1) |

The same CRUD paths work for `/api/v2/products` (same behavior as v1). For `/api/v3/products`, all CRUD operations return **501** until v3 is implemented.

### Products — version-specific endpoint

| Method | Endpoint | v1 | v2 | v3 |
|--------|----------|----|----|-----|
| `GET` | `/api/v{n}/products/total-prices` | 501 | 200 | 501 |

**Example (v2):**

```bash
curl http://localhost:8080/api/v2/products/total-prices
```

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

**Error response** (501 / 404)

```json
{
  "url": "http://localhost:8080/api/v3/products",
  "errorMessage": "V3 version is currently in development..."
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
│   │   │   ├── error/exception/GlobalExceptionHandler.java
│   │   │   └── product/ProductController.java
│   │   ├── service/
│   │   │   ├── common/factory/VersionServiceFactory.java
│   │   │   └── product/
│   │   │       ├── factory/ProductServiceFactory.java
│   │   │       └── implementation/ProductServiceImplV1|V2|V3.java
│   │   ├── repository/
│   │   ├── model/
│   │   ├── dto/
│   │   └── utils/
│   │       ├── mapper/
│   │       └── versioning/
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
server.servlet.context-path=/api
```

The context path `/api` is prepended to all controller mappings. For example, `@RequestMapping("/v1/products")` is exposed as `/api/v1/products`.

## Author

Matheus Filipe Freitas
