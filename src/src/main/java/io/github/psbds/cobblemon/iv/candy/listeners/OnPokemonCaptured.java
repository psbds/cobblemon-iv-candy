package io.github.psbds.cobblemon.iv.candy.listeners;

import com.cobblemon.mod.common.api.events.CobblemonEvents;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.services.LootManager;

import com.cobblemon.mod.common.api.Priority;

import kotlin.Unit;

public class OnPokemonCaptured {
    public static void initialize() {
        Boot.LOGGER.info("Initializing OnPokemonCaptured Listener");
        CobblemonEvents.POKEMON_CAPTURED.subscribe(Priority.NORMAL, (event) -> {
            var pokemon = event.getPokemon();
            var player = event.getPlayer();
            LootManager.handleDrops(pokemon, player);

            return Unit.INSTANCE;
        });

    }
}
