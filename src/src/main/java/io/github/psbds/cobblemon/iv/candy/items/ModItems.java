package io.github.psbds.cobblemon.iv.candy.items;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.components.DataCandy;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.DataIVExtractor;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractor;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.Shard;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item CANDY = registerItem(Candy.NAME, CandyFactory.createDefault());

    public static final Item SHARD = registerItem(Shard.NAME, ShardFactory.createDefault());

    public static final Item IV_EXTRACTOR = registerItem(IVExtractor.NAME, IVExtractorFactory.createDefault());

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, name),
                item);
    }

    public static void initialize() {
        DataCandy.initialize();
        DataShard.initialize();
        DataIVExtractor.initialize();
    }
}