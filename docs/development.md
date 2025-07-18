---
layout: page
title: "Development Guide"
permalink: /development/
nav_order: 6
---

# Development Guide

This guide is for developers who want to contribute to, modify, or understand the technical aspects of the Cobblemon IV Candy mod.

## Project Structure

### Repository Overview
```
cobblemon-iv-candy/
├── src/                           # Main source directory
│   ├── build.gradle.kts          # Build configuration
│   ├── gradle.properties         # Gradle properties
│   ├── settings.gradle.kts       # Project settings
│   └── src/
│       └── main/
│           ├── java/             # Java source code
│           └── resources/        # Resources (textures, models, data)
├── docs/                         # GitHub Pages documentation
├── sprites/                      # Sprite assets
└── README.md                     # Project documentation
```

### Source Code Organization
```
src/main/java/io/github/psbds/cobblemon/iv/candy/
├── Boot.java                     # Main mod class (ModInitializer)
├── commands/                     # Command implementations
│   └── CandyCommand.java
├── constants/                    # Constants and enums
│   └── ShardType.java
├── helpers/                      # Utility classes
│   └── CobblemonSpeciesHelper.java
├── items/                        # Item definitions and logic
│   ├── ModItems.java            # Item registry
│   ├── components/              # Data components
│   ├── mappers/                 # Data mapping utilities
│   └── objects/                 # Item implementations
├── listeners/                    # Event listeners
│   └── OnPokemonFainted.java
├── recipes/                      # Recipe system
│   ├── candy/                   # Basic candy recipes
│   └── super_candy/             # Super candy recipes
└── services/                     # Core services
    └── LootManager.java
```

## Development Environment Setup

### Prerequisites
- **Java Development Kit (JDK) 21** or later
- **IntelliJ IDEA** (recommended) or **Eclipse**
- **Git** for version control
- **Gradle** (included with project wrapper)

### Getting Started

#### 1. Clone the Repository
```bash
git clone https://github.com/psbds/cobblemon-iv-candy.git
cd cobblemon-iv-candy
```

#### 2. Import Project
- Open IntelliJ IDEA
- Select "Open" and navigate to the project directory
- Choose the `src/build.gradle.kts` file
- Let Gradle sync and download dependencies

#### 3. Configure Development Environment
```bash
# Generate IDE run configurations
./gradlew genIdeaWorkspace

# On Windows
.\gradlew.bat genIdeaWorkspace
```

#### 4. Build the Project
```bash
# Clean and build
./gradlew clean build

# Development build
./gradlew build
```

### Development Server Setup

#### Running Test Server
```bash
# Start Minecraft client in development
./gradlew runClient

# Start dedicated server in development
./gradlew runServer
```

#### Hot Reload (Development)
The development environment supports hot reload for many changes:
- Resource file modifications
- Some code changes (method implementations)
- Data generation updates

## Code Architecture

### Core Components

#### 1. Mod Initialization (`Boot.java`)
```java
public class Boot implements ModInitializer {
    public static final String MOD_ID = "cobblemon_iv_candy";
    
    @Override
    public void onInitialize() {
        // Initialize all mod components
        BootComponents.initialize();
        ModItems.initialize();
        ModRecipes.registerRecipes();
        CandyCommand.initialize();
        OnPokemonFainted.initialize();
    }
}
```

#### 2. Item System
The mod uses a sophisticated item system with data components:

**Data Components**
- `DataShard`: Stores shard type, species, and elemental information
- `DataCandy`: Stores candy type, species, elemental type, and target stat

**Item Classes**
- `Shard`: Base shard item with factory methods
- `Candy`: Base candy item with crafting integration

#### 3. Recipe System
Custom recipe types for crafting mechanics:

**Recipe Types**
- `CandyRecipe`: Basic 3-shard recipe for random IV candies
- `SuperCandyRecipe`: 8-shard + stat item recipe for targeted candies

**Recipe Matchers**
- `CandyRecipeMatcher`: Validates basic candy recipes
- `SuperCandyRecipeMatcher`: Validates super candy recipes

#### 4. Event System
Integration with Cobblemon events:

```java
public class OnPokemonFainted {
    public static void initialize() {
        // Listen for Pokémon faint events
        // Generate appropriate shards based on Pokémon
    }
}
```

### Data Flow

#### Shard Generation Flow
1. **Pokémon Faints** → Event triggered
2. **Species Analysis** → Determine shard type
3. **Shard Creation** → Generate appropriate shard
4. **Data Assignment** → Set shard properties
5. **Drop/Give** → Provide to player

#### Candy Crafting Flow
1. **Recipe Input** → Player places items in crafting grid
2. **Recipe Matching** → System validates pattern and items
3. **Shard Analysis** → Extract shard data and validate compatibility
4. **Candy Creation** → Generate candy with appropriate properties
5. **Result Output** → Provide crafted candy to player

#### Candy Usage Flow
1. **Player Interaction** → Right-click on Pokémon with candy
2. **Compatibility Check** → Verify candy can be used on target
3. **IV Enhancement** → Apply stat improvements
4. **Feedback** → Provide success/failure messages
5. **Consumption** → Remove candy from inventory

## API Reference

### Item Creation APIs

#### Shard Creation
```java
// Create species-specific shard
ItemStack shard = Shard.createForSpecies(pokemonSpecies);

// Create elemental type shard
ItemStack shard = Shard.createForElement(elementalType);

// Custom shard initialization
Shard.initialize(itemStack, shardType, species, elementalType);
```

