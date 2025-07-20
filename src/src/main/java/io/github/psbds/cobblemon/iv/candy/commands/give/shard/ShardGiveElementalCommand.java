package io.github.psbds.cobblemon.iv.candy.commands.give.shard;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ShardGiveElementalCommand {

    private static final SuggestionProvider<CommandSourceStack> ELEMENTAL_TYPE_SUGGESTIONS = (context, builder) -> {
        return SharedSuggestionProvider.suggest(
                ElementalTypes.INSTANCE.all().stream()
                        .map(ElementalType::getName)
                        .map(String::toLowerCase),
                builder);
    };

    public static LiteralArgumentBuilder<CommandSourceStack> initialize() {
        return literal("elemental")
                .then(argument("elemental_type", StringArgumentType.string())
                        .suggests(ELEMENTAL_TYPE_SUGGESTIONS)
                        .executes(ShardGiveElementalCommand::handleGiveElementalCommand));
    }

    private static int handleGiveElementalCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {

        // Ensure this command only runs on the server
        if (context.getSource().getLevel().isClientSide()) {
            return 0; // Fail silently on client side
        }

        var commandSender = context.getSource().getPlayerOrException();
        var targetPlayers = EntityArgument.getPlayers(context, "target_player");
        var elementalTypeName = StringArgumentType.getString(context, "elemental_type");

        ElementalType elementalType = getElementalTypeByName(elementalTypeName);

        if (elementalType != null) {
            for (ServerPlayer targetPlayer : targetPlayers) {
                var shard = ShardFactory.createForElement(elementalType);
                targetPlayer.getInventory().add(shard);
                commandSender.sendSystemMessage(Component.literal("Gave " + elementalType.getName() + " IV Shard to " + targetPlayer.getDisplayName().getString()));
            }
        } else {
            commandSender.sendSystemMessage(Component.literal("Elemental type '" + elementalTypeName + "' not found. Please check the spelling and try again."));
        }

        return 1;
    }

    private static ElementalType getElementalTypeByName(String elementalTypeName) {
        try {
            int elementalTypeId = ElementalTypeMap.getElementalTypeId(elementalTypeName);
            return ElementalTypeMap.getElementalType(elementalTypeId);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
