# Cobblemon IV Candy

A Minecraft mod that extends the [Cobblemon](https://cobblemon.com/) mod by adding an Individual Values (IV) enhancement system through craftable candies and shards.

## 📖 Documentation

**[📚 Visit the Complete Wiki](https://psbds.github.io/cobblemon-iv-candy/)**

The full documentation includes:
- **[Installation Guide](https://psbds.github.io/cobblemon-iv-candy/installation/)** - Step-by-step setup
- **[Items Reference](https://psbds.github.io/cobblemon-iv-candy/items/)** - Complete item documentation
- **[Crafting Recipes](https://psbds.github.io/cobblemon-iv-candy/recipes/)** - All crafting patterns
- **[Commands](https://psbds.github.io/cobblemon-iv-candy/commands/)** - Administrative commands
- **[Compatibility](https://psbds.github.io/cobblemon-iv-candy/compatibility/)** - Version compatibility info
- **[Development Guide](https://psbds.github.io/cobblemon-iv-candy/development/)** - For contributors

## ✨ Features

### 🔮 IV Shards System
- Collect shards from defeated Pokémon
- Different shard types: Species, Elemental, Legendary, Mythical, Ultra Beast, and Paradox
- Each shard type has unique crafting requirements

### 🍬 IV Candy Crafting
- Craft targeted IV candies for specific stats (HP, Attack, Defense, etc.)
- Create random IV candies for general stat improvements
- Super candies for enhanced effects

### ⚡ Smart Stat Enhancement
- Candies intelligently target stats that aren't maxed out
- Species-specific candies ensure compatibility
- Random candies provide flexible stat improvements

## 🚀 Quick Start

1. **Install Prerequisites:**
   - Minecraft 1.21.1
   - Fabric Loader 0.16.5+
   - Fabric API 0.104.0+1.21.1
   - Cobblemon 1.6.0+1.21.1-SNAPSHOT

2. **Download and Install:**
   - Download the latest release from [GitHub Releases](https://github.com/psbds/cobblemon-iv-candy/releases)
   - Place the `.jar` file in your `mods` folder
   - Start Minecraft with the Fabric profile

3. **Start Playing:**
   - Defeat Pokémon to collect IV Shards
   - Craft IV Candies using the recipes
   - Use candies on your Pokémon to enhance their IVs

## 📋 Requirements

| Component | Version | Status |
|-----------|---------|--------|
| **Minecraft** | 1.21.1 | Required |
| **Fabric Loader** | 0.16.5+ | Required |
| **Fabric API** | 0.104.0+1.21.1 | Required |
| **Cobblemon** | 1.6.0+1.21.1-SNAPSHOT | Required |
| **Fabric Language Kotlin** | 1.12.3+kotlin.2.0.21 | Recommended |

## 🏗️ Building from Source

```bash
# Clone the repository
git clone https://github.com/psbds/cobblemon-iv-candy.git
cd cobblemon-iv-candy

# Build the mod
./gradlew build  # On Windows: .\gradlew.bat build

# Find the built mod in src/build/libs/
```

For detailed development instructions, see the [Development Guide](https://psbds.github.io/cobblemon-iv-candy/development/).

## 🤝 Contributing

We welcome contributions! Please:

1. Read the [Development Guide](https://psbds.github.io/cobblemon-iv-candy/development/)
2. Fork the repository
3. Create a feature branch
4. Make your changes
5. Test thoroughly
6. Submit a pull request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔗 Links

- **[📚 Complete Wiki](https://psbds.github.io/cobblemon-iv-candy/)** - Full documentation
- **[🐛 Report Issues](https://github.com/psbds/cobblemon-iv-candy/issues)** - Bug reports and feature requests
- **[💬 Cobblemon Discord](https://discord.gg/cobblemon)** - Community support
- **[🌐 Cobblemon Website](https://cobblemon.com/)** - Main Cobblemon mod

## 📊 Project Status

- **Current Version**: 1.0.0-SNAPSHOT
- **Development Status**: Active
- **Compatibility**: Minecraft 1.21.1 + Cobblemon 1.6.0+

---

### Original Cobblemon MDK Information

This project was initially based on the Cobblemon MDK. Below is preserved information for reference:

### A cobblemon update released! What now?

The steps and effort needed for this depend on whether cobblemon has updated to a new Minecraft version.

#### Same Minecraft version

On the same minecraft version, the following steps would be an example of how to go about updating your mod:

- Try running your mod on the new cobblemon version without any changes and test it, it might be that your mod is compatible as-is and no changes are needed!
  - It might be that depending on your declaration of dependencies in your mod files, your mod loader of choice might say that your mod is not compatible, denying you the chance to test it
  - In that case, try changing the dependency declaration in your mod files temporarily so you can test it and verify it still works without further changes
- If your mod crashes or otherwise does not work as expect you will need to update your gradle configuration to target this new cobblemon release
  - To do that, go to your `build.gradle.kts` and look for the `dependencies` block
  - In there, you will find the declaration of cobblemon, change the version to match that new version you want to target (don't forget to update your mod files dependencies too!)
  - If your mod is based off the `Multi-Platform` mdk, refer to the `gradle.properties` file and update the versions declared in there instead
  - Refresh your gradle and fix any potential compile errors your IDE will tell you about
- Try running your mod again with the new cobblemon version
- If you continue to have issues, feel free to reach out in our cobblemon discord for further help

#### Different Minecraft version

Updating a mod to a different minecraft version can be of varying complexity depending on how many changes Minecraft itself did in those versions.
Your best bet is either reaching out directly for help in the cobblemon discord or refer back to the MDKs which are being updated as new versions of cobblemon get released.

## Links and more documentation

- [Cobblemon Website](https://cobblemon.com/)
- [Cobblemon Wiki](https://wiki.cobblemon.com/index.php/Main_Page)
- [Cobblemon Discord](https://discord.gg/cobblemon)
- [NeoForged Community Documentation](https://docs.neoforged.net/)  
- [NeoForged Discord](https://discord.neoforged.net/)
- [Fabric Documentation](https://docs.fabricmc.net/develop/)
- [Fabric Discord](https://discord.gg/v6v4pMv)
- [Architectury Loom Documentation](https://docs.architectury.dev/loom/introduction) - The core tooling to allow Minecraft modding in these MDKs