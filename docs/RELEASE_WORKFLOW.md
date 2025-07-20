# Release Workflow Documentation

## Overview

This repository uses an automated release workflow that creates pull requests for releases when code is pushed to the `develop` branch.

## Setup

### Initial Setup

If you don't have a `develop` branch yet, create one:

```bash
# Create and push develop branch from main
git checkout main
git pull origin main
git checkout -b develop
git push -u origin develop
```

### Branch Protection (Recommended)

Consider setting up branch protection rules:
1. Go to Settings → Branches in your GitHub repository
2. Add protection rules for `main` branch:
   - Require pull request reviews
   - Require status checks to pass
   - Restrict pushes to main branch

## How it Works

### 1. Create Release PR Workflow (`.github/workflows/create-release-pr.yml`)

**Trigger:** Push to `develop` branch

**What it does:**
1. Checks out the develop branch
2. Uses semantic-release to calculate the next version number based on conventional commits
3. If there are releasable changes, creates a PR from develop to main with the version number in the title
4. The PR includes a description of what will be released

**Example PR title:** `Release v1.2.3`

### 2. Release Workflow (`.github/workflows/release.yml`)

**Trigger:** Push to `main` or `master` branch (typically when the release PR is merged)

**What it does:**
1. Runs semantic-release to create the actual release
2. Builds the mod with Gradle
3. Creates GitHub release with release notes
4. Uploads the built JAR file as a release asset

## Version Calculation

The workflow uses semantic-release with conventional commit messages to determine version bumps:

- `fix:` → patch version (1.0.0 → 1.0.1)
- `feat:` → minor version (1.0.0 → 1.1.0)  
- `BREAKING CHANGE:` → major version (1.0.0 → 2.0.0)
- `docs:`, `refactor:`, `style:` → patch version (configured in `.releaserc.json`)

## Workflow

1. **Development:** Work on features/fixes in feature branches
2. **Integration:** Merge completed work to `develop` branch
3. **Release PR Creation:** Push to develop triggers automatic PR creation to main
4. **Review:** Review the generated release PR
5. **Release:** Merge the PR to main triggers the actual release
6. **Publication:** Release is published with built artifacts

## Manual Override

If needed, you can manually trigger releases:
- Go to Actions → Release Package → Run workflow
- Select the branch and run

## Troubleshooting

### No PR Created After Push to Develop

This usually means:
- No conventional commits since last release
- All commits are non-releasable (e.g., `chore:`, `ci:`, `test:`)
- Check the workflow logs for semantic-release output

### PR Created But No Version Number

- Verify semantic-release configuration in `.releaserc.json`
- Look at the workflow logs for error messages

### Release Failed

- Check that all required secrets are configured
- Verify Gradle build is working
- Ensure proper permissions are set in the workflow
