# GitHub Pages Setup Instructions

## Automatic Setup (Recommended)

The repository now includes GitHub Actions workflow that will automatically deploy the GitHub Pages site. Here's what you need to do:

### 1. Push the Changes
```bash
git push origin master
```

### 2. Enable GitHub Pages
1. Go to your repository on GitHub: https://github.com/psbds/cobblemon-iv-candy
2. Click on **Settings** tab
3. Scroll down to **Pages** section in the left sidebar
4. Under **Source**, select **GitHub Actions**
5. The workflow will automatically deploy your site

### 3. Access Your Wiki
Once deployed, your wiki will be available at:
**https://psbds.github.io/cobblemon-iv-candy/**

## Manual Setup (Alternative)

If you prefer manual setup:

### 1. Enable GitHub Pages
1. Go to repository **Settings** → **Pages**
2. Under **Source**, select **Deploy from a branch**
3. Choose **master** branch and **/ (root)** folder
4. Click **Save**

### 2. Configure Build Source
1. Change source to **GitHub Actions**
2. The workflow will handle the rest

## Verifying the Setup

### Check GitHub Actions
1. Go to **Actions** tab in your repository
2. You should see "Deploy GitHub Pages" workflow
3. It should run automatically when you push changes to docs/

### Check the Site
1. Visit https://psbds.github.io/cobblemon-iv-candy/
2. Verify all pages load correctly
3. Check navigation and styling

## Troubleshooting

### If the site doesn't appear:
1. Check the Actions tab for any failed builds
2. Verify GitHub Pages is enabled in Settings
3. Make sure the source is set to "GitHub Actions"
4. Wait 5-10 minutes for initial deployment

### If styling is broken:
1. Check that the baseurl is set correctly in _config.yml
2. Verify the CSS file is being loaded
3. Clear browser cache

### If pages are missing:
1. Check that all .md files are in the docs/ folder
2. Verify the navigation links in _config.yml
3. Make sure permalink settings are correct

## Local Development

To test the site locally:

```bash
cd docs
bundle install
bundle exec jekyll serve
```

Then visit http://localhost:4000

## Updating Documentation

To update the wiki:
1. Edit the .md files in the docs/ folder
2. Commit and push changes
3. GitHub Actions will automatically redeploy the site

Your comprehensive Cobblemon IV Candy wiki is now ready!