#### Candy Creation
```java
// Create candy from shard
ItemStack candy = Candy.create(baseShard, targetIVStat);

// Custom candy initialization
Candy.initialize(itemStack, baseShard, targetIVStat);
```

### Data Component APIs

#### Shard Data
```java
// Get shard data from item
DataShard shardData = itemStack.get(DataShard.COMPONENT);

// Create shard data
DataShard data = DataShard.of(shardType, pokedexNumber, elementalType);
```

#### Candy Data
```java
// Get candy data from item
DataCandy candyData = itemStack.get(DataCandy.COMPONENT);

// Create candy data
DataCandy data = DataCandy.of(candyType, pokedexNumber, elementalType, targetStat);
```

### Helper Utilities

#### Species Helper
```java
// Get base species (first evolution)
Species baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(species);

// Get species by Pokédex number
Species species = CobblemonSpeciesHelper.getSpeciesByPokedexNumber(number);
```

#### Type Mapping
```java
// Get elemental type ID
int typeId = ElementalTypeMap.getElementalTypeId(elementalType);

// Get custom model data for type
int modelData = CustomModelDataMap.getElementalTypeCustoModelData(typeId);
```

## Contributing Guidelines

### Code Style

#### Java Conventions
- Use **camelCase** for method and variable names
- Use **PascalCase** for class names
- Use **UPPER_SNAKE_CASE** for constants
- Follow standard Java formatting guidelines

#### Documentation
- Add **Javadoc comments** for public methods and classes
- Include **inline comments** for complex logic
- Update **wiki documentation** for user-facing changes

### Testing

#### Unit Testing
```java
@Test
public void testShardCreation() {
    // Test shard creation logic
    ItemStack shard = Shard.createForSpecies(species);
    assertNotNull(shard);
    assertTrue(shard.has(DataShard.COMPONENT));
}
```

#### Integration Testing
- Test with actual Minecraft environment
- Verify Cobblemon integration works correctly
- Test recipe functionality in-game

### Pull Request Process

#### Before Submitting
1. **Fork the repository** and create a feature branch
2. **Test your changes** thoroughly
3. **Update documentation** if needed
4. **Follow code style** guidelines
5. **Write meaningful commit messages**

#### Submission Checklist
- [ ] Code compiles without errors
- [ ] All tests pass
- [ ] Documentation updated
- [ ] No unnecessary dependencies added
- [ ] Backwards compatibility maintained

### Issue Reporting

#### Bug Reports
Include the following information:
- **Mod version** and **Minecraft version**
- **Complete mod list** with versions
- **Error logs** from console
- **Steps to reproduce** the issue
- **Expected vs actual behavior**

#### Feature Requests
Provide details about:
- **Use case** for the feature
- **Proposed implementation** approach
- **Compatibility considerations**
- **User interface** mockups if applicable

## Build System

### Gradle Configuration

#### Dependencies
```kotlin
dependencies {
    minecraft("com.mojang:minecraft:1.21.1")
    mappings(loom.officialMojangMappings())
    
    modImplementation("net.fabricmc:fabric-loader:0.16.5")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.104.0+1.21.1")
    modImplementation("com.cobblemon:fabric:1.6.0+1.21.1-SNAPSHOT")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.12.3+kotlin.2.0.21")
}
```

#### Build Tasks
```bash
# Clean build artifacts
./gradlew clean

# Compile and build mod
./gradlew build

# Run development client
./gradlew runClient

# Run development server
./gradlew runServer

# Generate data (recipes, models, etc.)
./gradlew runDatagen
```

### Resource Generation

#### Data Generation
The mod supports automatic data generation for:
- **Recipe definitions** (JSON files)
- **Model definitions** (JSON files)
- **Language files** (translations)

#### Asset Pipeline
1. **Sprites** → Located in `/sprites/` directory
2. **Processing** → Manual conversion to Minecraft format
3. **Models** → Generated JSON with custom model data
4. **Textures** → Placed in appropriate resource directories

## Debugging

### Development Tools

#### Logging
```java
// Use the mod's logger
Boot.LOGGER.info("Debug message");
Boot.LOGGER.error("Error message", exception);
```

#### Debug Commands
Use the `/ivcandy` command for testing:
```bash
# Test party interactions
/ivcandy 0

# Verify mod functionality
/ivcandy 1
```

#### Item Debugging
Right-click with items to see debug information:
- Data component values
- Item properties
- Custom model data

### Common Issues

#### Build Problems
- **Dependency issues**: Update `build.gradle.kts` dependencies
- **Mapping problems**: Verify Minecraft and mapping versions match
- **Java version**: Ensure JDK 21+ is being used

#### Runtime Issues
- **Recipe not working**: Check recipe matcher logic
- **Items not spawning**: Verify event listener registration
- **Data corruption**: Check data component serialization

## Release Process

### Version Management
- Follow **Semantic Versioning** (SemVer)
- Update version in `gradle.properties`
- Tag releases in Git

### Publishing
1. **Test thoroughly** in development environment
2. **Build release** artifacts with `./gradlew build`
3. **Create GitHub release** with changelog
4. **Upload artifacts** to appropriate platforms

### Documentation Updates
- Update **compatibility matrix** for new versions
- Revise **installation guide** if needed
- Add **changelog entries** for user-facing changes

For technical questions or contribution discussions, please open an issue on our [GitHub repository](https://github.com/psbds/cobblemon-iv-candy).
