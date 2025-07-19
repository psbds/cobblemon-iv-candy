package io.github.psbds.cobblemon.iv.candy.compat.jei.items.super_candy;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class JEISuperCandyRecipeCategory implements IRecipeCategory<JEISuperCandyRecipe> {
    public static final RecipeType<JEISuperCandyRecipe> RECIPE_TYPE = RecipeType.create(Boot.MOD_ID, "jei_super_candy_recipe", JEISuperCandyRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final Component title;

    public JEISuperCandyRecipeCategory(IGuiHelper guiHelper) {
        // Create a 3x3 crafting grid background (like crafting table)
        this.background = guiHelper.createDrawable(
                ResourceLocation.fromNamespaceAndPath("minecraft", "textures/gui/container/crafting_table.png"),
                29, 16, 116, 54);

        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, CandyFactory.createForSpeciesSample(null));
        this.title = Component.translatable("jei.cobblemon_iv_candy.super_candy_recipe");
    }

    @Override
    public RecipeType<JEISuperCandyRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return title;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, JEISuperCandyRecipe recipe, IFocusGroup focuses) {
        // Super candy recipe uses a 3x3 pattern with 8 shards around the border and a special item in the center
        ItemStack shardStack = recipe.inputShard();
        ItemStack middleItem = recipe.middleItem();

        // 3x3 grid positions (18 pixels apart)
        // Top row
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addItemStack(shardStack);
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 1)
                .addItemStack(shardStack);
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 1)
                .addItemStack(shardStack);

        // Middle row - sides only, center is for special item
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 19)
                .addItemStack(shardStack);
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 19)
                .addItemStack(middleItem); // Special item in center
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 19)
                .addItemStack(shardStack);

        // Bottom row
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 37)
                .addItemStack(shardStack);
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 37)
                .addItemStack(shardStack);
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 37)
                .addItemStack(shardStack);

        // Output slot (super candy) - positioned to the right of the crafting grid
        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 19)
                .addItemStack(recipe.outputCandy());
    }
}
