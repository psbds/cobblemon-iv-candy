---
layout: default
title: Commands Reference
nav_order: 5
description: "Administrative commands for the mod"
permalink: /commands/
---

# Commands Reference

The Cobblemon IV Candy mod provides administrative commands for testing, debugging, and managing the IV enhancement system.

## Available Commands

### `/ivcandy` Command

The primary command for interacting with the mod's functionality.

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

#### Permissions
- **Default**: Requires operator privileges
- **Server**: Configurable through server permissions
- **Usage**: Administrative/debugging tool

#### Output
The command provides feedback through the chat system:
- Confirmation messages for successful operations
- Party size information
- Debug information about the selected Pokémon

## Command Behavior

### Party Interaction
When executed, the command:
1. **Accesses Player Party**: Retrieves the executing player's Pokémon party
2. **Validates Slot**: Checks if the specified slot contains a Pokémon
3. **Processes Pokémon**: Performs operations on the selected Pokémon
4. **Provides Feedback**: Sends results to the command executor

### Error Handling
The command includes built-in error handling for:
- **Invalid Slot Numbers**: Values outside the 0-5 range
- **Empty Slots**: Party positions without Pokémon
- **Party Access Issues**: Problems retrieving player data

## Administrative Usage

### Testing Scenarios

#### Shard Generation Testing
Use the command to test how shards are generated from different Pokémon:
```bash
# Test with different party slots to see varied results
/ivcandy 0
/ivcandy 1
/ivcandy 2
```

#### Party Management
Verify party contents and slots:
```bash
# Check each slot systematically
/ivcandy 0  # First slot
/ivcandy 1  # Second slot
# ... continue for all slots
```

### Development and Debugging

#### Mod Verification
Confirm the mod is working correctly:
1. Execute the command with any valid slot number
2. Check for proper feedback messages
3. Verify no error messages appear in console

#### Integration Testing
Test mod integration with Cobblemon:
1. Ensure Pokémon data is accessible
2. Verify party storage interactions work
3. Confirm proper mod communication

## Server Configuration

### Permission Setup
For servers using permission plugins:

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

### Command Logging
Server administrators can monitor command usage through:
- **Server Console**: Real-time command execution logs
- **Log Files**: Stored command history for auditing
- **Plugin Managers**: Third-party logging solutions

## Future Commands

The mod's command system is designed to be expandable. Future updates may include:

### Planned Commands
- **`/ivcandy give`**: Directly give specific shards or candies
- **`/ivcandy stats`**: Display Pokémon IV statistics
- **`/ivcandy config`**: Modify mod configuration settings

### Community Requests
Popular community-requested commands may be added:
- Bulk shard generation for testing
- IV inspection tools
- Candy effect simulation

## Command Integration

### Chat System
Commands integrate with Minecraft's chat system:
- **Feedback Messages**: Clear confirmation of actions
- **Error Messages**: Helpful error descriptions
- **Status Updates**: Real-time operation status

### Console Output
Server console receives additional information:
- **Debug Messages**: Detailed operation logs
- **Error Tracking**: Full error stack traces
- **Performance Metrics**: Command execution timing

## Troubleshooting Commands

### Common Issues

**"Command not recognized"**
- Verify the mod is properly installed
- Check that you have appropriate permissions
- Ensure the command syntax is correct

**"No permission to use command"**
- Contact server administrator for permissions
- Verify operator status if applicable
- Check permission plugin configuration

**"Invalid party slot"**
- Use slot numbers 0-5 only
- Verify your party has Pokémon in the specified slot
- Check that the Pokémon is properly loaded

### Debug Information

#### Console Logging
Enable debug logging for detailed command information:
```
[INFO] Position 0 item: <item_details>
[INFO] Position 1 has different species, returning false
[INFO] CALLING ASSEMBLE METHOD FOR CANDY RECIPE
```

#### Error Messages
Common error patterns and their meanings:
- **"Position X is empty"**: The specified party slot is empty
- **"Returning false"**: Command validation failed
- **"Error creating item"**: Internal mod error occurred

## Best Practices

### Command Usage
1. **Test in Creative**: Use creative mode for initial testing
2. **Backup Saves**: Always backup before extensive command testing
3. **Monitor Performance**: Watch for any performance impacts

### Server Administration
1. **Limit Access**: Restrict commands to trusted users
2. **Monitor Usage**: Track command frequency and patterns
3. **Document Changes**: Keep records of administrative actions

### Development
1. **Version Control**: Test commands across mod updates
2. **Compatibility**: Verify commands work with other mods
3. **Error Reporting**: Report bugs with detailed command logs
