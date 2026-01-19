# Implementation Plan - Upgrade to Spring Boot 3.x

## Phase 1: Java 17 Preparation
- [x] Task: specific - Update project-wide Java version configuration.
    - [x] Sub-task: Update `sourceCompatibility` and `targetCompatibility` to '17' in `build.gradle` (all modules).
    - [x] Sub-task: Update CI/CD configuration files (e.g., `concourse/pipeline.yml`) to use a JDK 17 image.
- [x] Task: specific - Verify build with Java 17 (pre-upgrade).
    - [x] Sub-task: Run `./gradlew clean build` with JDK 17 to ensure the current Spring Boot 2.7 app compiles on the newer JDK.
- [x] Task: Conductor - User Manual Verification 'Java 17 Preparation' (Protocol in workflow.md) [checkpoint: b233b05]

## Phase 2: Core Framework Upgrade & Jakarta Migration
- [ ] Task: specific - Bump Spring Boot version to latest 3.x.
    - [ ] Sub-task: Update `id 'org.springframework.boot'` version in `sagan-site/build.gradle` and `sagan-renderer/build.gradle`.
    - [ ] Sub-task: Update `io.spring.dependency-management` to the latest version.
- [ ] Task: specific - Perform Jakarta EE Migration (javax -> jakarta).
    - [ ] Sub-task: Use `grep` to find all `javax.persistence`, `javax.servlet`, `javax.validation`, `javax.annotation` imports.
    - [ ] Sub-task: Execute mass replacement of `javax.` with `jakarta.` for these specific packages using `sed` or `replace` tool.
    - [ ] Sub-task: Update `build.gradle` dependencies to switch from `javax.*` artifacts to `jakarta.*` (e.g., `jakarta.servlet-api`).
- [ ] Task: Conductor - User Manual Verification 'Core Framework Upgrade' (Protocol in workflow.md)

## Phase 3: Fix Compilation & Configuration
- [ ] Task: specific - Address Hibernate 6 / JPA Changes.
    - [ ] Sub-task: Fix any compilation errors related to `org.hibernate.dialect` (Dialect resolution is often different).
    - [ ] Sub-task: Verify `hibernate-java8` is removed (support is built-in now).
- [ ] Task: specific - Address Spring Security 6 Changes.
    - [ ] Sub-task: Update `SecurityConfig` to remove deprecated `WebSecurityConfigurerAdapter` if present (refactor to `SecurityFilterChain` bean).
    - [ ] Sub-task: Update `antMatchers` to `requestMatchers`.
- [ ] Task: specific - Fix Unit Tests.
    - [ ] Sub-task: Run `./gradlew test` and fix failures one by one.
- [ ] Task: Conductor - User Manual Verification 'Fix Compilation & Configuration' (Protocol in workflow.md)

## Phase 4: Final Verification
- [ ] Task: specific - Full System Regression.
    - [ ] Sub-task: Run `./gradlew clean build`.
    - [ ] Sub-task: Launch application (`bootRun`) and manually verify the homepage, login, and admin sections.
- [ ] Task: Conductor - User Manual Verification 'Final Verification' (Protocol in workflow.md)
