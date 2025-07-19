package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.types.ElementalType;

import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;

public class CandyModel {

    // Special category base values to avoid conflicts
    private static final int LEGENDARY_BASE = 2000;
    private static final int MYTHICAL_BASE = 3000;
    private static final int ULTRABEAST_BASE = 4000;
    private static final int PARADOX_BASE = 5000;

    /**
     * Regular elemental type candies with stat combinations
     * Formula: 1000 + (typeId * 10) + statId
     */
    public static int getElemental(int elementalTypeId, Stats targetIVStat) {
        int baseValue = 1000; // Start high to avoid conflicts with existing values
        int statMultiplier = getStatMultiplier(targetIVStat);
        return baseValue + (elementalTypeId * 10) + statMultiplier;
    }

    public static int getElemental(ElementalType elementalType, Stats targetIVStat) {
        int elementalTypeId = ElementalTypeMap.getElementalTypeId(elementalType);
        return getElemental(elementalTypeId, targetIVStat);
    }

    /**
     * Legendary candies with stat combinations
     * Formula: 2000 + statId
     */
    public static int getLegendary(Stats targetIVStat) {
        int statMultiplier = getStatMultiplier(targetIVStat);
        return LEGENDARY_BASE + statMultiplier;
    }

    /**
     * Mythical candies with stat combinations
     * Formula: 3000 + statId
     */
    public static int getMythical(Stats targetIVStat) {
        int statMultiplier = getStatMultiplier(targetIVStat);
        return MYTHICAL_BASE + statMultiplier;
    }

    /**
     * Ultra Beast candies with stat combinations
     * Formula: 4000 + statId
     */
    public static int getUltraBeast(Stats targetIVStat) {
        int statMultiplier = getStatMultiplier(targetIVStat);
        return ULTRABEAST_BASE + statMultiplier;
    }

    /**
     * Paradox candies with stat combinations
     * Formula: 5000 + statId
     */
    public static int getParadox(Stats targetIVStat) {
        int statMultiplier = getStatMultiplier(targetIVStat);
        return PARADOX_BASE + statMultiplier;
    }

    private static int getStatMultiplier(Stats stat) {
        if (stat == null)
            return 0; // Random IV
        switch (stat) {
            case HP:
                return 1;
            case ATTACK:
                return 2;
            case DEFENCE:
                return 3;
            case SPECIAL_ATTACK:
                return 4;
            case SPECIAL_DEFENCE:
                return 5;
            case SPEED:
                return 6;
            default:
                return 0;
        }
    }
}
