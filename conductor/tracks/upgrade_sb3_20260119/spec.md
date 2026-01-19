# Track Specification: Upgrade to Spring Boot 3.x

## Overview
This track focuses on upgrading the Sagan reference application from Spring Boot 2.7.18 to the latest stable Spring Boot 3.5.x version. This is a significant maintenance task that includes a Java version upgrade and the Jakarta EE package migration.

## Goals
- Upgrade Spring Boot to the latest stable 3.5.x release.
- Upgrade Java source and target compatibility to Java 17.
- Migrate all `javax.*` imports to `jakarta.*` where required by Jakarta EE 9/10.
- Update all managed and third-party dependencies to compatible versions.

## Functional Requirements
- The application must maintain its current feature set after the upgrade.
- All endpoints (site, admin, actuator) must remain functional.
- The `sagan-client` (frontend) build must remain compatible with the updated backend modules.

## Non-Functional Requirements
- **Java 17 Compliance:** The code must compile and run on JDK 17.
- **Observability:** Actuator endpoints and health indicators must continue to function correctly.
- **Build Stability:** The build system (Gradle) must be updated to a version compatible with Spring Boot 3 and Java 17.

## Acceptance Criteria
- [ ] `./gradlew clean build` completes successfully using Java 17.
- [ ] All unit and integration tests pass.
- [ ] The application starts up correctly (`bootRun`).
- [ ] All `javax.*` imports related to servlet, persistence, and validation are replaced with `jakarta.*`.
- [ ] Spring Security configuration is updated to the Spring Boot 3/Spring Security 6 style if necessary.

## Out of Scope
- Adding new functional features to the application.
- UI/UX redesign.
- Full migration to Spring Boot 4.x (if applicable, we target 3.x first).
