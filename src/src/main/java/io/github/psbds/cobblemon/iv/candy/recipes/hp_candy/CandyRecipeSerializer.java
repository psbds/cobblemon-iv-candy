package io.github.psbds.cobblemon.iv.candy.recipes.hp_candy;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class CandyRecipeSerializer implements RecipeSerializer<CandyHPRecipe> {

    private static final CandyHPRecipe RECIPE_INSTANCE = new CandyHPRecipe();

    private CandyRecipeSerializer() {
    }

    public static final CandyRecipeSerializer INSTANCE = new CandyRecipeSerializer();
    public static final String ID = "candy_recipe";

    @Override
    public MapCodec<CandyHPRecipe> codec() {
        return RecordCodecBuilder.mapCodec(instance -> instance.point(RECIPE_INSTANCE));
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CandyHPRecipe> streamCodec() {
        return StreamCodec.unit(RECIPE_INSTANCE);
    }
}
