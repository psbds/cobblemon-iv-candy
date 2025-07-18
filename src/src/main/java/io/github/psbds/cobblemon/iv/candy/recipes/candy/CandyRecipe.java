package io.github.psbds.cobblemon.iv.candy.recipes.candy;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.level.Level;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;

public class CandyRecipe implements CraftingRecipe {

    public CandyRecipe() {
    }

    @Override
    public ItemStack assemble(CraftingInput recipeInput, Provider provider) {
        Boot.LOGGER.info("CALLING ASSEMBLE METHOD FOR CANDYHPRECIPE");
        var shard = recipeInput.getItem(0);
        if (shard.isEmpty()) {
            return ItemStack.EMPTY;
        }

        var shardData = shard.get(DataShard.COMPONENT);
        if (shardData == null) {
            return ItemStack.EMPTY;
        }

        try {

            return Candy.create(shard, null);
        } catch (Exception e) {
            Boot.LOGGER.error("Error creating Candy item: ", e);
            return ItemStack.EMPTY;
        }
    }

    @Override
    public boolean matches(CraftingInput recipeInput, Level level) {
        return CandyRecipeMatcher.matches(recipeInput, level);
    }

    @Override
    public ItemStack getResultItem(Provider provider) {
        // Return an empty ItemStack for the recipe book display
        // The actual result is determined in the assemble method
        return new ItemStack(ModItems.CANDY);
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        if (i == 3 && j == 3) {
            return true;
        }
        return false;
    }

    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CandyRecipeSerializer.INSTANCE;
    }

}
