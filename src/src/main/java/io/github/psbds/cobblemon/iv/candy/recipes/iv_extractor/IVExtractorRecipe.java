package io.github.psbds.cobblemon.iv.candy.recipes.iv_extractor;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.level.Level;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractor;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorFactory;

public class IVExtractorRecipe implements CraftingRecipe {

    public IVExtractorRecipe() {
    }

    @Override
    public ItemStack assemble(CraftingInput recipeInput, Provider provider) {
        Boot.LOGGER.info("CALLING ASSEMBLE METHOD FOR IV EXTRACTOR RECIPE");
        var shard = recipeInput.getItem(2);
        if (shard.isEmpty()) {
            return ItemStack.EMPTY;
        }
        var shardData = shard.get(DataShard.COMPONENT);
        if (shardData == null) {
            return ItemStack.EMPTY;
        }

        return IVExtractor.create(shard);
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
        return new ItemStack(IVExtractorFactory.createDefault());
    }

    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return IVExtractorRecipeSerializer.INSTANCE;
    }

    @Override
    public boolean matches(CraftingInput recipeInput, Level level) {
        return IVExtractorRecipeMatcher.matches(recipeInput, level);
    }
}