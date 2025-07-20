package io.github.psbds.cobblemon.iv.candy.services;

import com.cobblemon.mod.common.pokemon.Pokemon;

import io.github.psbds.cobblemon.iv.candy.items.objects.shards.Shard;
import io.github.psbds.cobblemon.iv.candy.player.PlayerInventoryHelper;
import net.minecraft.server.level.ServerPlayer;

public class LootManager {

    public static void handleDrops(Pokemon killedPokemon, ServerPlayer killer) {

        var lootTable = LootTableManager.getLootTable(killedPokemon);

        // Handle species shard drops
        if (Math.random() * 100 < lootTable.speciesShardChance()) {
            int amount = (int) Math.round(lootTable.speciesShardAmount());
            for (int i = 0; i < amount; i++) {
                PlayerInventoryHelper.addOrDrop(killer, Shard.createForSpecies(killedPokemon.getSpecies()));
            }
        }

        // Handle elemental shard drops
        if (Math.random() * 100 < lootTable.elementalShardChance()) {
            int amount = (int) Math.round(lootTable.elementalShardAmount());
            for (int i = 0; i < amount; i++) {
                PlayerInventoryHelper.addOrDrop(killer, Shard.createForElement(killedPokemon.getSpecies().getPrimaryType()));
            }
            if (killedPokemon.getSpecies().getSecondaryType() != null) {
                for (int i = 0; i < amount; i++) {
                    PlayerInventoryHelper.addOrDrop(killer, Shard.createForElement(killedPokemon.getSpecies().getSecondaryType()));
                }
            }
        }
    }
}
