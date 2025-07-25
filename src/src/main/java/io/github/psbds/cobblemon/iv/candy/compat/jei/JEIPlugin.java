package io.github.psbds.cobblemon.iv.candy.compat.jei;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.compat.jei.items.candy.JEICandyRecipe;
import io.github.psbds.cobblemon.iv.candy.compat.jei.items.candy.JEICandyRecipeCategory;
import io.github.psbds.cobblemon.iv.candy.compat.jei.items.iv_extractor.JEIIVExtractorRecipe;
import io.github.psbds.cobblemon.iv.candy.compat.jei.items.iv_extractor.JEIIVExtractorRecipeCategory;
import io.github.psbds.cobblemon.iv.candy.compat.jei.items.super_candy.JEISuperCandyRecipe;
import io.github.psbds.cobblemon.iv.candy.compat.jei.items.super_candy.JEISuperCandyRecipeCategory;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardCatalog;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// Registered via fabric.mod.json entrypoint instead of annotation
public class JEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, "main_jei_integration");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        Boot.LOGGER.info("Registering JEI item subtypes for " + Boot.MOD_ID);

        registration.registerSubtypeInterpreter(VanillaTypes.ITEM_STACK, ModItems.SHARD, (stack, context) -> {
            // Use the shard's unique identifier as its subtype
            return stack.get(DataComponents.CUSTOM_NAME).getString();
        });

        registration.registerSubtypeInterpreter(VanillaTypes.ITEM_STACK, ModItems.CANDY, (stack, context) -> {
            // Use the shard's unique identifier as its subtype
            return stack.get(DataComponents.CUSTOM_NAME).getString();
        });

        registration.registerSubtypeInterpreter(VanillaTypes.ITEM_STACK, ModItems.IV_EXTRACTOR, (stack, context) -> {
            // Use the shard's unique identifier as its subtype
            return stack.get(DataComponents.CUSTOM_NAME).getString();
        });
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        Boot.LOGGER.info("Registering JEI categories for " + Boot.MOD_ID);

        registration.addRecipeCategories(new JEICandyRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new JEISuperCandyRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new JEIIVExtractorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        Boot.LOGGER.info("Successfully registered JEI categories");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Boot.LOGGER.info("Registering JEI recipes for " + Boot.MOD_ID);

        // Add Recipes
        registration.addRecipes(JEICandyRecipeCategory.RECIPE_TYPE, JEICandyRecipe.getRecipes());
        registration.addRecipes(JEISuperCandyRecipeCategory.RECIPE_TYPE, JEISuperCandyRecipe.getRecipes());
        registration.addRecipes(JEIIVExtractorRecipeCategory.RECIPE_TYPE, JEIIVExtractorRecipe.getRecipes());

        // Add Ingredients
        for (var shard : ShardCatalog.getCatalogShards()) {
            registration.addIngredientInfo(shard, VanillaTypes.ITEM_STACK,
                    Component.translatable("jei.cobblemon_iv_candy.shard.description"));
        }

        Boot.LOGGER.info("Successfully registered JEI recipes and ingredients");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        Boot.LOGGER.info("Registering JEI recipe catalysts for " + Boot.MOD_ID);

        // Register crafting table as a catalyst for our custom recipe types
        registration.addRecipeCatalyst(new ItemStack(Items.CRAFTING_TABLE), JEICandyRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(Items.CRAFTING_TABLE), JEISuperCandyRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(Items.CRAFTING_TABLE), JEIIVExtractorRecipeCategory.RECIPE_TYPE);

        Boot.LOGGER.info("Successfully registered JEI recipe catalysts");
    }
}
