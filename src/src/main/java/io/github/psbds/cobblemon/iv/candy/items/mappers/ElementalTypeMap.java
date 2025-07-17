package io.github.psbds.cobblemon.iv.candy.items.mappers;

import com.cobblemon.mod.common.api.types.ElementalType;

public class ElementalTypeMap {

    public static int getElementalTypeId(ElementalType elementalType) {
        switch (elementalType.getName().toLowerCase()) {
            case "fire":
                return 0;
            case "water":
                return 1;
            case "grass":
                return 2;
            case "electric":
                return 3;
            case "ice":
                return 4;
            case "rock":
                return 5;
            case "ground":
                return 6;
            case "flying":
                return 7;
            case "psychic":
                return 8;
            case "bug":
                return 9;
            case "poison":
                return 10;
            case "fighting":
                return 11;
            case "ghost":
                return 12;
            case "dragon":
                return 13;
            case "dark":
                return 14;
            case "steel":
                return 15;
            case "fairy":
                return 16;
            case "normal":
                return 17;
            default:
                throw new IllegalArgumentException("Unknown elemental type: " + elementalType);
        }
    }

    public static int getElementalTypeId(String elementalType) {
        switch (elementalType.toLowerCase()) {
            case "fire":
                return 0;
            case "water":
                return 1;
            case "grass":
                return 2;
            case "electric":
                return 3;
            case "ice":
                return 4;
            case "rock":
                return 5;
            case "ground":
                return 6;
            case "flying":
                return 7;
            case "psychic":
                return 8;
            case "bug":
                return 9;
            case "poison":
                return 10;
            case "fighting":
                return 11;
            case "ghost":
                return 12;
            case "dragon":
                return 13;
            case "dark":
                return 14;
            case "steel":
                return 15;
            case "fairy":
                return 16;
            case "normal":
                return 17;
            default:
                throw new IllegalArgumentException("Unknown elemental type: " + elementalType);

        }
    }
}
