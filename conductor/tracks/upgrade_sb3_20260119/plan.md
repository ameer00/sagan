# Implementation Plan - Upgrade to Spring Boot 3.5.x

## Phase 1: Java 17 Preparation
...
## Phase 2: Core Framework Upgrade & Jakarta Migration
- [x] Task: specific - Bump Spring Boot version to latest 3.5.x.
    - [x] Sub-task: Update `id 'org.springframework.boot'` version in `sagan-site/build.gradle` and `sagan-renderer/build.gradle`.
    - [x] Sub-task: Update `io.spring.dependency-management` to the latest version.
- [x] Task: specific - Perform Jakarta EE Migration (javax -> jakarta).
    - [x] Sub-task: Use `grep` to find all `javax.persistence`, `javax.servlet`, `javax.validation`, `javax.annotation` imports.
    - [x] Sub-task: Execute mass replacement of `javax.` with `jakarta.` for these specific packages using `sed` or `replace` tool.
    - [x] Sub-task: Update `build.gradle` dependencies to switch from `javax.*` artifacts to `jakarta.*` (e.g., `jakarta.servlet-api`).
- [x] Task: Conductor - User Manual Verification 'Core Framework Upgrade' (Protocol in workflow.md)

## Phase 3: Fix Compilation & Configuration
- [x] Task: specific - Address Hibernate 6 / JPA Changes.
    - [x] Sub-task: Fix any compilation errors related to `org.hibernate.dialect` (Dialect resolution is often different).
    - [x] Sub-task: Verify `hibernate-java8` is removed (support is built-in now).
- [x] Task: specific - Address Spring Security 6 Changes.
    - [x] Sub-task: Update `SecurityConfig` to remove deprecated `WebSecurityConfigurerAdapter` if present (refactor to `SecurityFilterChain` bean).
    - [x] Sub-task: Update `antMatchers` to `requestMatchers`.
- [x] Task: specific - Fix Unit Tests.
    - [x] Sub-task: Run `./gradlew test` and fix failures one by one.
- [x] Task: Conductor - User Manual Verification 'Fix Compilation & Configuration' (Protocol in workflow.md)

## Phase 4: Final Verification
- [x] Task: specific - Full System Regression.
    - [x] Sub-task: Run `./gradlew clean build`.
    - [x] Sub-task: Launch application (`bootRun`) and manually verify the homepage, login, and admin sections.
- [x] Task: Conductor - User Manual Verification 'Final Verification' (Protocol in workflow.md)
