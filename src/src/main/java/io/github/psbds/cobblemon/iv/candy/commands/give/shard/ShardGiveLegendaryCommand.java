package io.github.psbds.cobblemon.iv.candy.commands.give.shard;

import static net.minecraft.commands.Commands.literal;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import io.github.psbds.cobblemon.iv.candy.player.PlayerInventoryHelper;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ShardGiveLegendaryCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> initialize() {
        return literal("legendary")
                .executes(ShardGiveLegendaryCommand::handleGiveShardCommand);
    }

    private static int handleGiveShardCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {

        // Ensure this command only runs on the server
        if (context.getSource().getLevel().isClientSide()) {
            return 0; // Fail silently on client side
        }

        var commandSender = context.getSource().getPlayerOrException();
        var targetPlayers = EntityArgument.getPlayers(context, "target_player");

        for (ServerPlayer targetPlayer : targetPlayers) {
            var shard = ShardFactory.createLegendaryShard();
            PlayerInventoryHelper.addOrDrop(targetPlayer, shard);
            commandSender.sendSystemMessage(Component.literal("Gave Legendary IV Shard to " + targetPlayer.getDisplayName().getString()));
        }

        return 1;
    }

}
