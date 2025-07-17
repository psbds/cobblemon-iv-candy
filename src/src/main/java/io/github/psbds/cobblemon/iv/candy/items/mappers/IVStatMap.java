package io.github.psbds.cobblemon.iv.candy.items.mappers;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;

public class IVStatMap {

    public static String getIVStat(Stats stat) {
        switch (stat) {
            case HP:
                return "hp";
            case ATTACK:
                return "attack";
            case DEFENCE:
                return "defense";
            case SPECIAL_ATTACK:
                return "special_attack";
            case SPECIAL_DEFENCE:
                return "special_defense";
            case SPEED:
                return "speed";
            default:
                throw new IllegalArgumentException("Unknown IV stat: " + stat);
        }
    }

    public static Stats getStats(String ivStat) {
        switch (ivStat.toLowerCase()) {
            case "hp":
                return Stats.HP;
            case "attack":
                return Stats.ATTACK;
            case "defense":
                return Stats.DEFENCE;
            case "special_attack":
                return Stats.SPECIAL_ATTACK;
            case "special_defense":
                return Stats.SPECIAL_DEFENCE;
            case "speed":
                return Stats.SPEED;
            default:
                throw new IllegalArgumentException("Unknown IV stat: " + ivStat);
        }
    }
}
