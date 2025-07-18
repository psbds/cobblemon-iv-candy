# Cobblemon IV Candy Wiki

This directory contains the GitHub Pages documentation for the Cobblemon IV Candy mod.

## Local Development

To run the documentation site locally:

1. Install Jekyll:
   ```bash
   gem install bundler jekyll
   ```

2. Install dependencies:
   ```bash
   bundle install
   ```

3. Serve the site:
   ```bash
   bundle exec jekyll serve
   ```

4. Open http://localhost:4000 in your browser

## File Structure

- `_config.yml` - Jekyll configuration
- `index.md` - Homepage
- `*.md` - Individual documentation pages
- `assets/` - CSS, images, and other assets (if needed)

## Contributing

To contribute to the documentation:

1. Edit the relevant `.md` files
2. Test changes locally using Jekyll
3. Submit a pull request

## Deployment

This site is automatically deployed to GitHub Pages when changes are pushed to the main branch.
