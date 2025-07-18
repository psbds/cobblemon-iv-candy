package io.github.psbds.cobblemon.iv.candy.recipes.candy;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class CandyRecipeSerializer implements RecipeSerializer<CandyRecipe> {

    private static final CandyRecipe RECIPE_INSTANCE = new CandyRecipe();

    private CandyRecipeSerializer() {
    }

    public static final CandyRecipeSerializer INSTANCE = new CandyRecipeSerializer();
    public static final String ID = "candy_recipe";

    @Override
    public MapCodec<CandyRecipe> codec() {
        return RecordCodecBuilder.mapCodec(instance -> instance.point(RECIPE_INSTANCE));
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CandyRecipe> streamCodec() {
        return StreamCodec.unit(RECIPE_INSTANCE);
    }
}
