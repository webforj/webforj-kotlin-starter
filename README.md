# webforj-kotlin-starter

A starter project for building webforJ applications with the Kotlin DSL and Spring Boot.

## Prerequisites

- Java 21 or newer
- Maven 3.9+

## Getting Started

```bash
mvn
```

This runs the default goal (`compile webforj:watch spring-boot:run`), which compiles the
frontend sources in `src/main/frontend`, watches them for changes, and serves the app.

Then open [http://localhost:8080](http://localhost:8080) in your browser.

## Running Integration Tests

```bash
mvn verify
```

## Building for Production

```bash
mvn clean package -Pprod
java -jar target/webforj-kotlin-starter-1.0-SNAPSHOT.jar
```

## Learn More

- [Kotlin DSL Documentation](https://docs.webforj.com/docs/integrations/kotlin-dsl/overview)
- [Component Overview](https://docs.webforj.com/docs/components/overview)
