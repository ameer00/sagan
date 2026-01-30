# Demo Reset Instructions

To reset this demo to its original state for a fresh run of the agentic coding task (upgrading Java and Spring Boot), follow these steps:

## 1. Clean Up Git State

First, discard any local changes and switch back to the starting point.

```bash
# Discard all local changes
git reset --hard HEAD
git clean -fd

# Switch back to the main branch
git checkout main

# Delete the demo-specific branches (local and remote)
git branch -D java17-prep-checkpoint
git push origin --delete java17-prep-checkpoint

# If the agent created a PR branch, delete it as well
# git branch -D <pr-branch-name>
# git push origin --delete <pr-branch-name>
```

## 2. Close/Delete GitHub Pull Requests

If the agentic tool successfully created a Pull Request:
1. Navigate to the [Sagan Pull Requests](https://github.com/ameer00/sagan/pulls) page.
2. Close the Pull Request created during the demo.
3. (Optional) Delete the branch associated with the PR via the GitHub UI.

## 3. Reset Local Environment

Ensure no build artifacts or cached dependencies interfere with the next run.

```bash
# Remove Gradle build directories
./gradlew clean

# Clear the sagan-client node_modules (if necessary)
rm -rf sagan-client/node_modules
```

## 4. Verify Baseline

Ensure you are at the correct commit SHA before starting again. The starting point for this demo sequence was commit `b233b05b3993d60229f364c5a15d7a64d3b7987e`.

```bash
git log -1 b233b05b3993d60229f364c5a15d7a64d3b7987e
```
