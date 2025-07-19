package io.github.psbds.cobblemon.iv.candy.compat.jei.items.candy;

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

public class JEICandyRecipeCategory implements IRecipeCategory<JEICandyRecipe> {
    public static final RecipeType<JEICandyRecipe> RECIPE_TYPE = RecipeType.create(Boot.MOD_ID, "jei_candy_recipe", JEICandyRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final Component title;

    public JEICandyRecipeCategory(IGuiHelper guiHelper) {
        // Create a 3x1 crafting grid background
        this.background = guiHelper.createDrawable(
                ResourceLocation.fromNamespaceAndPath("minecraft", "textures/gui/container/crafting_table.png"),
                29, 16, 108, 18);

        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, CandyFactory.createForSpeciesSample(null));
        this.title = Component.translatable("jei.cobblemon_iv_candy.candy_recipe");
    }

    @Override
    public RecipeType<JEICandyRecipe> getRecipeType() {
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
    public void setRecipe(IRecipeLayoutBuilder builder, JEICandyRecipe recipe, IFocusGroup focuses) {
        // Basic candy recipe uses a 3x1 pattern (3 shards in the top row)
        ItemStack shardStack = recipe.inputShard();

        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addItemStack(shardStack);

        builder.addSlot(RecipeIngredientRole.INPUT, 19, 1)
                .addItemStack(shardStack);

        builder.addSlot(RecipeIngredientRole.INPUT, 37, 1)
                .addItemStack(shardStack);

        // Output slot (candy)
        builder.addSlot(RecipeIngredientRole.OUTPUT, 91, 1)
                .addItemStack(recipe.outputCandy());
    }
}
