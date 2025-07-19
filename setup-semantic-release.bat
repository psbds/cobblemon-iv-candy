@echo off
REM Script to prepare the project for semantic-release

echo Setting up semantic-release for Cobblemon IV Candy...

REM Install npm dependencies
echo Installing Node.js dependencies...
call npm install

REM Set up husky git hooks
echo Setting up git hooks...
call npx husky install
call npx husky add .husky/commit-msg "npx --no -- commitlint --edit %%1"

echo ✅ Semantic-release setup complete!
echo.
echo 📋 Next steps:
echo 1. Make sure you have a GITHUB_TOKEN secret set in your repository
echo 2. Use conventional commit messages (feat:, fix:, docs:, etc.)
echo 3. Push to main/master branch to trigger automatic releases
echo.
echo 📖 Commit message examples:
echo   feat: add new IV candy types
echo   fix: resolve crafting recipe issue
echo   docs: update installation guide
echo   BREAKING CHANGE: remove deprecated API

pause
