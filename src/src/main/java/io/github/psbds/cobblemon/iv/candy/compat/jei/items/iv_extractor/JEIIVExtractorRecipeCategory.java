package io.github.psbds.cobblemon.iv.candy.compat.jei.items.iv_extractor;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorFactory;
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
import net.minecraft.world.item.Items;

public class JEIIVExtractorRecipeCategory implements IRecipeCategory<JEIIVExtractorRecipe> {
    public static final RecipeType<JEIIVExtractorRecipe> RECIPE_TYPE = RecipeType.create(Boot.MOD_ID, "jei_iv_extractor_recipe", JEIIVExtractorRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final Component title;

    public JEIIVExtractorRecipeCategory(IGuiHelper guiHelper) {
        // Create a 3x3 crafting grid background (like crafting table)
        this.background = guiHelper.createDrawable(
                ResourceLocation.fromNamespaceAndPath("minecraft", "textures/gui/container/crafting_table.png"),
                29, 16, 116, 54);

        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, IVExtractorFactory.createElement(ElementalTypes.INSTANCE.getNORMAL()));
        this.title = Component.translatable("jei.cobblemon_iv_candy.iv_extractor_recipe");
    }

    @Override
    public RecipeType<JEIIVExtractorRecipe> getRecipeType() {
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
    public void setRecipe(IRecipeLayoutBuilder builder, JEIIVExtractorRecipe recipe, IFocusGroup focuses) {
        ItemStack shardStack = recipe.inputShard();

        // Top row
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 1)
                .addItemStack(shardStack);

        // Middle row
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 19)
                .addItemStack(new ItemStack(Items.BLAZE_ROD));

        // Bottom row
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 37)
                .addItemStack(new ItemStack(CobblemonItems.RARE_CANDY));

        // Output slot
        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 19)
                .addItemStack(recipe.outputExtractor());
    }
}
