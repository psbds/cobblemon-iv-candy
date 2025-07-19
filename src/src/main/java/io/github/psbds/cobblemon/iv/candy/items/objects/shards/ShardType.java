package io.github.psbds.cobblemon.iv.candy.items.objects.shards;

import com.cobblemon.mod.common.pokemon.Species;

public class ShardType {
    public static final String SPECIES = "species";
    public static final String ELEMENTAL_TYPE = "elemental_type";
    public static final String LEGENDARY = "legendary";
    public static final String MYTHICAL = "mythical";
    public static final String ULTRA_BEAST = "ultra_beast";
    public static final String PARADOX = "paradox";

    public static String getShardType(Species pokemonSpecies) {
        var labels = pokemonSpecies.getLabels();
        if (labels.contains("legendary")) {
            return LEGENDARY;
        } else if (labels.contains("mythical")) {
            return MYTHICAL;
        } else if (labels.contains("ultra_beast")) {
            return ULTRA_BEAST;
        } else if (labels.contains("paradox")) {
            return PARADOX;
        }
        return SPECIES;
    }
}
