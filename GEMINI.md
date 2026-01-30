# Sagan Project Overview

**Repository:** [https://github.com/ameer00/sagan](https://github.com/ameer00/sagan)

Sagan is the application powering [spring.io](https://spring.io). It serves as a real-world reference application for the Spring team's best practices, demonstrating how to implement a complex, high-traffic site using the Spring ecosystem.

## Architecture

Sagan is a multi-module Gradle project built with Java 17 and Spring Boot 3. It follows a microservices-lite architecture with a main site and a separate rendering service.

### Modules

- **`sagan-site`**: The core Spring Boot application. It handles the blog, guides, project metadata, and team information. It uses Spring Data JPA for persistence and Redis for caching.
- **`sagan-renderer`**: A dedicated service for rendering Asciidoctor and Markdown content, used primarily for guides and reference documentation.
- **`sagan-client`**: Manages frontend assets (JavaScript, CSS, Images). It uses Webpack 4, Sass, and Bulma. Gradle triggers the Node.js build, and the resulting assets are packaged into a JAR used by `sagan-site`.

## Key Technologies

- **Backend**: Java 17, Spring Boot 3.5.9, Spring Security (OAuth2 for Admin), Spring Data JPA, Hibernate.
- **Frontend**: JavaScript (jQuery), Sass, Bulma CSS framework, Webpack 4.
- **Database**: MySQL (Production), H2 (Local/Testing), Flyway for migrations.
- **Caching**: Redis.
- **Rendering**: Asciidoctor, Pegdown.

## Building and Running

### Prerequisites

- Java 17 or higher.
- Docker (optional, for Redis/MySQL if not using `standalone` profile).
- Node.js 14.x (managed by Gradle for `sagan-client`).

### Commands

- **Build everything**:
  ```bash
  ./gradlew build
  ```
- **Run the main site (localhost:8080)**:
  ```bash
  ./gradlew :sagan-site:bootRun --args='--spring.profiles.active=standalone'
  ```
  *The `standalone` profile uses an in-memory H2 database.*
- **Run the renderer (localhost:8081)**:
  ```bash
  ./gradlew :sagan-renderer:bootRun
  ```
- **Test everything**:
  ```bash
  ./gradlew test
  ```

## Development Conventions

- **Coding Style**: The project follows Spring Framework coding conventions. Formatting and import organization profiles are located in the `style/` directory.
- **Database Migrations**: Database changes must be implemented via Flyway migration scripts in `sagan-site/src/main/resources/db/migration`.
- **Testing**: JUnit 5 is the standard testing framework. Integration tests often use Testcontainers.
- **Frontend**: Frontend source code is in `sagan-client/src`. Changes here require a rebuild of `sagan-client` (handled automatically by `:sagan-site:bootRun` if using `devtools`).
- **Commits**: Follow standard Git commit guidelines; see [CONTRIBUTING.md](CONTRIBUTING.md).
