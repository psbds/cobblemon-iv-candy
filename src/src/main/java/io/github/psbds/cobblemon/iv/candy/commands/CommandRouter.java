package io.github.psbds.cobblemon.iv.candy.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import static net.minecraft.commands.Commands.literal;

import io.github.psbds.cobblemon.iv.candy.commands.give.CandyGiveRouterCommand;

public class CommandRouter {
    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            var root = literal("ivcandy")
                    .requires(source -> source.hasPermission(2)) // Requires operator level
                    .then(CandyGiveRouterCommand.initialize())
                    .then(ConfigCommand.initialize());

            dispatcher.register(root);
        });
    }
}
