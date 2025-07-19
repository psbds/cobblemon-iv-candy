package io.github.psbds.cobblemon.iv.candy.config;

import com.google.gson.annotations.SerializedName;

/**
 * Configuration class for the Cobblemon IV Candy mod.
 * This class defines all configurable settings for the mod.
 */
public class ModConfig {
    @SerializedName("pokemon_species_drop_chance")
    public double pokemon_species_drop_chance = 10;

    @SerializedName("pokemon_species_drop_amount")
    public double pokemon_species_drop_amount = 1;

    @SerializedName("pokemon_type_drop_chance")
    public double pokemon_type_drop_chance = 5;

    @SerializedName("pokemon_type_drop_amount")
    public double pokemon_type_drop_amount = 1;

    @SerializedName("pokemon_legendary_drop_chance")
    public double pokemon_legendary_drop_chance = 100;

    @SerializedName("pokemon_legendary_drop_amount")
    public double pokemon_legendary_drop_amount = 1;

    @SerializedName("pokemon_mythical_drop_chance")
    public double pokemon_mythical_drop_chance = 100;

    @SerializedName("pokemon_mythical_drop_amount")
    public double pokemon_mythical_drop_amount = 1;

    @SerializedName("pokemon_ultra_beast_drop_chance")
    public double pokemon_ultra_beast_drop_chance = 100;

    @SerializedName("pokemon_ultra_beast_drop_amount")
    public double pokemon_ultra_beast_drop_amount = 1;

    @SerializedName("pokemon_paradox_drop_chance")
    public double pokemon_paradox_drop_chance = 100;

    @SerializedName("pokemon_paradox_drop_amount")
    public double pokemon_paradox_drop_amount = 1;

    public void validate() {
        if (pokemon_species_drop_chance < 0 || pokemon_species_drop_chance > 100) {
            throw new IllegalArgumentException("pokemon_species_drop_chance must be between 0 and 100");
        }
        if (pokemon_type_drop_chance < 0 || pokemon_type_drop_chance > 100) {
            throw new IllegalArgumentException("pokemon_type_drop_chance must be between 0 and 100");
        }
        if (pokemon_legendary_drop_chance < 0 || pokemon_legendary_drop_chance > 100) {
            throw new IllegalArgumentException("pokemon_legendary_drop_chance must be between 0 and 100");
        }
        if (pokemon_mythical_drop_chance < 0 || pokemon_mythical_drop_chance > 100) {
            throw new IllegalArgumentException("pokemon_mythical_drop_chance must be between 0 and 100");
        }
        if (pokemon_ultra_beast_drop_chance < 0 || pokemon_ultra_beast_drop_chance > 100) {
            throw new IllegalArgumentException("pokemon_ultra_beast_drop_chance must be between 0 and 100");
        }
        if (pokemon_paradox_drop_chance < 0 || pokemon_paradox_drop_chance > 100) {
            throw new IllegalArgumentException("pokemon_paradox_drop_chance must be between 0 and 100");
        }
    }
}
