---
layout: default
title: Commands Reference
nav_order: 5
description: "Administrative commands for the mod"
permalink: /commands/
---

# Commands Reference

The Cobblemon IV Candy mod provides comprehensive administrative commands for testing, debugging, and managing the IV enhancement system.

## Available Commands

### `/ivcandy give` Commands

Administrative commands for giving IV candies and shards to players.

#### Candy Commands

Give IV candies with specific or random stat targeting to players.

##### Syntax
```
/ivcandy give <target_player> candy <iv_stat> <candy_type> [additional_args]
```

##### Parameters
- **`<target_player>`**: Target player(s) using entity selectors (@p, @a, player_name, etc.)
- **`<iv_stat>`**: The IV stat to enhance (random, hp, attack, defense, special_attack, special_defense, speed)
- **`<candy_type>`**: The type of candy to give

##### Available Candy Types

###### Species Candies
```bash
# Give species-specific IV candy
/ivcandy give <target_player> candy <iv_stat> species <pokemon_name>

# Examples
/ivcandy give @p candy random species pikachu
/ivcandy give @p candy attack species charizard
/ivcandy give @p candy hp species bulbasaur
```

###### Elemental Type Candies
```bash
# Give elemental type IV candy
/ivcandy give <target_player> candy <iv_stat> elemental <elemental_type>

# Examples
/ivcandy give @p candy random elemental fire
/ivcandy give @p candy attack elemental water
/ivcandy give @p candy defense elemental grass
```

**Supported Elemental Types:**
- Fire, Water, Grass, Electric, Ice, Rock, Ground, Flying
- Psychic, Bug, Poison, Fighting, Ghost, Dragon, Dark, Steel
- Fairy, Normal

###### Special Candies
```bash
# Legendary IV candies
/ivcandy give <target_player> candy <iv_stat> legendary

# Mythical IV candies
/ivcandy give <target_player> candy <iv_stat> mythical

# Ultra Beast IV candies
/ivcandy give <target_player> candy <iv_stat> ultrabeast

# Paradox IV candies
/ivcandy give <target_player> candy <iv_stat> paradox

# Examples
/ivcandy give @p candy random legendary
/ivcandy give @p candy speed mythical
/ivcandy give @p candy hp ultrabeast
/ivcandy give @p candy attack paradox
```

#### Shard Commands

Give IV shards for crafting candies.

##### Syntax
```
/ivcandy give <target_player> shard <shard_type> [additional_args]
```

##### Parameters
- **`<target_player>`**: Target player(s) using entity selectors
- **`<shard_type>`**: The type of shard to give

##### Available Shard Types

###### Species Shards
```bash
# Give species-specific IV shard
/ivcandy give <target_player> shard species <pokemon_name>

# Examples
/ivcandy give @p shard species pikachu
/ivcandy give @p shard species charizard
/ivcandy give @p shard species bulbasaur
```

###### Elemental Type Shards
```bash
# Give elemental type IV shard
/ivcandy give <target_player> shard elemental <elemental_type>

# Examples
/ivcandy give @p shard elemental fire
/ivcandy give @p shard elemental water
/ivcandy give @p shard elemental grass
```

###### Special Shards
```bash
# Legendary IV shards
/ivcandy give <target_player> shard legendary

# Mythical IV shards
/ivcandy give <target_player> shard mythical

# Ultra Beast IV shards
/ivcandy give <target_player> shard ultrabeast

# Paradox IV shards
/ivcandy give <target_player> shard paradox
```

### `/ivcandy` Debug Command

The original debug command for testing mod functionality.

#### Syntax
```
/ivcandy <value>
```

#### Parameters
- **`<value>`**: Integer representing the party slot number (0-5)

#### Description
This command is primarily used for testing and debugging purposes. It interacts with the player's Pokémon party and can be used to:
- Test shard generation mechanics
- Debug party interactions
- Verify mod functionality

#### Usage Examples
```bash
# Interact with the first Pokémon in your party (slot 0)
/ivcandy 0

# Interact with the second Pokémon in your party (slot 1)
/ivcandy 1

# Interact with the last possible party slot
/ivcandy 5
```

