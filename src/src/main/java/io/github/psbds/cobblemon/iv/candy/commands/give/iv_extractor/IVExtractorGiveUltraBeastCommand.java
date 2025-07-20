package io.github.psbds.cobblemon.iv.candy.commands.give.iv_extractor;

import static net.minecraft.commands.Commands.literal;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorFactory;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class IVExtractorGiveUltraBeastCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> initialize() {
        return literal("ultrabeast")
                .executes(IVExtractorGiveUltraBeastCommand::handleGiveIVExtractorCommand);
    }

    private static int handleGiveIVExtractorCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {

        // Ensure this command only runs on the server
        if (context.getSource().getLevel().isClientSide()) {
            return 0; // Fail silently on client side
        }

        var commandSender = context.getSource().getPlayerOrException();
        var targetPlayers = EntityArgument.getPlayers(context, "target_player");

        for (ServerPlayer targetPlayer : targetPlayers) {
            var ivExtractor = IVExtractorFactory.createUltrabeast();
            targetPlayer.getInventory().add(ivExtractor);
            commandSender.sendSystemMessage(Component.literal("Gave Ultra Beast IV Extractor to " + targetPlayer.getDisplayName().getString()));
        }

        return 1;
    }

}
