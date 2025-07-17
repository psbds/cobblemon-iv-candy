package io.github.psbds.cobblemon.iv.candy.recipes.hp_candy;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.level.Level;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.components.DataPokedexNumber;
import io.github.psbds.cobblemon.iv.candy.items.mappers.IVStatMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;

public class CandyHPRecipe implements CraftingRecipe {

    public CandyHPRecipe() {
    }

    @Override
    public ItemStack assemble(CraftingInput recipeInput, Provider provider) {
        Boot.LOGGER.info("CALLING ASSEMBLE METHOD FOR CANDYHPRECIPE");

        var shard = recipeInput.getItem(0);
        if (shard.isEmpty()) {
            return ItemStack.EMPTY;
        }

        var shardPokedexNumber = shard.get(DataPokedexNumber.COMPONENT);
        if (shardPokedexNumber == null) {
            return ItemStack.EMPTY;
        }

        var species = CobblemonSpeciesHelper.getSpeciesByPokedexNumber(shardPokedexNumber.baseSpeciesPokedexNumber());
        if (species == null) {
            return ItemStack.EMPTY;
        }

        var middleItem = recipeInput.getItem(4); // Center item in 3x3 grid
        if (middleItem.isEmpty()) {
            return ItemStack.EMPTY;
        }

        Boot.LOGGER.info("Middle item: {}", middleItem.getItem().toString());
        if (middleItem.is(CobblemonItems.BLACK_APRICORN)) {
            return Candy.create(species, IVStatMap.getIVStat(Stats.SPECIAL_ATTACK), null);
        }
        if (middleItem.is(CobblemonItems.YELLOW_APRICORN)) {
            return Candy.create(species, IVStatMap.getIVStat(Stats.ATTACK), null);
        }
        if (middleItem.is(CobblemonItems.RED_APRICORN)) {
            return Candy.create(species, IVStatMap.getIVStat(Stats.HP), null);
        }
        if (middleItem.is(CobblemonItems.GREEN_APRICORN)) {
            return Candy.create(species, IVStatMap.getIVStat(Stats.DEFENCE), null);
        }
        if (middleItem.is(CobblemonItems.BLUE_APRICORN)) {
            return Candy.create(species, IVStatMap.getIVStat(Stats.SPECIAL_DEFENCE), null);
        }
        if (middleItem.is(CobblemonItems.WHITE_APRICORN)) {
            return Candy.create(species, IVStatMap.getIVStat(Stats.SPEED), null);
        }

        // Return empty instead of null as fallback
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        if (i == 3 && j == 3) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getResultItem(Provider provider) {
        // Return an empty ItemStack for the recipe book display
        // The actual result is determined in the assemble method
        return ItemStack.EMPTY;
    }

    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CandyRecipeSerializer.INSTANCE;
    }

    @Override
    public boolean matches(CraftingInput recipeInput, Level level) {
        Boot.LOGGER.info("Checking CandyHPRecipe match");
        Boot.LOGGER.info("Grid size: {}x{}", recipeInput.width(), recipeInput.height());

        // Check if it's a 3x3 crafting grid
        if (recipeInput.width() != 3 || recipeInput.height() != 3) {
            Boot.LOGGER.info("Grid size is not 3x3, returning false");
            return false;
        }

        // Check center position (position 5, index 4) for silver ingot
        ItemStack centerItem = recipeInput.getItem(4); // Index 4 is position 5 (center)
        if (centerItem.isEmpty()) {
            Boot.LOGGER.info("Center item is empty, returning false");
            return false;
        }
        Boot.LOGGER.info("Center item: {}", centerItem.getItem().toString());

        // Check all other positions (1,2,3,4,6,7,8,9) for cobblemon_iv_candy
        // Positions correspond to indices: 0,1,2,3,5,6,7,8 (skipping index 4 which is
        // center)
        int[] candyPositions = { 0, 1, 2, 3, 5, 6, 7, 8 };

        var targetSpecies = -1;
        for (int index : candyPositions) {
            ItemStack item = recipeInput.getItem(index);
            Boot.LOGGER.info("Position {} item: {}", index, item.getItem().toString());

            // Check if item is empty first
            if (item.isEmpty()) {
                Boot.LOGGER.info("Position {} is empty, returning false", index);
                return false;
            }

            // Check if it's the IV candy from this mod
            if (!item.is(io.github.psbds.cobblemon.iv.candy.items.ModItems.SHARD)) {
                Boot.LOGGER.info("Position {} is not candy_species_random, returning false", index);
                return false;
            }

            var species = item.get(DataPokedexNumber.COMPONENT);
            if (species == null) {
                Boot.LOGGER.info("Position {} has null species data, returning false", index);
                return false;
            }

            if (targetSpecies == -1) {
                targetSpecies = species.baseSpeciesPokedexNumber();
            } else if (targetSpecies != species.baseSpeciesPokedexNumber()) {
                Boot.LOGGER.info("Position {} has different species, returning false", index);
                return false;
            }
        }

        if (centerItem.is(CobblemonItems.BLACK_APRICORN)
                || centerItem.is(CobblemonItems.YELLOW_APRICORN)
                || centerItem.is(CobblemonItems.RED_APRICORN)
                || centerItem.is(CobblemonItems.GREEN_APRICORN)
                || centerItem.is(CobblemonItems.BLUE_APRICORN)
                || centerItem.is(CobblemonItems.WHITE_APRICORN)) {
            Boot.LOGGER.info("All checks passed, recipe matches!");
            return true;
        }
        Boot.LOGGER.info("Center item is not apricorn");

        return true;
    }

}
