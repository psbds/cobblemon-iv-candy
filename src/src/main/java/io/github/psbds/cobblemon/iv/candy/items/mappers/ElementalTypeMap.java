package io.github.psbds.cobblemon.iv.candy.items.mappers;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;

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

    public static String getElementalTypeId(int elementalTypeId) {
        switch (elementalTypeId) {
            case 0:
                return "fire";
            case 1:
                return "water";
            case 2:
                return "grass";
            case 3:
                return "electric";
            case 4:
                return "ice";
            case 5:
                return "rock";
            case 6:
                return "ground";
            case 7:
                return "flying";
            case 8:
                return "psychic";
            case 9:
                return "bug";
            case 10:
                return "poison";
            case 11:
                return "fighting";
            case 12:
                return "ghost";
            case 13:
                return "dragon";
            case 14:
                return "dark";
            case 15:
                return "steel";
            case 16:
                return "fairy";
            case 17:
                return "normal";
            default:
                throw new IllegalArgumentException("Unknown elemental type ID: " + elementalTypeId);
        }
    }

    public static ElementalType getElementalType(int elementalTypeId) {
        switch (elementalTypeId) {
            case 0:
                return ElementalTypes.INSTANCE.getFIRE();
            case 1:
                return ElementalTypes.INSTANCE.getWATER();
            case 2:
                return ElementalTypes.INSTANCE.getGRASS();
            case 3:
                return ElementalTypes.INSTANCE.getELECTRIC();
            case 4:
                return ElementalTypes.INSTANCE.getICE();
            case 5:
                return ElementalTypes.INSTANCE.getROCK();
            case 6:
                return ElementalTypes.INSTANCE.getGROUND();
            case 7:
                return ElementalTypes.INSTANCE.getFLYING();
            case 8:
                return ElementalTypes.INSTANCE.getPSYCHIC();
            case 9:
                return ElementalTypes.INSTANCE.getBUG();
            case 10:
                return ElementalTypes.INSTANCE.getPOISON();
            case 11:
                return ElementalTypes.INSTANCE.getFIGHTING();
            case 12:
                return ElementalTypes.INSTANCE.getGHOST();
            case 13:
                return ElementalTypes.INSTANCE.getDRAGON();
            case 14:
                return ElementalTypes.INSTANCE.getDARK();
            case 15:
                return ElementalTypes.INSTANCE.getSTEEL();
            case 16:
                return ElementalTypes.INSTANCE.getFAIRY();
            case 17:
                return ElementalTypes.INSTANCE.getNORMAL();
            default:
                throw new IllegalArgumentException("Unknown elemental type ID: " + elementalTypeId);
        }
    }
}
