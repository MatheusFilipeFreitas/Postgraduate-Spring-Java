# Postgraduate Spring Java

Spring Boot project for the postgraduate course, built with Java and Maven.

## Tech stack

- **Java 25**
- **Spring Boot 4.1.0**
- **Spring Web MVC** — REST and web endpoints
- **Spring Boot DevTools** — faster development with automatic restarts
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

## Project structure

```
src/
├── main/
│   ├── java/com/mathffreitas/spring/
│   │   └── UnipdsSpringApplication.java   # Application entry point
│   └── resources/
│       └── application.properties         # App configuration
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
