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
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;

public class CandyRecipe implements CraftingRecipe {

    public CandyRecipe() {
    }

    @Override
    public ItemStack assemble(CraftingInput recipeInput, Provider provider) {
        var shard = recipeInput.getItem(0);
        if (shard.isEmpty()) {
            return ItemStack.EMPTY;
        }

        var shardData = shard.get(DataShard.COMPONENT);
        if (shardData == null) {
            return ItemStack.EMPTY;
        }

        return Candy.create(shard, null);
    }

    @Override
    public boolean matches(CraftingInput recipeInput, Level level) {
        return CandyRecipeMatcher.matches(recipeInput, level);
    }

    @Override
    public ItemStack getResultItem(Provider provider) {
        return CandyFactory.createForSpeciesSample(null);
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