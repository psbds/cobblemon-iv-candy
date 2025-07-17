package io.github.psbds.cobblemon.iv.candy.commands;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class CandyCommand {

    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("ivcandy")
                    .then(argument("value", IntegerArgumentType.integer())
                            .executes(context -> {
                                context.getSource().sendSuccess(() -> Component.literal("1"), false);

                                var player = context.getSource().getPlayer();
                                int value = IntegerArgumentType.getInteger(context, "value");
                                if (player != null) {
                                    context.getSource().sendSuccess(() -> Component.literal("2"), false);

                                    PlayerPartyStore partyStore = com.cobblemon.mod.common.Cobblemon.INSTANCE
                                            .getStorage().getParty((ServerPlayer) player);

                                    // Check if the party has any Pokémon
                                    var pokemonChosen = partyStore.get(value);
                                    context.getSource().sendSuccess(() -> Component.literal("3"), false);
                                    context.getSource().sendSuccess(
                                            () -> Component.literal(String.format("%s", partyStore.size())), false);

                                    if (pokemonChosen != null) {
                                        context.getSource().sendSuccess(() -> Component.literal("4"), false);
                                        var baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(pokemonChosen.getSpecies());
                                        // Give the IV Candy item
                                   
                                        // Set the custom data component
                                       // IVCandyData candyData = IVCandyData.of(baseSpecies.getNationalPokedexNumber());
                                        //itemStack.set(ModDataComponents.IV_CANDY_DATA, candyData);
                                       // player.getInventory().add(CandySpeciesRandom.create(baseSpecies));
                                       // player.getInventory().add(CandyElementalTypesRandom.create(baseSpecies.getPrimaryType()));
                                        partyStore.remove(pokemonChosen);
                                    }

                                }

                                // int result = value * value;
                                return 1;
                            })));
        });
    }

}
