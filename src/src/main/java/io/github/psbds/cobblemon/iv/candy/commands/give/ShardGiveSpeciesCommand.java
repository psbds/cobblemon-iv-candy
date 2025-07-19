package io.github.psbds.cobblemon.iv.candy.commands.give;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Species;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ShardGiveSpeciesCommand {

    private static final SuggestionProvider<CommandSourceStack> POKEMON_SPECIES_SUGGESTIONS = (context, builder) -> {
        return SharedSuggestionProvider.suggest(
                PokemonSpecies.INSTANCE.getSpecies().stream()
                        .map(Species::getName)
                        .map(String::toLowerCase),
                builder);
    };

    public static LiteralArgumentBuilder<CommandSourceStack> initialize() {
        return literal("species")
                .then(argument("pokemon_name", StringArgumentType.string())
                        .suggests(POKEMON_SPECIES_SUGGESTIONS)
                        .executes(ShardGiveSpeciesCommand::handleGiveSpeciesCommand));
    }

    private static int handleGiveSpeciesCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {

        // Ensure this command only runs on the server
        if (context.getSource().getLevel().isClientSide()) {
            return 0; // Fail silently on client side
        }

        var commandSender = context.getSource().getPlayerOrException();
        var targetPlayers = EntityArgument.getPlayers(context, "target_player");
        var pokemonName = StringArgumentType.getString(context, "pokemon_name");

        Species species = CobblemonSpeciesHelper.getSpeciesByName(pokemonName);

        if (species != null) {
            for (ServerPlayer targetPlayer : targetPlayers) {
                var baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(species);
                var shard = ShardFactory.createForSpecies(baseSpecies);
                targetPlayer.getInventory().add(shard);
                commandSender.sendSystemMessage(Component.literal("Gave " + baseSpecies.getName() + " IV Shard to " + targetPlayer.getDisplayName().getString()));
            }
        } else {
            commandSender.sendSystemMessage(Component.literal("Species '" + pokemonName + "' not found. Please check the spelling and try again."));
        }

        return 1;
    }

}
