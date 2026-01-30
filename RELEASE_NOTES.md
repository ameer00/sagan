# Release Notes - Modernization Phase

This release includes significant updates to modernize the Sagan application, following its transition to a reference application.

## Key Changes

### Framework & Build Updates
- **Spring Boot 3.5.9 Upgrade**: Updated the core framework to the latest stable version, bringing performance improvements and security updates.
- **Jakarta EE Migration**: Migrated from `javax.*` to `jakarta.*` namespaces to support modern Java ecosystems.
- **Gradle 8.12 Upgrade**: Refreshed the build system for better performance and compatibility with modern tooling.
- **Java 17 Preparation**: Foundational changes to ensure the codebase takes full advantage of Java 17 features.

### Observability & Health
- **Actuator Integration**: Configured Spring Boot Actuator for better monitoring of the application state.
- **GitHub Health Indicator**: Added a custom health indicator to monitor connectivity and status with GitHub services.

### Documentation & Maintenance
- **Conductor Setup**: Integrated `conductor` for better workflow management and tracking of modernization phases.
- **Cleanup**: Removed deprecated SP1 banners and disabled admin UI in production environments as part of the archival process.
