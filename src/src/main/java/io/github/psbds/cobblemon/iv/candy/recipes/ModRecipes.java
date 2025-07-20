package io.github.psbds.cobblemon.iv.candy.recipes;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.recipes.candy.CandyRecipe;
import io.github.psbds.cobblemon.iv.candy.recipes.candy.CandyRecipeSerializer;
import io.github.psbds.cobblemon.iv.candy.recipes.iv_extractor.IVExtractorRecipe;
import io.github.psbds.cobblemon.iv.candy.recipes.iv_extractor.IVExtractorRecipeSerializer;
import io.github.psbds.cobblemon.iv.candy.recipes.super_candy.SuperCandyRecipe;
import io.github.psbds.cobblemon.iv.candy.recipes.super_candy.SuperCandyRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {

    public static final RecipeType<SuperCandyRecipe> SUPER_CANDY_RECIPE_TYPE = registerTypeAndSerializer(
            SuperCandyRecipeSerializer.ID,
            SuperCandyRecipeSerializer.INSTANCE);

    public static final RecipeType<CandyRecipe> CANDY_RECIPE_TYPE = registerTypeAndSerializer(
            CandyRecipeSerializer.ID,
            CandyRecipeSerializer.INSTANCE);

    public static final RecipeType<IVExtractorRecipe> IV_EXTRACTOR_RECIPE_TYPE = registerTypeAndSerializer(
            IVExtractorRecipeSerializer.ID,
            IVExtractorRecipeSerializer.INSTANCE);

    public static void registerRecipes() {
        Boot.LOGGER.info("Registering Custom Recipes for " + Boot.MOD_ID);
        Boot.LOGGER.info("Registered recipe serializer: " + SuperCandyRecipeSerializer.ID);
        Boot.LOGGER.info("Registered recipe serializer: " + CandyRecipeSerializer.ID);
        Boot.LOGGER.info("Registered recipe serializer: " + IVExtractorRecipeSerializer.ID);
    }

    public static <T extends net.minecraft.world.item.crafting.Recipe<?>> RecipeSerializer<T> registerSerializer(
            RecipeType<T> type, String id, RecipeSerializer<T> serializer) {
        return Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, id),
                serializer);
    }

    public static <T extends net.minecraft.world.item.crafting.Recipe<?>> RecipeType<T> registerType(String id) {
        return Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, id),
                new RecipeType<T>() {
                    @Override
                    public String toString() {
                        return id;
                    }
                });
    }

    public static <T extends net.minecraft.world.item.crafting.Recipe<?>> RecipeType<T> registerTypeAndSerializer(
            String id, RecipeSerializer<T> serializer) {
        RecipeType<T> type = registerType(id);
        registerSerializer(type, id, serializer);
        return type;
    }
}