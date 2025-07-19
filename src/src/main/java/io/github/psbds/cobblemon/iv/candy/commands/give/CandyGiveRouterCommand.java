package io.github.psbds.cobblemon.iv.candy.commands.give;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

import java.util.List;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;

public class CandyGiveRouterCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> initialize() {
        // Candy
        var candyRoot = literal("candy")
                .then(argument("iv", StringArgumentType.string())
                        .suggests(IV_SUGGESTIONS)
                        .then(CandyGiveSpeciesCommand.initialize())
                        .then(CandyGiveElementalCommand.initialize())
                        .then(CandyGiveLegendaryCommand.initialize())
                        .then(CandyGiveMythicalCommand.initialize())
                        .then(CandyGiveUltraBeastCommand.initialize())
                        .then(CandyGiveParadoxCommand.initialize()));

        // Shard
        var shardRoot = literal("shard")
                .then(ShardGiveSpeciesCommand.initialize())
                .then(ShardGiveElementalCommand.initialize())
                .then(ShardGiveLegendaryCommand.initialize())
                .then(ShardGiveMythicalCommand.initialize())
                .then(ShardGiveUltraBeastCommand.initialize())
                .then(ShardGiveParadoxCommand.initialize());

        // SubRoot
        var subRoot = literal("give")
                .then(argument("target_player", EntityArgument.players())
                        .then(candyRoot)
                        .then(shardRoot));
        return subRoot;
    }

    private static final SuggestionProvider<CommandSourceStack> IV_SUGGESTIONS = (context, builder) -> {
        return SharedSuggestionProvider.suggest(
                List.of("random", "hp", "attack", "defense", "special_attack", "special_defense", "speed").stream()
                        .map(String::toLowerCase),
                builder);
    };
}
