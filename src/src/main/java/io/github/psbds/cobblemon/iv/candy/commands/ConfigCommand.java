package io.github.psbds.cobblemon.iv.candy.commands;

import static net.minecraft.commands.Commands.literal;

import io.github.psbds.cobblemon.iv.candy.config.ConfigManager;
import io.github.psbds.cobblemon.iv.candy.config.ModConfig;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

/**
 * Commands for managing the mod configuration.
 */
public class ConfigCommand {

    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("ivcandy")
                    .then(literal("config")
                            .requires(source -> source.hasPermission(2)) // Requires operator level
                            .then(literal("reload")
                                    .executes(context -> reloadConfig(context.getSource())))
                            .then(literal("info")
                                    .executes(context -> showConfigInfo(context.getSource())))));
        });
    }

    /**
     * Reloads the configuration from file.
     */
    private static int reloadConfig(CommandSourceStack source) {
        try {
            ConfigManager.reloadConfig();
            source.sendSuccess(() -> Component.literal("Configuration reloaded successfully!").withStyle(ChatFormatting.GREEN), true);
            return 1;
        } catch (Exception e) {
            source.sendFailure(Component.literal("Failed to reload configuration: " + e.getMessage()).withStyle(ChatFormatting.RED));
            return 0;
        }
    }

    /**
     * Shows current configuration values.
     */
    private static int showConfigInfo(CommandSourceStack source) {
        ModConfig config = ConfigManager.getConfig();

        source.sendSuccess(() -> Component.literal("=== Cobblemon IV Candy Configuration ===")
                .withStyle(ChatFormatting.YELLOW), false);

        source.sendSuccess(() -> Component.literal("Shard Drop Chance: " + (config.pokemon_species_drop_chance) + "%")
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Shard Drop Amount: " + config.pokemon_species_drop_amount)
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Type Drop Chance: " + config.pokemon_type_drop_chance + "%")
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Type Drop Amount: " + config.pokemon_type_drop_amount)
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Legendary Drop Chance: " + config.pokemon_legendary_drop_chance + "%")
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Legendary Drop Amount: " + config.pokemon_legendary_drop_amount)
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Mythical Drop Chance: " + config.pokemon_mythical_drop_chance + "%")
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Mythical Drop Amount: " + config.pokemon_mythical_drop_amount)
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Ultra Beast Drop Chance: " + config.pokemon_ultra_beast_drop_chance + "%")
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Ultra Beast Drop Amount: " + config.pokemon_ultra_beast_drop_amount)
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Paradox Drop Chance: " + config.pokemon_paradox_drop_chance + "%")
                .withStyle(ChatFormatting.WHITE), false);

        source.sendSuccess(() -> Component.literal("Paradox Drop Amount: " + config.pokemon_paradox_drop_amount)
                .withStyle(ChatFormatting.WHITE), false);

        return 1;
    }
}
