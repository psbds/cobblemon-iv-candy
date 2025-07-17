package io.github.psbds.cobblemon.iv.candy.helpers;

import java.util.HashMap;
import java.util.Map;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.Boot;

public class CobblemonSpeciesHelper {

    private static Map<Integer, Species> speciesMap = new HashMap<>();

    public static Map<Integer, Species> getSpeciesMap() {
        if (speciesMap.isEmpty()) {
            for (Species species : PokemonSpecies.INSTANCE.getSpecies()) {
                speciesMap.put(species.getNationalPokedexNumber(), species);
            }
        }
        return speciesMap;
    }

    public static Species getFirstEvolution(Species species) {
        if (species.getPreEvolution() == null) {
            return species;
        }
        return getFirstEvolution(species.getPreEvolution().getSpecies());
    }

    public static Species getSpeciesByPokedexNumber(int pokedexNumber) {
        try {
            return getSpeciesMap().get(pokedexNumber);
        } catch (Exception e) {
            Boot.LOGGER.error("Error getting species by Pokédex number {}: {}", pokedexNumber, e.getMessage());
            throw e;
        }
    }
}
