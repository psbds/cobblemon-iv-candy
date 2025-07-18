package io.github.psbds.cobblemon.iv.candy.recipes.candy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.constants.ShardType;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.level.Level;

public class CandyRecipeMatcher {
    public static final Logger LOGGER = LoggerFactory.getLogger(Boot.MOD_ID + "/CandySpeciesRecipe");

    public static Boolean matches(CraftingInput recipeInput, Level level) {
        // 1. Analyze Crafting Grid Size
        if (recipeInput.width() != 3 || recipeInput.height() != 1) {
            LOGGER.info("Grid size is not 3x1, returning false");
            return false;
        }

        // 2. Analyze Shards
        var lastShardType = analyzeShard(recipeInput);
        if (lastShardType == null) {
            LOGGER.info("Shards do not match, returning false");
            return false;
        }

        return true;
    }

    public static Object TryMatchSpecies(String lastShardType, Object lastObject, ItemStack itemStack) {
        var dataShard = itemStack.get(DataShard.COMPONENT);

        if (lastShardType != ShardType.SPECIES) {
            return null;
        }
        if (lastObject == null) {
            return dataShard.baseSpeciesPokedexNumber();
        }

        if (lastObject.equals(dataShard.baseSpeciesPokedexNumber())) {
            return dataShard.baseSpeciesPokedexNumber();
        }

        return true;
    }

    public static Object TryMatchElemental(String lastShardType, Object lastObject, ItemStack itemStack) {
        var dataShard = itemStack.get(DataShard.COMPONENT);

        if (lastShardType != ShardType.ELEMENTAL_TYPE) {
            return null;
        }
        if (lastObject == null) {
            return dataShard.elementalType();
        }

        if (lastObject.equals(dataShard.elementalType())) {
            return dataShard.elementalType();
        }

        return true;
    }

    public static Object TryMatchLegendary(String lastShardType, Object lastObject, ItemStack itemStack) {
        var dataShard = itemStack.get(DataShard.COMPONENT);

        if (lastShardType != ShardType.LEGENDARY) {
            return null;
        }
        if (lastObject == null) {
            return ShardType.LEGENDARY;
        }

        if (lastObject.equals(dataShard.elementalType())) {
            return dataShard.elementalType();
        }

        return true;
    }

    public static Object TryMatchMythical(String lastShardType, Object lastObject, ItemStack itemStack) {
        var dataShard = itemStack.get(DataShard.COMPONENT);

        if (lastShardType != ShardType.MYTHICAL) {
            return null;
        }
        if (lastObject == null) {
            return ShardType.MYTHICAL;
        }

        if (lastObject.equals(dataShard.elementalType())) {
            return dataShard.elementalType();
        }

        return true;
    }

    public static Object TryMatchUltrabeast(String lastShardType, Object lastObject, ItemStack itemStack) {
        var dataShard = itemStack.get(DataShard.COMPONENT);

        if (lastShardType != ShardType.ULTRA_BEAST) {
            return null;
        }
        if (lastObject == null) {
            return ShardType.ULTRA_BEAST;
        }

        if (lastObject.equals(dataShard.elementalType())) {
            return dataShard.elementalType();
        }

        return true;
    }

    public static Object TryMatchParadox(String lastShardType, Object lastObject, ItemStack itemStack) {
        var dataShard = itemStack.get(DataShard.COMPONENT);

        if (lastShardType != ShardType.PARADOX) {
            return null;
        }
        if (lastObject == null) {
            return ShardType.PARADOX;
        }

        if (lastObject.equals(dataShard.elementalType())) {
            return dataShard.elementalType();
        }

        return true;
    }

    public static DataShard analyzeShard(CraftingInput recipeInput) {

        // Check all other positions (1,2,3,4,6,7,8,9) for cobblemon_iv_candy
        // Positions correspond to indices: 0,1,2,3,5,6,7,8 (skipping index 4 which is
        // center)
        int[] candyPositions = { 0, 1, 2 };

        Object lastObjectId = null;
        DataShard lastDataShard = null;
        for (int index : candyPositions) {
            ItemStack item = recipeInput.getItem(index);
            Boot.LOGGER.info("Position {} item: {}", index, item.getItem().toString());

            // Check if item is empty first
            if (item.isEmpty()) {
                Boot.LOGGER.info("Position {} is empty, returning false", index);
                return null;
            }

            // Check if it's the IV candy from this mod
            if (!item.is(ModItems.SHARD)) {
                Boot.LOGGER.info("Position {} is not candy_species_random, returning false", index);
                return null;
            }

            var dataShard = item.get(DataShard.COMPONENT);
            if (lastDataShard == null) {
                lastDataShard = dataShard;
            }

            if (dataShard.shardType() == ShardType.SPECIES) {
                lastObjectId = TryMatchSpecies(dataShard.shardType(), lastObjectId, item);
                if (lastObjectId == null) {
                    Boot.LOGGER.info("Position {} has different species, returning false", index);
                    return null;
                }
            }
            if (dataShard.shardType() == ShardType.LEGENDARY) {
                lastObjectId = TryMatchLegendary(dataShard.shardType(), lastObjectId, item);
                if (lastObjectId == null) {
                    Boot.LOGGER.info("Position {} has different species, returning false", index);
                    return null;
                }
            }
            if (dataShard.shardType() == ShardType.ELEMENTAL_TYPE) {
                lastObjectId = TryMatchElemental(dataShard.shardType(), lastObjectId, item);
                if (lastObjectId == null) {
                    Boot.LOGGER.info("Position {} has different elemental type, returning false", index);
                    return null;
                }
            }
            if (dataShard.shardType() == ShardType.MYTHICAL) {
                lastObjectId = TryMatchMythical(dataShard.shardType(), lastObjectId, item);
                if (lastObjectId == null) {
                    Boot.LOGGER.info("Position {} has different mythical type, returning false", index);
                    return null;
                }
            }
            if (dataShard.shardType() == ShardType.ULTRA_BEAST) {
                lastObjectId = TryMatchUltrabeast(dataShard.shardType(), lastObjectId, item);
                if (lastObjectId == null) {
                    Boot.LOGGER.info("Position {} has different ultra beast type, returning false", index);
                    return null;
                }
            }
            if (dataShard.shardType() == ShardType.PARADOX) {
                lastObjectId = TryMatchParadox(dataShard.shardType(), lastObjectId, item);
                if (lastObjectId == null) {
                    Boot.LOGGER.info("Position {} has different paradox type, returning false", index);
                    return null;
                }
            }
        }

        return lastDataShard;
    }
}
