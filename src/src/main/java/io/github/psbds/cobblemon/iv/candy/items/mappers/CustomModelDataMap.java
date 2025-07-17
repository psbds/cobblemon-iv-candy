package io.github.psbds.cobblemon.iv.candy.items.mappers;

public class CustomModelDataMap {

    public static int getElementalTypeCustoModelData(int elementalTypeId) {
        return 100 + elementalTypeId; // Custom model data starts at 100
    }
}
