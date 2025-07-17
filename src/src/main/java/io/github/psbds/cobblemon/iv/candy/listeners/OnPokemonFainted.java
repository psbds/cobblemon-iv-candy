package io.github.psbds.cobblemon.iv.candy.listeners;

import com.cobblemon.mod.common.api.events.CobblemonEvents;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.services.LootManager;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.battles.model.actor.ActorType;

import kotlin.Unit;
public class OnPokemonFainted {
    public static void initialize() {
        Boot.LOGGER.info("Initializing OnPokemonFainted Listener");
        CobblemonEvents.BATTLE_VICTORY.subscribe(Priority.NORMAL, (event) -> {
            Boot.LOGGER.info("Victory");
            var winner = event.getWinners().get(0);
            var loser = event.getLosers().get(0);
            if (loser.getType() == ActorType.WILD) {
                var killedPokemon = loser.getPokemonList().get(0).getOriginalPokemon();
                winner.getPlayerUUIDs().forEach(uuid -> {
                    Boot.LOGGER.info("Candy Drop Activated uuid");
                    var player = Boot.MinecraftServer.getPlayerList().getPlayer(uuid);
                    LootManager.handleDrops(killedPokemon, player);
                });

            } else {
                Boot.LOGGER.info("Loser is not Wild " + event.getLosers().get(0).getType());
            }
            return Unit.INSTANCE;
        });

    }
}
