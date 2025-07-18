package io.github.psbds.cobblemon.iv.candy.recipes.super_candy;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class SuperCandyRecipeSerializer implements RecipeSerializer<SuperCandyRecipe> {

    private static final SuperCandyRecipe RECIPE_INSTANCE = new SuperCandyRecipe();

    private SuperCandyRecipeSerializer() {
    }

    public static final SuperCandyRecipeSerializer INSTANCE = new SuperCandyRecipeSerializer();
    public static final String ID = "super_candy_recipe";

    @Override
    public MapCodec<SuperCandyRecipe> codec() {
        return RecordCodecBuilder.mapCodec(instance -> instance.point(RECIPE_INSTANCE));
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, SuperCandyRecipe> streamCodec() {
        return StreamCodec.unit(RECIPE_INSTANCE);
    }
}
