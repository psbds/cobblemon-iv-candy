---
layout: page
title: "Compatibility"
permalink: /compatibility/
nav_order: 5
---

# Compatibility Information

This page provides comprehensive compatibility information for the Cobblemon IV Candy mod, including supported versions, known conflicts, and integration details.

## Version Compatibility Matrix

### Current Supported Versions

| Component | Version | Status | Notes |
|-----------|---------|--------|-------|
| **Minecraft** | 1.21.1 | ✅ Fully Supported | Primary target version |
| **Fabric Loader** | 0.16.5+ | ✅ Fully Supported | Minimum required version |
| **Fabric API** | 0.104.0+1.21.1 | ✅ Fully Supported | Essential dependency |
| **Cobblemon** | 1.6.0+1.21.1-SNAPSHOT | ✅ Fully Supported | Core dependency |
| **Fabric Language Kotlin** | 1.12.3+kotlin.2.0.21 | ✅ Recommended | For enhanced features |

### Version History

#### Cobblemon IV Candy 1.0.0-SNAPSHOT
- **Release Date**: Development Version
- **Target Minecraft**: 1.21.1
- **Target Cobblemon**: 1.6.0+1.21.1-SNAPSHOT
- **Status**: Active Development

## Dependency Requirements

### Hard Dependencies
These mods are **required** for Cobblemon IV Candy to function:

#### Fabric Loader (0.16.5+)
- **Purpose**: Mod loading framework
- **Installation**: Required on both client and server
- **Download**: [fabricmc.net](https://fabricmc.net/)

#### Fabric API (0.104.0+1.21.1)
- **Purpose**: Core Fabric mod APIs
- **Installation**: Place in mods folder
- **Download**: [Modrinth](https://modrinth.com/mod/fabric-api) or [CurseForge](https://www.curseforge.com/minecraft/mc-mods/fabric-api)

#### Cobblemon Fabric (1.6.0+1.21.1-SNAPSHOT)
- **Purpose**: Core Pokémon functionality
- **Installation**: Place in mods folder
- **Download**: [Modrinth](https://modrinth.com/mod/cobblemon)

### Soft Dependencies
These mods enhance functionality but are not required:

#### Fabric Language Kotlin (1.12.3+kotlin.2.0.21)
- **Purpose**: Kotlin language support for advanced features
- **Benefits**: Enhanced mod compatibility and performance
- **Recommendation**: Highly recommended for servers

## Mod Compatibility

### Compatible Mods

#### Quality of Life Mods
- **JEI (Just Enough Items)**: ✅ Recipe viewing supported
- **REI (Roughly Enough Items)**: ✅ Recipe integration works
- **WAILA/Hwyla**: ✅ No conflicts reported
- **JourneyMap**: ✅ Compatible
- **Minimap mods**: ✅ Generally compatible

#### Performance Mods
- **Sodium**: ✅ Full compatibility
- **Lithium**: ✅ No known issues
- **Phosphor**: ✅ Compatible
- **Starlight**: ✅ Compatible
- **FerriteCore**: ✅ Compatible

#### Server Management
- **LuckPerms**: ✅ Command permissions supported
- **EssentialsX**: ✅ No conflicts
- **WorldGuard**: ✅ Compatible
- **GriefPrevention**: ✅ No known issues

#### Other Cobblemon Addons
- **Cobblemon Integrations**: ⚠️ Test before use
- **Custom Cobblemon Content**: ⚠️ Compatibility varies
- **Cobblemon Extensions**: ⚠️ Check individual mod compatibility

### Known Conflicts

#### Incompatible Mods
Currently, no mods are known to be completely incompatible.

#### Potential Issues
- **Heavy Recipe Mods**: May interfere with custom recipe types
- **Inventory Tweaks**: Could affect item sorting behavior
- **Custom Item Mods**: Might conflict with custom model data

### Testing Status

#### Extensively Tested
- ✅ Vanilla Minecraft 1.21.1
- ✅ Fabric Loader latest
- ✅ Cobblemon latest stable
- ✅ Common QoL mods

#### Limited Testing
- ⚠️ Modpack environments
- ⚠️ Custom server configurations
- ⚠️ Third-party Cobblemon addons

#### Untested
- ❓ Forge/NeoForge versions
- ❓ Older Minecraft versions
- ❓ Modified Cobblemon versions

## Server Compatibility

### Server Types

#### Vanilla Fabric Servers
- **Compatibility**: ✅ Full support
- **Requirements**: Standard Fabric setup
- **Performance**: Excellent

#### Modded Servers
- **Compatibility**: ✅ Generally compatible
- **Requirements**: Compatible mod selection
- **Performance**: Depends on mod load

#### Hosting Providers

#### Tested Platforms
- **Self-hosted**: ✅ Full compatibility
- **Pterodactyl Panel**: ✅ Works well
- **Multicraft**: ✅ Compatible
- **Local Development**: ✅ Excellent for testing

#### Popular Hosts
- **Apex Hosting**: ✅ Confirmed working
- **Shockbyte**: ✅ Compatible
- **BisectHosting**: ✅ No issues reported
- **PebbleHost**: ✅ Compatible

## Client Compatibility

### Operating Systems
- **Windows 10/11**: ✅ Fully supported
- **macOS**: ✅ Compatible
- **Linux**: ✅ All distributions
- **Steam Deck**: ✅ Compatible with Linux client

### Minecraft Launchers
- **Official Minecraft Launcher**: ✅ Full support
- **MultiMC**: ✅ Compatible
- **Prism Launcher**: ✅ Works well
- **ATLauncher**: ✅ Compatible
- **Technic Launcher**: ✅ Should work
- **CurseForge App**: ✅ Compatible

### Hardware Requirements
- **RAM**: 4GB minimum, 6GB+ recommended with Cobblemon
- **Storage**: 50MB additional space
- **CPU**: Any Java-compatible processor
- **GPU**: Standard Minecraft requirements apply

## Integration Details

### Recipe System Integration
- **Minecraft Recipe System**: Full integration
- **Recipe Book**: Appears in Miscellaneous category
- **JEI/REI**: Recipes visible in recipe viewers
- **Custom Recipe Types**: Uses mod-specific serializers

### Data Components
- **Minecraft Data System**: Uses official data component system
- **NBT Compatibility**: Backwards compatible where applicable
- **Networking**: Proper client-server synchronization

### Event System
- **Fabric Events**: Integrates with Fabric event system
- **Cobblemon Events**: Listens to Pokémon faint events
- **Server Lifecycle**: Proper initialization and cleanup

## Migration and Updates

### Updating the Mod

#### From Previous Versions
Currently, this is the initial release, so no migration is needed.

#### Future Updates
- **Data Preservation**: Item data should transfer between versions
- **Recipe Changes**: May require relearning recipes
- **Configuration**: Settings may reset with major updates

### Minecraft Version Updates
- **1.21.1 to 1.21.2**: Will be evaluated when available
- **Major Version Jumps**: Require mod updates
- **Beta Versions**: Not officially supported

### Cobblemon Updates
- **Same MC Version**: Usually compatible with minor updates
- **Major Cobblemon Changes**: May require mod updates
- **API Changes**: Could affect mod functionality

## Troubleshooting Compatibility

### Common Issues

#### "Mod won't load"
1. Check Minecraft version matches exactly
2. Verify all dependencies are installed
3. Ensure Fabric Loader version is compatible
4. Remove conflicting mods

#### "Recipe not working"
1. Verify JEI/REI shows the recipes
2. Check if recipe viewer mods are interfering
3. Test in vanilla environment
4. Update Fabric API

#### "Items not working properly"
1. Check for inventory management mod conflicts
2. Verify item data isn't being modified
3. Test without QoL mods
4. Report specific issues with logs

### Compatibility Testing

#### Before Adding Mods
1. **Backup your world** before installing new mods
2. **Test in creative mode** first
3. **Check mod descriptions** for known conflicts
4. **Monitor server logs** for error messages

#### Reporting Issues
When reporting compatibility issues:
1. **List all installed mods** with versions
2. **Provide error logs** from console
3. **Describe specific symptoms** in detail
4. **Include reproduction steps** if possible

## Future Compatibility Plans

### Planned Support
- **Minecraft 1.21.2+**: When stable versions are available
- **NeoForge Port**: Under consideration
- **Cobblemon Updates**: Continuous compatibility maintenance

### Community Requests
- **More Recipe Viewers**: Additional recipe mod integration
- **Server Management**: Enhanced admin tools
- **Modpack Integration**: Better default configurations

For the most up-to-date compatibility information, check our [GitHub Releases](https://github.com/psbds/cobblemon-iv-candy/releases) page.