## Command Parameters

### IV Stat Options
- **`random`**: Randomly selects an IV stat that isn't already maxed
- **`hp`**: Health Points
- **`attack`**: Physical Attack Power
- **`defense`**: Physical Defense
- **`special_attack`**: Special Attack Power
- **`special_defense`**: Special Defense
- **`speed`**: Speed/Agility

### Target Player Selectors
- **`@p`**: Nearest player
- **`@a`**: All players
- **`@s`**: Command executor (self)
- **`player_name`**: Specific player by username

## Permissions

### Default Permissions
- **Requirement**: Operator privileges required
- **Server**: Configurable through server permissions
- **Usage**: Administrative/debugging tools

### Permission Setup

#### LuckPerms Example
```bash
# Grant IV Candy commands to moderators
/lp group moderator permission set cobblemon_iv_candy.command true

# Grant to specific users
/lp user <username> permission set cobblemon_iv_candy.command true
```

#### Default Server Setup
```bash
# Make a player an operator (grants all commands)
/op <username>

# Remove operator status
/deop <username>
```

## Command Behavior

### Auto-completion
Commands provide intelligent auto-completion for:
- **Pokemon Names**: All available species from Cobblemon
- **Elemental Types**: All 18 Pokemon types
- **IV Stats**: All available stat options

### Error Handling
Commands include comprehensive error handling:
- **Invalid Pokemon Names**: Clear error messages with suggestions
- **Invalid Elemental Types**: Type validation with helpful feedback
- **Server-side Validation**: Commands only execute on server
- **Permission Checks**: Proper permission validation

### Feedback Messages
All commands provide clear feedback:
- **Success Messages**: Confirmation of items given
- **Error Messages**: Detailed error descriptions
- **Target Information**: Shows which players received items

## Usage Examples

### Testing Scenarios

#### Basic Item Testing
```bash
# Give yourself a random Fire candy
/ivcandy give @s candy random elemental fire

# Give a specific player a Pikachu shard
/ivcandy give Steve shard species pikachu

# Give all players a legendary candy for HP
/ivcandy give @a candy hp legendary
```

#### Batch Operations
```bash
# Give multiple items for testing
/ivcandy give @p candy attack elemental fire
/ivcandy give @p candy defense elemental water
/ivcandy give @p candy speed elemental electric
```

#### Server Administration
```bash
# Give shards for crafting tests
/ivcandy give @a shard legendary
/ivcandy give @a shard mythical
/ivcandy give @a shard ultrabeast
/ivcandy give @a shard paradox
```

## Troubleshooting

### Common Issues

**"Command not recognized"**
- Verify the mod is properly installed
- Check that you have appropriate permissions
- Ensure the command syntax is correct

**"No permission to use command"**
- Contact server administrator for permissions
- Verify operator status if applicable
- Check permission plugin configuration

**"Pokemon species not found"**
- Check spelling of Pokemon name
- Use autocomplete for accurate names
- Verify the Pokemon exists in Cobblemon

**"Elemental type not found"**
- Check spelling of elemental type
- Use lowercase names (fire, water, grass, etc.)
- Use autocomplete for accurate types

### Debug Information

#### Console Logging
Commands provide detailed logging for administrators:
```
[INFO] Gave Fire IV Candy to Player
[INFO] Gave Pikachu IV Shard to Player
[ERROR] Unknown elemental type: fie (did you mean fire?)
```

## Best Practices

### Command Usage
1. **Use Autocomplete**: Take advantage of tab completion for accuracy
2. **Test in Creative**: Use creative mode for initial testing
3. **Backup Saves**: Always backup before extensive command testing
4. **Monitor Performance**: Watch for any performance impacts

### Server Administration
1. **Limit Access**: Restrict commands to trusted users
2. **Monitor Usage**: Track command frequency and patterns
3. **Document Changes**: Keep records of administrative actions
4. **Regular Cleanup**: Remove test items from player inventories

### Development Testing
1. **Systematic Testing**: Test each command type methodically
2. **Version Control**: Test commands across mod updates
3. **Compatibility**: Verify commands work with other mods
4. **Error Reporting**: Report bugs with detailed command logs