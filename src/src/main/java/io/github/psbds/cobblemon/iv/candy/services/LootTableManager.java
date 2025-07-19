package io.github.psbds.cobblemon.iv.candy.services;

import com.cobblemon.mod.common.pokemon.Pokemon;
import io.github.psbds.cobblemon.iv.candy.config.ConfigManager;
import io.github.psbds.cobblemon.iv.candy.config.ModConfig;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardType;

public class LootTableManager {

    public static LootTable getLootTable(Pokemon pokemon) {
        ModConfig config = ConfigManager.getConfig();

        // Determine the Pokémon type based on its labels
        String shardType = ShardType.getShardType(pokemon.getSpecies());

        // Get appropriate drop chances and amounts based on Pokémon type
        double speciesChance, speciesAmount, elementalChance, elementalAmount;

        switch (shardType) {
            case ShardType.LEGENDARY:
                speciesChance = config.pokemon_legendary_drop_chance;
                speciesAmount = config.pokemon_legendary_drop_amount;
                elementalChance = config.pokemon_legendary_drop_chance;
                elementalAmount = config.pokemon_legendary_drop_amount;
                break;

            case ShardType.MYTHICAL:
                speciesChance = config.pokemon_mythical_drop_chance;
                speciesAmount = config.pokemon_mythical_drop_amount;
                elementalChance = config.pokemon_mythical_drop_chance;
                elementalAmount = config.pokemon_mythical_drop_amount;
                break;

            case ShardType.ULTRA_BEAST:
                speciesChance = config.pokemon_ultra_beast_drop_chance;
                speciesAmount = config.pokemon_ultra_beast_drop_amount;
                elementalChance = config.pokemon_ultra_beast_drop_chance;
                elementalAmount = config.pokemon_ultra_beast_drop_amount;
                break;

            case ShardType.PARADOX:
                speciesChance = config.pokemon_paradox_drop_chance;
                speciesAmount = config.pokemon_paradox_drop_amount;
                elementalChance = config.pokemon_paradox_drop_chance;
                elementalAmount = config.pokemon_paradox_drop_amount;
                break;

            case ShardType.SPECIES:
            default:
                speciesChance = config.pokemon_species_drop_chance;
                speciesAmount = config.pokemon_species_drop_amount;
                elementalChance = config.pokemon_type_drop_chance;
                elementalAmount = config.pokemon_type_drop_amount;
                break;
        }

        return new LootTable(speciesChance, speciesAmount, elementalChance, elementalAmount);
    }
}
