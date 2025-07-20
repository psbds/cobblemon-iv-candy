---
layout: default
title: Installation Guide
nav_order: 2
description: "Learn how to install the Cobblemon IV Candy mod"
permalink: /installation/
---

# Installation Guide

This guide will walk you through installing the Cobblemon IV Candy mod on your Minecraft server or client.

## Prerequisites

Before installing the Cobblemon IV Candy mod, ensure you have the following:

### Required Software
- **Minecraft Java Edition 1.21.1**
- **Fabric Loader 0.16.5** or later
- **Fabric API 0.104.0+1.21.1** or later
- **Cobblemon 1.6.0+1.21.1-SNAPSHOT** or later

### Optional Dependencies
- **Fabric Language Kotlin 1.12.3+kotlin.2.0.21** - Required for some advanced features

## Installation Steps

### For Players (Client Installation)

1. **Install Fabric Loader**
   - Download the Fabric installer from [fabricmc.net](https://fabricmc.net/use/installer/)
   - Run the installer and select Minecraft version 1.21.1
   - Install Fabric Loader to your Minecraft installation

2. **Download Required Mods**
   - Download [Fabric API](https://modrinth.com/mod/fabric-api) for Minecraft 1.21.1
   - Download [Cobblemon Fabric](https://modrinth.com/mod/cobblemon) version 1.6.0+
   - Download the latest Cobblemon IV Candy mod from our [releases page](https://github.com/psbds/cobblemon-iv-candy/releases)

3. **Install Mods**
   - Place all downloaded `.jar` files in your `mods` folder:
     - Windows: `%APPDATA%\.minecraft\mods\`
     - macOS: `~/Library/Application Support/minecraft/mods/`
     - Linux: `~/.minecraft/mods/`

4. **Launch Minecraft**
   - Select the Fabric profile in your Minecraft launcher
   - Start the game and verify all mods are loaded correctly

### For Server Administrators

1. **Set Up Fabric Server**
   - Download the Fabric server installer from [fabricmc.net](https://fabricmc.net/use/server/)
   - Follow the server installation guide for Fabric

2. **Install Dependencies**
   - Download and place these mods in your server's `mods` folder:
     - Fabric API 0.104.0+1.21.1
     - Fabric Language Kotlin 1.12.3+kotlin.2.0.21
     - Cobblemon Fabric 1.6.0+1.21.1-SNAPSHOT

3. **Install Cobblemon IV Candy**
   - Download the latest server-compatible version
   - Place the `.jar` file in your server's `mods` folder

4. **Configure Server**
   - Start the server to generate configuration files
   - Check the console for any errors during startup
   - Verify the mod is loaded correctly in the server log

## Building from Source

If you want to build the mod from source code:

### Prerequisites for Building
- **Java Development Kit (JDK) 21** or later
- **Git** for cloning the repository

### Build Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/psbds/cobblemon-iv-candy.git
   cd cobblemon-iv-candy
   ```

2. **Build the Mod**
   ```bash
   # On Windows
   .\gradlew.bat build
   
   # On macOS/Linux
   ./gradlew build
   ```

3. **Locate Built Files**
   - The compiled mod will be in `src/build/libs/`
   - Look for `Cobblemon_IV_Candy-[version].jar`

## Verification

After installation, verify the mod is working correctly:

1. **Check Mod List**
   - In-game, open the mods menu (if you have a mod menu mod installed)
   - Look for "Cobblemon IV Candy" in the list

2. **Test Basic Functionality**
   - Use the `/ivcandy` command (requires appropriate permissions)
   - Try spawning some Pokémon with Cobblemon to test shard collection

3. **Check Server Logs**
   - Look for "Booting Cobblemon IV Candy Mod" in the server console
   - Ensure no error messages related to the mod appear

## Troubleshooting

### Common Issues

**"Mod is not loading"**
- Verify all dependencies are installed
- Check that you're using the correct Minecraft version (1.21.1)
- Ensure Fabric Loader version is compatible

**"Cobblemon compatibility issues"**
- Make sure you have Cobblemon 1.6.0+ installed
- Verify the Cobblemon version matches the supported version

**"Missing Fabric API"**
- Download and install the correct Fabric API version
- Ensure it's placed in the mods folder

**"Server won't start"**
- Check server logs for specific error messages
- Verify Java version (requires Java 21+)
- Ensure all mod versions are compatible

### Getting Help

If you encounter issues:
1. Check the [GitHub Issues](https://github.com/psbds/cobblemon-iv-candy/issues) page
2. Join the [Cobblemon Discord](https://discord.gg/cobblemon) community
3. Provide detailed error logs when reporting issues

## Version Compatibility

| Cobblemon IV Candy | Minecraft | Cobblemon | Fabric API |
|-------------------|-----------|-----------|------------|
| 1.0.0-SNAPSHOT    | 1.21.1    | 1.6.0+    | 0.104.0+   |

*Always check the [releases page](https://github.com/psbds/cobblemon-iv-candy/releases) for the most up-to-date compatibility information.*
