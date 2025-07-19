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
- Collect shards from defeated Pokémon, which you can use to make IV Candies
   - ![Species IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_normal.png) 
      **Species IV Shard**: Dropped by any non legendary, mythical, ultrabeast or paradox Pokémon
   - **Elemental IV Shards**:
      - ![Fire IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_fire.png) **Fire**: Dropped by Fire-type Pokémon
      - ![Water IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_water.png) **Water**: Dropped by Water-type Pokémon
      - ![Grass IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_grass.png) **Grass**: Dropped by Grass-type Pokémon
      - ![Electric IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_electric.png) **Electric**: Dropped by Electric-type Pokémon
      - ![Ice IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ice.png) **Ice**: Dropped by Ice-type Pokémon
      - ![Rock IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_rock.png) **Rock**: Dropped by Rock-type Pokémon
      - ![Ground IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ground.png) **Ground**: Dropped by Ground-type Pokémon
      - ![Flying IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_flying.png) **Flying**: Dropped by Flying-type Pokémon
      - ![Psychic IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_psychic.png) **Psychic**: Dropped by Psychic-type Pokémon
      - ![Bug IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_bug.png) **Bug**: Dropped by Bug-type Pokémon
      - ![Poison IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_poison.png) **Poison**: Dropped by Poison-type Pokémon
      - ![Fighting IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_fighting.png) **Fighting**: Dropped by Fighting-type Pokémon
      - ![Ghost IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ghost.png) **Ghost**: Dropped by Ghost-type Pokémon
      - ![Dragon IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_dragon.png) **Dragon**: Dropped by Dragon-type Pokémon
      - ![Dark IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_dark.png) **Dark**: Dropped by Dark-type Pokémon
      - ![Steel IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_steel.png) **Steel**: Dropped by Steel-type Pokémon
      - ![Fairy IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_fairy.png) **Fairy**: Dropped by Fairy-type Pokémon
      - ![Normal IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_normal.png) **Normal**: Dropped by Normal-type Pokémon
   
   - **Special IV Shards**:
      - ![Legendary IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_legendary.png) **Legendary** - Dropped by Legendary Pokémon
      - ![Mythical IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_mythical.png) **Mythical** - Dropped by Mythical Pokémon
      - ![Ultra Beast IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ultrabeast.png) **Ultra Beast** - Dropped by Ultra Beast Pokémon
      - ![Paradox IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_paradox.png) **Paradox** - Dropped by Paradox Pokémon


### 🍬 IV Candy System
- Craft targeted IV candies for specific stats (HP, Attack, Defense, etc.) or Random IV candies for general improvements

   - ![Species IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_normal.png) 
      **Species IV Candy**: Crafted by using ![Species IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_normal.png) Species IV Shards
   - **Elemental IV Candys**:
      - ![Fire IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_fire.png) **Fire**: Crafted using ![Fire IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_fire.png) Fire IV Shards
      - ![Water IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_water.png) **Water**: Crafted using ![Water IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_water.png) Water IV Shards
      - ![Grass IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_grass.png) **Grass**: Crafted using ![Grass IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_grass.png) Grass IV Shards
      - ![Electric IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_electric.png) **Electric**: Crafted using ![Electric IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_electric.png) Electric IV Shards
      - ![Ice IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_ice.png) **Ice**: Crafted using ![Ice IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ice.png) Ice IV Shards
      - ![Rock IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_rock.png) **Rock**: Crafted using ![Rock IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_rock.png) Rock IV Shards
      - ![Ground IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_ground.png) **Ground**: Crafted using ![Ground IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ground.png) Ground IV Shards
      - ![Flying IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_flying.png) **Flying**: Crafted using ![Flying IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_flying.png) Flying IV Shards
      - ![Psychic IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_psychic.png) **Psychic**: Crafted using ![Psychic IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_psychic.png) Psychic IV Shards
      - ![Bug IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_bug.png) **Bug**: Crafted using ![Bug IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_bug.png) Bug IV Shards
      - ![Poison IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_poison.png) **Poison**: Crafted using ![Poison IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_poison.png) Poison IV Shards
      - ![Fighting IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_fighting.png) **Fighting**: Crafted using ![Fighting IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_fighting.png) Fighting IV Shards
      - ![Ghost IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_ghost.png) **Ghost**: Crafted using ![Ghost IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ghost.png) Ghost IV Shards
      - ![Dragon IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_dragon.png) **Dragon**: Crafted using ![Dragon IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_dragon.png) Dragon IV Shards
      - ![Dark IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_dark.png) **Dark**: Crafted using ![Dark IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_dark.png) Dark IV Shards
      - ![Steel IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_steel.png) **Steel**: Crafted using ![Steel IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_steel.png) Steel IV Shards
      - ![Fairy IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_fairy.png) **Fairy**: Crafted using ![Fairy IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_fairy.png) Fairy IV Shards
      - ![Normal IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_normal.png) **Normal**: Crafted using ![Normal IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_normal.png) Normal IV Shards
   
   - **Special IV Candys**:
      - ![Legendary IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_legendary.png) **Legendary** - Crafted using ![Legendary IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_legendary.png) Legendary IV Shards
      - ![Mythical IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_mythical.png) **Mythical** - Crafted using ![Mythical IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_mythical.png) Mythical IV Shards
      - ![Ultra Beast IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_ultrabeast.png) **Ultra Beast** - Crafted using ![Ultra Beast IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_ultrabeast.png) Ultra Beast IV Shards
      - ![Paradox IV Candy](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/candies/candy_paradox.png) **Paradox** - Crafted using ![Paradox IV Shard](src/src/main/resources/assets/cobblemon_iv_candy/textures/item/shards/shard_paradox.png) Paradox IV Shards

### ⚡ Smart Stat Enhancement
- When crafting your IV Candies, you can choose between spending less shards to get a random IV or use more to set the IV of your choice

#### Random IV Crafting
   ![Ultra Beast Random IV Candy Recipe](docs/assets/images/recipes/recipe_random_candy_ultrabeast.png)

#### Target IV Crafting
   ![Ultra Beast Attack IV Candy Recipe](docs/assets/images/recipes/recipe_atk_candy_ultrabeast.png)

   ![Ultra Beast HP IV Candy Recipe](docs/assets/images/recipes/recipe_hp_candy_ultrabeast.png)

Check  **[Crafting Recipes](https://psbds.github.io/cobblemon-iv-candy/recipes/)** for all crafting patterns

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
- **[🌐 Cobblemon Website](https://cobblemon.com/)** - Main Cobblemon mod