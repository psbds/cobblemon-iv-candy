package io.github.psbds.cobblemon.iv.candy.items.model;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;

import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;

public class CustomModelDataMap {

    public static int getElementalTypeCustomModelData(int elementalTypeId) {
        return 100 + elementalTypeId; // Custom model data starts at 100
    }

    public static int getElementalTypeCustomModelData(ElementalType elementalType) {
        int elementalTypeId = ElementalTypeMap.getElementalTypeId(elementalType);
        return 100 + elementalTypeId; // Custom model data starts at 100
    }

    public static int getCustomModelForLegendary() {
        return 200;
    }

    public static int getCustomModelForMythical() {
        return 201;
    }

    public static int getCustomModelForUltraBeast() {
        return 202;
    }

    public static int getCustomModelForParadox() {
        return 203;
    }
}
