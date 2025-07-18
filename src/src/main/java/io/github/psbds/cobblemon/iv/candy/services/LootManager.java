package io.github.psbds.cobblemon.iv.candy.services;

import com.cobblemon.mod.common.pokemon.Pokemon;

import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.Shard;
import net.minecraft.server.level.ServerPlayer;

public class LootManager {

    public static void handleDrops(Pokemon killedPokemon, ServerPlayer killer) {

        var lootTable = LootTableManager.getLootTable(killedPokemon);

        if (Math.random() * 100 < lootTable.speciesShardChance()) {
            for (int i = 0; i < 64; i++) {
                killer.getInventory().add(Shard.createForSpecies(killedPokemon.getSpecies()));
            }
        }
        if (Math.random() * 100 < lootTable.elementalShardChance()) {
            for (int i = 0; i < 64; i++) {
                killer.getInventory().add(Shard.createForElement(killedPokemon.getSpecies().getPrimaryType()));
            }
            if (killedPokemon.getSpecies().getSecondaryType() != null) {
                for (int i = 0; i < 64; i++) {
                    killer.getInventory().add(Shard.createForElement(killedPokemon.getSpecies().getSecondaryType()));
                }
            }
        }
    }
}
