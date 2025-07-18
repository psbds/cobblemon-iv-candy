---
layout: page
title: "Items Reference"
permalink: /items/
nav_order: 2
---

# Items Reference

The Cobblemon IV Candy mod introduces two main items: **IV Shards** and **IV Candies**. These items work together to provide a comprehensive IV enhancement system for your Pokémon.

## IV Shards

IV Shards are the raw materials used to craft IV Candies. They are obtained when Pokémon faint and serve as the foundation for the candy crafting system.

### How to Obtain Shards

- **Pokémon Fainting**: When any Pokémon faints (wild or owned), it has a chance to drop a shard
- **Automatic Collection**: Shards are automatically generated based on the fainted Pokémon's characteristics
- **No Manual Crafting**: Shards cannot be crafted manually - they must be obtained from Pokémon

### Shard Types

#### 🔹 Species Shards
- **Description**: Specific to individual Pokémon species
- **Appearance**: Named after the base evolution (e.g., "Bulbasaur IV Shard")
- **Usage**: Used to create species-specific IV candies
- **Color**: Matches the primary type color of the Pokémon

#### 🌈 Elemental Type Shards
- **Description**: Based on Pokémon elemental types
- **Appearance**: Shows the type name (e.g., "Fire IV Shard [Fire]")
- **Usage**: Used to create type-specific IV candies
- **Available Types**: All 18 Pokémon types supported

#### 🌟 Legendary Shards
- **Description**: Obtained from Legendary Pokémon
- **Appearance**: "IV Shard Legendary"
- **Usage**: Creates candies that work on any Legendary Pokémon
- **Rarity**: Uncommon, only from Legendary encounters

#### ✨ Mythical Shards
- **Description**: Obtained from Mythical Pokémon
- **Appearance**: "IV Shard Mythical"
- **Usage**: Creates candies that work on any Mythical Pokémon
- **Rarity**: Very rare, only from Mythical encounters

#### 👽 Ultra Beast Shards
- **Description**: Obtained from Ultra Beast Pokémon
- **Appearance**: "IV Shard Ultra Beast"
- **Usage**: Creates candies that work on any Ultra Beast
- **Rarity**: Rare, only from Ultra Beast encounters

#### ⚡ Paradox Shards
- **Description**: Obtained from Paradox Pokémon
- **Appearance**: "IV Shard Paradox"
- **Usage**: Creates candies that work on any Paradox Pokémon
- **Rarity**: Very rare, only from Paradox encounters

### Shard Properties

Each shard contains the following data:
- **Shard Type**: Determines which candy type can be crafted
- **Species Data**: For species shards, stores the Pokédex number
- **Elemental Type**: For type shards, stores the type information
- **Visual Model**: Custom textures based on the shard type

## IV Candies

IV Candies are consumable items that enhance a Pokémon's Individual Values when used. They are crafted from IV Shards using specific recipes.

### How to Use Candies

1. **Right-click on a Pokémon**: While holding an IV Candy
2. **Compatibility Check**: The candy will verify it can be used on the target Pokémon
3. **Stat Enhancement**: If compatible, the candy will improve the Pokémon's IVs
4. **Consumption**: The candy is consumed after successful use

### Candy Types

#### 🎯 Targeted IV Candies
- **Description**: Enhance a specific IV stat (HP, Attack, Defense, etc.)
- **Creation**: Crafted using Super Candy recipes with stat-specific items
- **Effect**: Increases the specified IV by 1 point (up to maximum of 31)
- **Naming**: Shows the target stat in brackets (e.g., "Pikachu IV Candy [Attack]")

#### 🎲 Random IV Candies
- **Description**: Enhance a random IV stat that isn't maxed out
- **Creation**: Crafted using basic Candy recipes
- **Effect**: Randomly selects and improves a non-maxed IV stat
- **Naming**: Shows "[Random IV]" in the name

### Candy Compatibility

#### Species-Specific Candies
- **Source**: Created from Species Shards
- **Compatibility**: Only work on the specific Pokémon species (including evolutions)
- **Example**: A Bulbasaur candy works on Bulbasaur, Ivysaur, and Venusaur
- **Advantage**: More targeted approach

#### Type-Specific Candies
- **Source**: Created from Elemental Type Shards
- **Compatibility**: Work on any Pokémon of the matching type
- **Example**: A Fire candy works on any Fire-type Pokémon
- **Advantage**: More versatile usage

#### Category-Specific Candies
- **Source**: Created from Legendary/Mythical/Ultra Beast/Paradox Shards
- **Compatibility**: Work on any Pokémon in the respective category
- **Examples**: 
  - Legendary candies work on any Legendary Pokémon
  - Mythical candies work on any Mythical Pokémon
- **Advantage**: Extremely rare but highly valuable

### Candy Properties

Each candy contains the following data:
- **Candy Type**: Matches the source shard type
- **Species Data**: For species candies, stores compatibility information
- **Target IV Stat**: For targeted candies, specifies which stat to enhance
- **Visual Model**: Custom textures based on the candy type and target stat

## Item Interactions

### Debug Information
Both shards and candies support debug interactions:
- **Right-click on any entity**: While holding a shard or candy to see its properties
- **Console Output**: Technical information about the item's data components
- **Useful for**: Testing, debugging, and understanding item mechanics

### Visual Identification

#### Custom Model Data
- Each item type has unique visual appearances
- Colors correspond to elemental types or special categories
- Names clearly indicate the item's purpose and compatibility

#### Naming Convention
- **Shards**: `[Species/Type] IV Shard [Category]`
- **Candies**: `[Species/Type] IV Candy [Target Stat/Random IV]`

## Storage and Organization

### Inventory Management
- **Stackable**: Identical shards and candies stack together
- **Unique Items**: Different types/stats create separate item stacks
- **Storage**: Can be stored in any standard Minecraft container

### Sorting Tips
- Group shards by type (Species, Elemental, Special categories)
- Separate targeted candies by stat type
- Keep random candies for general use
- Store rare category shards (Legendary, Mythical) safely

## Item Data Technical Details

For developers and advanced users:

### Data Components
- **DataShard**: Stores shard type, species ID, and elemental type
- **DataCandy**: Stores candy type, species ID, elemental type, and target stat
- **CustomModelData**: Handles visual appearance and textures

### Registry Information
- **Mod ID**: `cobblemon_iv_candy`
- **Shard ID**: `shard`
- **Candy ID**: `candy`
- **Namespace**: All items are registered under the mod's namespace
