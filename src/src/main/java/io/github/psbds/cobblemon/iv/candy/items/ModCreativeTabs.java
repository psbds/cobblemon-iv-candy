package io.github.psbds.cobblemon.iv.candy.items;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyCatalog;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorCatalog;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardCatalog;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeTabs {

    public static CreativeModeTab COBBLEMON_IV_CANDY_TAB;

    public static void registerCreativeTabs() {
        Boot.LOGGER.info("Registering Creative Mode Tabs for " + Boot.MOD_ID);

        // Create and register the creative tab
        COBBLEMON_IV_CANDY_TAB = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup.cobblemon_iv_candy"))
                .icon(() -> CandyFactory.createForSpeciesSample(null))
                .displayItems((context, entries) -> {
                    for (var shard : ShardCatalog.getCatalogShards()) {
                        entries.accept(shard);
                    }

                    for (var candy : CandyCatalog.getCatalogCandys()) {
                        entries.accept(candy);
                    }

                    for (var extractor : IVExtractorCatalog.getCatalogExtractors()) {
                        entries.accept(extractor);
                    }
                })
                .build();

        net.minecraft.core.Registry.register(
                net.minecraft.core.registries.BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, "cobblemon_iv_candy"),
                COBBLEMON_IV_CANDY_TAB);

        Boot.LOGGER.info("Successfully registered Creative Mode Tabs");
    }
}
