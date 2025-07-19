# Semantic Release Setup

This project uses [semantic-release](https://github.com/semantic-release/semantic-release) for automated version management and publishing.

## How It Works

Semantic-release automatically:
- Determines the next version number based on commit messages
- Generates release notes
- Updates the version in `src/build.gradle.kts`
- Creates a new Git tag
- Builds and publishes the mod JAR
- Creates a GitHub release

## Commit Message Format

This project follows the [Angular Commit Message Guidelines](https://github.com/angular/angular/blob/main/contributing-docs/commit-message-guidelines.md).

### Format
```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types
- **feat**: A new feature
- **fix**: A bug fix
- **docs**: Documentation only changes
- **style**: Changes that do not affect the meaning of the code
- **refactor**: A code change that neither fixes a bug nor adds a feature
- **perf**: A code change that improves performance
- **test**: Adding missing tests or correcting existing tests
- **build**: Changes that affect the build system or external dependencies
- **ci**: Changes to CI configuration files and scripts
- **chore**: Other changes that don't modify src or test files

### Examples
```bash
feat: add new Ultra Beast IV candies
fix: resolve recipe conflict with other mods
docs: update installation instructions
feat!: remove deprecated candy types
```

### Breaking Changes
For breaking changes, add `!` after the type or include `BREAKING CHANGE:` in the footer:
```bash
feat!: remove deprecated API methods

BREAKING CHANGE: The old candy crafting system has been removed.
Use the new shard-based system instead.
```

## Release Types

| Commit Message | Release Type |
|---|---|
| `fix(pencil): stop graphite breaking` | Patch Release |
| `feat(pencil): add 'graphiteWidth' option` | Minor Release |
| `perf(pencil): remove graphiteWidth option`<br><br>`BREAKING CHANGE: The graphiteWidth option has been removed.` | Major Release |

## Setup

1. **Install dependencies**:
   ```bash
   npm install
   ```

2. **Set up git hooks** (optional):
   ```bash
   npm run prepare
   ```

3. **Configure GitHub repository**:
   - Ensure you have write access to the repository
   - The GITHUB_TOKEN is automatically provided by GitHub Actions

## Manual Release

To trigger a release manually:

1. Go to the [Actions tab](https://github.com/psbds/cobblemon-iv-candy/actions)
2. Select the "Release" workflow
3. Click "Run workflow"

## Development Workflow

1. **Create feature branch**:
   ```bash
   git checkout -b feature/new-candy-type
   ```

2. **Make changes and commit** using conventional format:
   ```bash
   git add .
   git commit -m "feat: add rainbow IV candy with special effects"
   ```

3. **Push and create PR**:
   ```bash
   git push origin feature/new-candy-type
   ```

4. **Merge to main/master** - this will trigger an automatic release

## Configuration Files

- `.releaserc.json` - semantic-release configuration
- `commitlint.config.js` - commit message linting rules
- `.github/workflows/release.yml` - GitHub Actions workflow
- `package.json` - Node.js dependencies and scripts

## Troubleshooting

### Release not triggered
- Check that commits follow the conventional format
- Ensure the commit contains a releasable change type (`feat`, `fix`, etc.)
- Verify the GitHub Actions workflow completed successfully

### Build failures
- Check the [Actions tab](https://github.com/psbds/cobblemon-iv-candy/actions) for error details
- Ensure all tests pass locally before pushing
- Verify Gradle wrapper is executable

### Version conflicts
- semantic-release manages versions automatically
- Never manually edit version numbers in `build.gradle.kts`
- If you need to skip a release, add `[skip ci]` to the commit message
