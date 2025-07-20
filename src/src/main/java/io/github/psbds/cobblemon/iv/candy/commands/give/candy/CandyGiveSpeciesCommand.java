package io.github.psbds.cobblemon.iv.candy.commands.give.candy;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

import java.util.Collection;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Species;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.mappers.IVStatMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import io.github.psbds.cobblemon.iv.candy.player.PlayerInventoryHelper;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class CandyGiveSpeciesCommand {

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
                        .executes(CandyGiveSpeciesCommand::handleGiveSpeciesCommand));
    }

    private static int handleGiveSpeciesCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {

        // Ensure this command only runs on the server
        if (context.getSource().getLevel().isClientSide()) {
            return 0; // Fail silently on client side
        }

        var commandSender = context.getSource().getPlayerOrException();
        var targetPlayers = EntityArgument.getPlayers(context, "target_player");
        var iv = StringArgumentType.getString(context, "iv");
        var pokemonName = StringArgumentType.getString(context, "pokemon_name");

        Species species = CobblemonSpeciesHelper.getSpeciesByName(pokemonName);

        if (species != null) {
            for (ServerPlayer targetPlayer : targetPlayers) {
                var baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(species);
                var targetIvStat = iv.equals("random") ? null : IVStatMap.getStats(iv); // Handle random or specific IV stat
                var candy = CandyFactory.createForSpecies(baseSpecies, targetIvStat);
                PlayerInventoryHelper.addOrDrop(targetPlayer, candy);
                commandSender.sendSystemMessage(Component.literal("Gave " + baseSpecies.getName() + " IV Candy to " + targetPlayer.getDisplayName().getString()));
            }
        } else {
            commandSender.sendSystemMessage(Component.literal("Species '" + pokemonName + "' not found. Please check the spelling and try again."));
        }

        return 1;
    }

}
