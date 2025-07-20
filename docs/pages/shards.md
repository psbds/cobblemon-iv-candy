---
layout: default
title: IV Shards
nav_order: 4
description: "Learn about IV shards - the raw materials for IV enhancement"
permalink: /shards/
---

# IV Shards
{: .no_toc }

IV Shards are the raw materials used to craft IV Candies. They are obtained when Pokémon faint and serve as the foundation for the candy crafting system.

## Table of contents
{: .no_toc .text-delta }

1. TOC
{:toc}

---

## How to Obtain Shards

- **Pokémon Fainting**: When any Pokémon faints (wild or owned), it has a chance to drop a shard
- **Automatic Collection**: Shards are automatically generated based on the fainted Pokémon's characteristics
- **No Manual Crafting**: Shards cannot be crafted manually - they must be obtained from Pokémon
- **Drop Rates**: Configurable through the mod's configuration file (see [Configuration Guide](configuration.html))

---

## Shard Types

### 🔹 Species Shards
- **Description**: Specific to individual Pokémon species
- **Appearance**: Named after the base evolution (e.g., "Bulbasaur IV Shard")
- **Drop Source**: Regular (non-special category) Pokémon
- **Usage**: Used to create species-specific IV candies
- **Color**: Matches the primary type color of the Pokémon
- **Compatibility**: Works on the entire evolution line

### 🌈 Elemental Type Shards
- **Description**: Based on Pokémon elemental types
- **Appearance**: Shows the type name (e.g., "Fire IV Shard [Fire]")
- **Drop Source**: Any Pokémon of the corresponding type
- **Usage**: Used to create type-specific IV candies
- **Available Types**: All 18 Pokémon types supported
- **Dual Types**: Pokémon with dual types can drop shards for both types

#### Available Elemental Types
| Type | Shard Name | Dropped By |
|------|------------|------------|
| ![Normal](assets/images/items/shards/shard_normal.png) | Normal IV Shard | Normal-type Pokémon |
| ![Fire](assets/images/items/shards/shard_fire.png) | Fire IV Shard | Fire-type Pokémon |
| ![Water](assets/images/items/shards/shard_water.png) | Water IV Shard | Water-type Pokémon |
| ![Grass](assets/images/items/shards/shard_grass.png) | Grass IV Shard | Grass-type Pokémon |
| ![Electric](assets/images/items/shards/shard_electric.png) | Electric IV Shard | Electric-type Pokémon |
| ![Ice](assets/images/items/shards/shard_ice.png) | Ice IV Shard | Ice-type Pokémon |
| ![Fighting](assets/images/items/shards/shard_fighting.png) | Fighting IV Shard | Fighting-type Pokémon |
| ![Poison](assets/images/items/shards/shard_poison.png) | Poison IV Shard | Poison-type Pokémon |
| ![Ground](assets/images/items/shards/shard_ground.png) | Ground IV Shard | Ground-type Pokémon |
| ![Flying](assets/images/items/shards/shard_flying.png) | Flying IV Shard | Flying-type Pokémon |
| ![Psychic](assets/images/items/shards/shard_psychic.png) | Psychic IV Shard | Psychic-type Pokémon |
| ![Bug](assets/images/items/shards/shard_bug.png) | Bug IV Shard | Bug-type Pokémon |
| ![Rock](assets/images/items/shards/shard_rock.png) | Rock IV Shard | Rock-type Pokémon |
| ![Ghost](assets/images/items/shards/shard_ghost.png) | Ghost IV Shard | Ghost-type Pokémon |
| ![Dragon](assets/images/items/shards/shard_dragon.png) | Dragon IV Shard | Dragon-type Pokémon |
| ![Dark](assets/images/items/shards/shard_dark.png) | Dark IV Shard | Dark-type Pokémon |
| ![Steel](assets/images/items/shards/shard_steel.png) | Steel IV Shard | Steel-type Pokémon |
| ![Fairy](assets/images/items/shards/shard_fairy.png) | Fairy IV Shard | Fairy-type Pokémon |

### 🌟 Legendary Shards
- **Description**: Obtained from Legendary Pokémon
- **Appearance**: "IV Shard Legendary"
- **Drop Source**: Any Legendary Pokémon
- **Usage**: Creates candies that work on any Legendary Pokémon
- **Rarity**: Uncommon, only from Legendary encounters
- **Default Drop Rate**: 100% (configurable)

