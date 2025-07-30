package io.github.psbds.cobblemon.iv.candy.recipes.super_candy;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.level.Level;

import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;

public class SuperCandyRecipe implements CraftingRecipe {

    public SuperCandyRecipe() {
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

        var targetIVStat = SuperCandyRecipeMatcher.analyzeMiddleItem(recipeInput);
        return Candy.create(shard, targetIVStat);
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
        return CandyFactory.createForSpeciesSample(null);
    }

    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SuperCandyRecipeSerializer.INSTANCE;
    }

    @Override
    public boolean matches(CraftingInput recipeInput, Level level) {
        return SuperCandyRecipeMatcher.matches(recipeInput, level);
    }
}