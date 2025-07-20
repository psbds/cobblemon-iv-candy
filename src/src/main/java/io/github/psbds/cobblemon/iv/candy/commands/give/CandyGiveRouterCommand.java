package io.github.psbds.cobblemon.iv.candy.commands.give;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

import java.util.List;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import io.github.psbds.cobblemon.iv.candy.commands.give.candy.CandyGiveElementalCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.candy.CandyGiveLegendaryCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.candy.CandyGiveMythicalCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.candy.CandyGiveParadoxCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.candy.CandyGiveSpeciesCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.candy.CandyGiveUltraBeastCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.iv_extractor.IVExtractorGiveElementalCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.iv_extractor.IVExtractorGiveLegendaryCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.iv_extractor.IVExtractorGiveMythicalCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.iv_extractor.IVExtractorGiveParadoxCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.iv_extractor.IVExtractorGiveUltraBeastCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.shard.ShardGiveElementalCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.shard.ShardGiveLegendaryCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.shard.ShardGiveMythicalCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.shard.ShardGiveParadoxCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.shard.ShardGiveSpeciesCommand;
import io.github.psbds.cobblemon.iv.candy.commands.give.shard.ShardGiveUltraBeastCommand;
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

        // IV Extractor
        var ivExtractorRoot = literal("iv_extractor")
                .then(IVExtractorGiveElementalCommand.initialize())
                .then(IVExtractorGiveLegendaryCommand.initialize())
                .then(IVExtractorGiveMythicalCommand.initialize())
                .then(IVExtractorGiveUltraBeastCommand.initialize())
                .then(IVExtractorGiveParadoxCommand.initialize());

        // SubRoot
        var subRoot = literal("give")
                .then(argument("target_player", EntityArgument.players())
                        .then(candyRoot)
                        .then(shardRoot)
                        .then(ivExtractorRoot));
        return subRoot;
    }

    private static final SuggestionProvider<CommandSourceStack> IV_SUGGESTIONS = (context, builder) -> {
        return SharedSuggestionProvider.suggest(
                List.of("random", "hp", "attack", "defense", "special_attack", "special_defense", "speed").stream()
                        .map(String::toLowerCase),
                builder);
    };
}
