# Dynamic Candy Template System

This document explains the new dynamic template system for the Cobblemon IV Candy mod that allows creating all combinations of elemental types, special categories, and IV stats without requiring hundreds of individual model files.

## Overview

The dynamic template system uses:
- **Layered textures**: Base candy texture (layer0) + stat overlay (layer1)
- **Mathematical custom model data**: Formula-based ID generation
- **Template model files**: Reusable model definitions
- **Automated generation**: Scripts to create all combinations

## File Structure

```
assets/cobblemon_iv_candy/
├── models/item/
│   ├── candy.json (or candy_dynamic.json)    # Main model with overrides
│   └── dynamic/                               # Template model files
│       ├── fire_hp.json
│       ├── fire_attack.json
│       ├── legendary_hp.json
│       ├── mythical_speed.json
│       └── ... (154 total combinations)
└── textures/item/
    ├── candies/                               # Base candy textures
    │   ├── candy_fire.png
    │   ├── candy_water.png
    │   ├── candy_legendary.png
    │   ├── candy_mythical.png
    │   ├── candy_ultrabeast.png
    │   ├── candy_paradox.png
    │   └── ...
    └── stats/                                 # Stat overlay textures
        ├── stat_hp.png
        ├── stat_attack.png
        ├── stat_defense.png
        ├── stat_special_attack.png
        ├── stat_special_defense.png
        ├── stat_speed.png
        └── stat_random.png
```

## Custom Model Data Formulas

The system uses mathematical formulas to generate unique custom model data values:

### Elemental Type Candies
```
Custom Model Data = 1000 + (typeId × 10) + statId
```

### Special Category Candies
```
Legendary:   Custom Model Data = 2000 + statId
Mythical:    Custom Model Data = 3000 + statId
Ultra Beast: Custom Model Data = 4000 + statId
Paradox:     Custom Model Data = 5000 + statId
```

### Type IDs (based on ElementalTypeMap.java)
- Fire: 0, Water: 1, Grass: 2, Electric: 3, Ice: 4, Rock: 5
- Ground: 6, Flying: 7, Psychic: 8, Bug: 9, Poison: 10, Fighting: 11  
- Ghost: 12, Dragon: 13, Dark: 14, Steel: 15, Fairy: 16, Normal: 17

### Stat IDs
- Random: 0, HP: 1, Attack: 2, Defense: 3
- Special Attack: 4, Special Defense: 5, Speed: 6

### Examples
**Elemental Types:**
- Fire + HP = 1000 + (0 × 10) + 1 = **1001**
- Water + Attack = 1000 + (1 × 10) + 2 = **1012**
- Dragon + Speed = 1000 + (13 × 10) + 6 = **1136**

**Special Categories:**
- Legendary + HP = 2000 + 1 = **2001**
- Mythical + Attack = 3000 + 2 = **3002**
- Ultra Beast + Defense = 4000 + 3 = **4003**
- Paradox + Speed = 5000 + 6 = **5006**

## Usage in Code

### Updated CandyModel.java

```java
// Elemental type + stat combination
int modelData = CandyModel.getCandyWithStatCustomModelData(
    ElementalTypes.INSTANCE.getFIRE(), 
    Stats.HP
);

// Special category + stat combination
int legendaryHP = CandyModel.getLegendaryCandyWithStatCustomModelData(Stats.HP);
int mythicalRandom = CandyModel.getMythicalCandyWithRandomStatCustomModelData();
int ultraBeastAttack = CandyModel.getUltraBeastCandyWithStatCustomModelData(Stats.ATTACK);
int paradoxSpeed = CandyModel.getParadoxCandyWithStatCustomModelData(Stats.SPEED);

// Create ItemStack with correct model
ItemStack candy = new ItemStack(ModItems.CANDY);
candy.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(modelData));
```

### Example Template Models

**Elemental Type (fire_hp.json):**
```json
{
  "parent": "item/generated",
  "textures": {
    "layer0": "cobblemon_iv_candy:item/candies/candy_fire",
    "layer1": "cobblemon_iv_candy:item/stats/stat_hp"
  }
}
```

**Special Category (legendary_attack.json):**
```json
{
  "parent": "item/generated",
  "textures": {
    "layer0": "cobblemon_iv_candy:item/candies/candy_legendary",
    "layer1": "cobblemon_iv_candy:item/stats/stat_attack"
  }
}
```

## Generation Scripts

### generate_models.py
Creates all 126 elemental type dynamic model template files (18 types × 7 stats).

### generate_special_models.py
Creates all 28 special category dynamic model template files (4 categories × 7 stats).

### generate_candy_json.py  
Creates the updated candy.json with all dynamic overrides (176 total).

Run all scripts from the repository root:
```bash
python generate_models.py
python generate_special_models.py
python generate_candy_json.py
```

## Migration Steps

1. **Add stat overlay textures** to `textures/item/stats/`:
   - `stat_attack.png` (red sword icon)
   - `stat_defense.png` (blue shield icon)
   - `stat_special_attack.png` (purple star icon)
   - `stat_special_defense.png` (teal crystal icon)
   - `stat_speed.png` (yellow lightning bolt icon)
   - `stat_random.png` (question mark icon)

2. **Replace candy.json** with the generated `candy_dynamic.json`

3. **Update your code** to use the new `CandyModel` methods

4. **Remove old individual model files** in `texture_model/candies/` (optional cleanup)

## Total Coverage

The dynamic system now supports:
- **18 elemental types** × **7 stats** = **126 combinations**
- **4 special categories** × **7 stats** = **28 combinations**
- **Total: 154 dynamic combinations** + legacy overrides

## Benefits

- **Massive Scalability**: Adding new types/categories requires minimal files
- **Maintainability**: Single source of truth for model logic
- **Memory Efficiency**: Reuses textures through layering
- **Flexibility**: Easy to modify stat indicators or category designs
- **Reduced File Count**: 154 template files vs thousands of unique models
- **Unified System**: Same stat overlays work for all candy types

## Compatibility

This system maintains backward compatibility with existing custom model data ranges:
- **100-117**: Original type-only candies
- **200-203**: Legacy special categories  
- **1000-1999**: New dynamic elemental type+stat combinations
- **2000+**: New dynamic special category+stat combinations

The old model files will continue to work until you're ready to fully migrate to the dynamic system.
