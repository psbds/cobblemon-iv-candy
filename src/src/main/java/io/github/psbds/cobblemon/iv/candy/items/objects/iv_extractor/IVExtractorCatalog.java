package io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.types.ElementalTypes;

import net.minecraft.world.item.ItemStack;

public class IVExtractorCatalog {

    public static List<ItemStack> getCatalogExtractors() {
        List<ItemStack> extractors = new ArrayList<>();

        for (var elementalType : ElementalTypes.INSTANCE.all()) {
            extractors.add(IVExtractorFactory.createElement(elementalType));
        }

        extractors.add(IVExtractorFactory.createLegendary());
        extractors.add(IVExtractorFactory.createMythical());
        extractors.add(IVExtractorFactory.createUltrabeast());
        extractors.add(IVExtractorFactory.createParadox());

        return extractors;
    }
}
