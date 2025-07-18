package io.github.psbds.cobblemon.iv.candy.items.mappers;

public class CustomModelDataMap {

    public static int getElementalTypeCustoModelData(int elementalTypeId) {
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
