package io.github.psbds.cobblemon.iv.candy.services;

import com.cobblemon.mod.common.pokemon.Pokemon;

import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.Shard;
import net.minecraft.server.level.ServerPlayer;

public class LootManager {

    public static void handleDrops(Pokemon killedPokemon, ServerPlayer killer) {

        var lootTable = LootTableManager.getLootTable(killedPokemon);

        if (Math.random() * 100 < lootTable.randomSpeciesCandyChance()) {
            for (int i = 0; i < 100; i++) {
                killer.getInventory().add(Candy.create(killedPokemon.getSpecies(), null, null));
            }
        }
        if (Math.random() * 100 < lootTable.randomTypeCandyChance()) {
            killer.getInventory().add(Candy.create(null, null, killedPokemon.getSpecies().getPrimaryType()));
        }
        if (Math.random() * 100 < lootTable.shardChance()) {
            for (int i = 0; i < 100; i++) {
                killer.getInventory().add(Shard.create(killedPokemon.getSpecies()));
            }
        }
    }
}
