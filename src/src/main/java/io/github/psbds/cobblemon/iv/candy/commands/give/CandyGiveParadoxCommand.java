package io.github.psbds.cobblemon.iv.candy.commands.give;

import static net.minecraft.commands.Commands.literal;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.psbds.cobblemon.iv.candy.items.mappers.IVStatMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class CandyGiveParadoxCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> initialize() {
        return literal("paradox")
                .executes(CandyGiveParadoxCommand::handleGiveSpeciesCommand);
    }

    private static int handleGiveSpeciesCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {

        // Ensure this command only runs on the server
        if (context.getSource().getLevel().isClientSide()) {
            return 0; // Fail silently on client side
        }

        var commandSender = context.getSource().getPlayerOrException();
        var targetPlayers = EntityArgument.getPlayers(context, "target_player");
        var iv = StringArgumentType.getString(context, "iv");

        for (ServerPlayer targetPlayer : targetPlayers) {
            var targetIvStat = iv.equals("random") ? null : IVStatMap.getStats(iv); // Handle random or specific IV stat
            var candy = CandyFactory.createParadoxCandy(targetIvStat);
            targetPlayer.getInventory().add(candy);
            commandSender.sendSystemMessage(Component.literal("Gave Paradox IV Candy to " + targetPlayer.getDisplayName().getString()));
        }

        return 1;
    }

}
