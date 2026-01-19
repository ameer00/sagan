# Implementation Plan - Modernize Dependencies and Observability

## Phase 1: Analysis and Preparation
- [x] Task: specific - Analyze current `build.gradle` and identify all major outdated dependencies.
    - [x] Sub-task: Run `gradle dependencyUpdates` to get a report.
    - [x] Sub-task: List target versions for Spring Boot and key libraries.
- [x] Task: specific - Review Spring Boot 2.6 and 2.7 migration guides.
    - [x] Sub-task: Note any breaking changes related to configuration or specific modules used (Data, Security).
- [x] Task: Conductor - User Manual Verification 'Analysis and Preparation' (Protocol in workflow.md) [checkpoint: 3315328]

## Phase 2: Core Dependency Updates (Spring Boot 2.7.x)
- [~] Task: specific - Bump Spring Boot version to latest 2.7.x in `build.gradle` and `gradle/publications.gradle`.
    - [x] Sub-task: Create a reproduction test case that passes on current version.
    - [x] Sub-task: Update the version number.
    - [x] Sub-task: Fix immediate compilation errors.
- [x] Task: specific - Update third-party dependencies to compatible versions.
    - [x] Sub-task: Update `sagan-client/package.json` dependencies if needed for build compatibility.
- [x] Task: specific - Fix failing unit tests resulting from the upgrade.
    - [x] Sub-task: Run `./gradlew test` and address failures one by one.
- [x] Task: Conductor - User Manual Verification 'Core Dependency Updates' (Protocol in workflow.md) [checkpoint: ec30623]

## Phase 3: Observability Enhancements
- [x] Task: specific - Configure Actuator Endpoints.
    - [x] Sub-task: Create/Update `application.yml` (or properties) to expose `health`, `info`, `metrics`.
    - [x] Sub-task: Verify security settings (ensure sensitive endpoints are protected or internal-only).
- [~] Task: specific - Implement Redis Health Indicator.
    - [ ] Sub-task: Create `RedisHealthIndicator` test.
    - [ ] Sub-task: Implement the indicator to check Redis connection.
- [ ] Task: specific - Implement GitHub API Health Indicator (if applicable).
    - [ ] Sub-task: Check if `sagan-site` calls GitHub. If so, add health check.
- [ ] Task: Conductor - User Manual Verification 'Observability Enhancements' (Protocol in workflow.md)

## Phase 4: Final Verification
- [ ] Task: specific - Full System Regression Test.
    - [ ] Sub-task: Run full build `./gradlew clean build`.
    - [ ] Sub-task: Launch application locally and verify UI pages (Blog, Guides).
- [ ] Task: Conductor - User Manual Verification 'Final Verification' (Protocol in workflow.md)
