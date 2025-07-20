package io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor;

import com.cobblemon.mod.common.api.types.ElementalType;

import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;

public class IVExtractorModel {

    // Special category base values to avoid conflicts
    private static final int LEGENDARY_BASE = 2000;
    private static final int MYTHICAL_BASE = 3000;
    private static final int ULTRABEAST_BASE = 4000;
    private static final int PARADOX_BASE = 5000;

    /**
     * Regular elemental type candies
     * Formula: 1000 + typeId 
     */
    public static int getElemental(int elementalTypeId) {
        int baseValue = 1000; // Start high to avoid conflicts with existing values
        
        return baseValue + elementalTypeId;
    }

    public static int getElemental(ElementalType elementalType) {
        int elementalTypeId = ElementalTypeMap.getElementalTypeId(elementalType);
        return getElemental(elementalTypeId);
    }

    /**
     * Legendary candies
     * Formula: 2000
     */
    public static int getLegendary() {
        
        return LEGENDARY_BASE;
    }

    /**
     * Mythical candies
     * Formula: 3000
     */
    public static int getMythical() {
        
        return MYTHICAL_BASE;
    }

    /**
     * Ultra Beast candies
     * Formula: 4000
     */
    public static int getUltraBeast() {
        
        return ULTRABEAST_BASE;
    }

    /**
     * Paradox candies
     * Formula: 5000
     */
    public static int getParadox() {
        
        return PARADOX_BASE;
    }

}