### ✨ Mythical Shards
- **Description**: Obtained from Mythical Pokémon
- **Appearance**: "IV Shard Mythical"
- **Drop Source**: Any Mythical Pokémon
- **Usage**: Creates candies that work on any Mythical Pokémon
- **Rarity**: Very rare, only from Mythical encounters
- **Default Drop Rate**: 100% (configurable)

### 👽 Ultra Beast Shards
- **Description**: Obtained from Ultra Beast Pokémon
- **Appearance**: "IV Shard Ultra Beast"
- **Drop Source**: Any Ultra Beast Pokémon
- **Usage**: Creates candies that work on any Ultra Beast
- **Rarity**: Rare, only from Ultra Beast encounters
- **Default Drop Rate**: 100% (configurable)

### ⚡ Paradox Shards
- **Description**: Obtained from Paradox Pokémon
- **Appearance**: "IV Shard Paradox"
- **Drop Source**: Any Paradox Pokémon
- **Usage**: Creates candies that work on any Paradox Pokémon
- **Rarity**: Very rare, only from Paradox encounters
- **Default Drop Rate**: 100% (configurable)

---

## Shard Properties

Each shard contains the following data:
- **Shard Type**: Determines which candy type can be crafted
- **Species Data**: For species shards, stores the Pokédex number
- **Elemental Type**: For type shards, stores the type information
- **Visual Model**: Custom textures based on the shard type
- **Unique Identifier**: Ensures proper stacking and identification

---

## Drop Mechanics

### Drop Priority System
When a Pokémon faints, the mod checks for drops in this order:
1. **Special category drops** (Legendary/Mythical/Ultra Beast/Paradox) - these override species drops
2. **Type-specific drops** - checked for all Pokémon regardless of category
3. **Species drops** - only for regular (non-special) Pokémon

### Dual-Type Pokémon
Pokémon with dual types have separate chances to drop shards for each of their types:
- Each type is rolled independently
- A single Pokémon can potentially drop multiple type shards
- Example: A Fire/Flying Pokémon can drop both Fire and Flying shards

### Configuration Impact
All drop rates and amounts are configurable:
- **Species drops**: Default 10% chance, 1 shard
- **Type drops**: Default 5% chance, 1 shard  
- **Special category drops**: Default 100% chance, 1 shard
- See [Configuration Guide](configuration.html) for customization options

---

## Storage and Organization

### Inventory Management
- **Stackable**: Identical shards stack together up to 64
- **Unique Items**: Different types create separate item stacks
- **Storage**: Can be stored in any standard Minecraft container
- **Shulker Boxes**: Compatible for large-scale storage

### Sorting Tips
- **By Category**: Group Species, Elemental, and Special shards separately
- **By Type**: Sort elemental shards by type for easy access
- **By Rarity**: Keep rare special category shards in secure storage
- **By Usage**: Organize based on your current IV enhancement projects

---

## Debug and Testing

### Debug Information
Shards support debug interactions for testing and development:
- **Right-click on any entity**: While holding a shard to see its properties
- **Console Output**: Technical information about the shard's data components
- **Useful for**: Testing drop mechanics, debugging compatibility issues

### Visual Identification

#### Custom Model Data
- Each shard type has unique visual appearances
- Colors correspond to elemental types or special categories
- Textures are designed for easy visual identification

#### Naming Convention
- **Species Shards**: `[Species Name] IV Shard`
- **Elemental Shards**: `[Type] IV Shard [Type]`
- **Special Shards**: `IV Shard [Category]`

---

## Technical Details

For developers and advanced users:

### Data Components
- **DataShard**: Stores shard type, species ID, and elemental type
- **CustomModelData**: Handles visual appearance and textures
- **NBT Data**: Preserved for mod compatibility and data persistence

### Registry Information
- **Mod ID**: `cobblemon_iv_candy`
- **Item ID**: `shard`
- **Namespace**: `cobblemon_iv_candy:shard`
- **Max Stack Size**: 64

### Compatibility
- **Cobblemon Integration**: Full compatibility with Cobblemon's Pokémon system
- **Data Persistence**: Shard data survives world saves and loads
- **Mod Compatibility**: Designed to work alongside other Cobblemon addons
