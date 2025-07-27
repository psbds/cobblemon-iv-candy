package io.github.psbds.cobblemon.iv.candy.items;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractor;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.Shard;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {

    public static Item CANDY;
    public static Item SHARD;
    public static Item IV_EXTRACTOR;

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, name),
                item);
    }

    public static void initialize() {
        Boot.LOGGER.info("Registering items for " + Boot.MOD_ID);
        
        // Register items using the factories
        CANDY = registerItem(Candy.NAME, CandyFactory.createDefault());
        SHARD = registerItem(Shard.NAME, ShardFactory.createDefault());
        IV_EXTRACTOR = registerItem(IVExtractor.NAME, IVExtractorFactory.createDefault());
        
        Boot.LOGGER.info("Successfully registered items for " + Boot.MOD_ID);
    }
}