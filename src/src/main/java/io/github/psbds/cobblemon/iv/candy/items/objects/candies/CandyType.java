package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardType;
import net.minecraft.world.item.ItemStack;

public class CandyType {
    public static final String SPECIES = "species";
    public static final String ELEMENTAL_TYPE = "elemental_type";
    public static final String LEGENDARY = "legendary";
    public static final String MYTHICAL = "mythical";
    public static final String ULTRA_BEAST = "ultra_beast";
    public static final String PARADOX = "paradox";

    public static String getCandyType(ItemStack shard) {
        var shardData = shard.get(DataShard.COMPONENT);
        var shardType = shardData.shardType();
        if (shardType.equals(ShardType.SPECIES)) {
            return SPECIES;
        } else if (shardType.equals(ShardType.ELEMENTAL_TYPE)) {
            return ELEMENTAL_TYPE;
        } else if (shardType.equals(ShardType.LEGENDARY)) {
            return LEGENDARY;
        } else if (shardType.equals(ShardType.MYTHICAL)) {
            return MYTHICAL;
        } else if (shardType.equals(ShardType.ULTRA_BEAST)) {
            return ULTRA_BEAST;
        } else if (shardType.equals(ShardType.PARADOX)) {
            return PARADOX;
        }
        return SPECIES;
    }
}
