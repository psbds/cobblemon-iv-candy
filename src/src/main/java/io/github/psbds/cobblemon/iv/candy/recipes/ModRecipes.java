package io.github.psbds.cobblemon.iv.candy.recipes;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.recipes.hp_candy.CandyHPRecipe;
import io.github.psbds.cobblemon.iv.candy.recipes.hp_candy.CandyRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {

    public static final RecipeSerializer<CandyHPRecipe> CANDY_HP_RECIPE_SERIALIZER = 
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, 
            ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, CandyRecipeSerializer.ID), 
            CandyRecipeSerializer.INSTANCE);
   
    public static final RecipeType<CandyHPRecipe> CANDY_HP_RECIPE_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE, 
            ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, CandyRecipeSerializer.ID), 
            new RecipeType<CandyHPRecipe>() {
                @Override
                public String toString() {
                    return CandyRecipeSerializer.ID;
                }
            });

    public static void registerRecipes() {
        Boot.LOGGER.info("Registering Custom Recipes for " + Boot.MOD_ID);
        Boot.LOGGER.info("Registered recipe serializer: " + CandyRecipeSerializer.ID);
    }
}