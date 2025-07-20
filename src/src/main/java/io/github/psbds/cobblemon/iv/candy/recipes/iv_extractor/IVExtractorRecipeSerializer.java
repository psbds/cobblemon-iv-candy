package io.github.psbds.cobblemon.iv.candy.recipes.iv_extractor;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class IVExtractorRecipeSerializer implements RecipeSerializer<IVExtractorRecipe> {

    private static final IVExtractorRecipe RECIPE_INSTANCE = new IVExtractorRecipe();

    private IVExtractorRecipeSerializer() {
    }

    public static final IVExtractorRecipeSerializer INSTANCE = new IVExtractorRecipeSerializer();
    public static final String ID = "iv_extractor_recipe";

    @Override
    public MapCodec<IVExtractorRecipe> codec() {
        return RecordCodecBuilder.mapCodec(instance -> instance.point(RECIPE_INSTANCE));
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, IVExtractorRecipe> streamCodec() {
        return StreamCodec.unit(RECIPE_INSTANCE);
    }
}
