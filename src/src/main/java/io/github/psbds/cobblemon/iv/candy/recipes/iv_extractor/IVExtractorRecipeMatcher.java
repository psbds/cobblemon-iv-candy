package io.github.psbds.cobblemon.iv.candy.recipes.iv_extractor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobblemon.mod.common.CobblemonItems;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.level.Level;

public class IVExtractorRecipeMatcher {
    public static final Logger LOGGER = LoggerFactory.getLogger(IVExtractorRecipeMatcher.class);

    public static Boolean matches(CraftingInput recipeInput, Level level) {
        // 1. Analyze Crafting Grid Size
        if (recipeInput.width() != 3 || recipeInput.height() != 3) {
            LOGGER.debug("Grid size is not 3x3, returning false");
            return false;
        }
        // 2. Analyze Middle Item
        if (!analyzeMiddleItem(recipeInput)) {
            LOGGER.debug("Middle item is not a valid apricorn, returning false");
            return false;
        }

        // 3. Analyze Bottom Item
        if (!analyzeBottomItem(recipeInput)) {
            LOGGER.debug("Bottom item is not a valid rare candy, returning false");
            return false;
        }

        // 4. Analyze Shards
        var lastShardType = analyzeShard(recipeInput);
        if (lastShardType == null) {
            LOGGER.debug("Shards do not match, returning false");
            return false;
        }

        return true;
    }

    public static Boolean analyzeMiddleItem(CraftingInput recipeInput) {
        LOGGER.debug("Analyzing Middle Item for IVExtractorRecipe");
        ItemStack centerItem = recipeInput.getItem(4); // Index 4 is position 5 (center)
        if (centerItem.isEmpty()) {
            LOGGER.debug("Center item is empty, returning false");
            return false;
        }
        if (centerItem.is(Items.BLAZE_ROD)) {
            return true;
        }

        LOGGER.debug("Center item is not a blaze rod, returning false");
        return false;
    }

    public static Boolean analyzeBottomItem(CraftingInput recipeInput) {
        LOGGER.debug("Analyzing Bottom Item for IVExtractorRecipe");
        ItemStack centerItem = recipeInput.getItem(6); // Index 6 is position 7
        if (centerItem.isEmpty()) {
            LOGGER.debug("Center item is empty, returning false");
            return false;
        }
        if (centerItem.is(CobblemonItems.RARE_CANDY)) {
            return true;
        }

        LOGGER.debug("Center item is not a rare candy, returning false");
        return false;
    }

    public static DataShard analyzeShard(CraftingInput recipeInput) {
        ItemStack item = recipeInput.getItem(2); // Index 2 is position 3

        // Check if item is empty first
        if (item.isEmpty()) {
            Boot.LOGGER.debug("Position {} is empty, returning false", 2);
            return null;
        }

        // Check if it's the IV candy from this mod
        if (!item.is(ModItems.SHARD)) {
            Boot.LOGGER.debug("Position {} is not candy_species_random, returning false", 2);
            return null;
        }

        var dataShard = item.get(DataShard.COMPONENT);
        if (dataShard == null) {
            return null;
        }

        if (dataShard.shardType() == ShardType.SPECIES) {
            return null;
        }

        return dataShard;
    }
}
