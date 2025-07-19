package io.github.psbds.cobblemon.iv.candy.items.objects.shards;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.types.ElementalTypes;

import net.minecraft.world.item.ItemStack;

public class ShardCatalog {
    public static List<ItemStack> getCatalogShards() {
        List<ItemStack> shards = new ArrayList<>();

        shards.add(ShardFactory.createForSpeciesSample());

        for (var elementalType : ElementalTypes.INSTANCE.all()) {
            shards.add(ShardFactory.createForElement(elementalType));
        }

        shards.add(ShardFactory.createLegendaryShard());
        shards.add(ShardFactory.createMythicalShard());
        shards.add(ShardFactory.createUltraBeastShard());
        shards.add(ShardFactory.createParadoxShard());

        return shards;
    }
}
