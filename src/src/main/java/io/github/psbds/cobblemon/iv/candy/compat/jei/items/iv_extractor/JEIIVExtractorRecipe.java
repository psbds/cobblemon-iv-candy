package io.github.psbds.cobblemon.iv.candy.compat.jei.items.iv_extractor;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import net.minecraft.world.item.ItemStack;

/**
 * A wrapper recipe class specifically for JEI display purposes.
 * This allows us to show different variants of the candy recipe
 * with different shard types.
 */
public record JEIIVExtractorRecipe(
        ItemStack inputShard,
        ItemStack outputExtractor) {
    public static List<JEIIVExtractorRecipe> getRecipes() {
        var list = new ArrayList<JEIIVExtractorRecipe>();
        // Add legendary shard
        list.add(new JEIIVExtractorRecipe(ShardFactory.createLegendaryShard(),
                IVExtractorFactory.createLegendary()));
        list.add(new JEIIVExtractorRecipe(ShardFactory.createMythicalShard(),
                IVExtractorFactory.createMythical()));
        // Add ultra beast shard
        list.add(new JEIIVExtractorRecipe(ShardFactory.createUltraBeastShard(),
                IVExtractorFactory.createUltrabeast()));
        // Add paradox shard
        list.add(new JEIIVExtractorRecipe(ShardFactory.createParadoxShard(),
                IVExtractorFactory.createParadox()));

        for (var elementalType : ElementalTypes.INSTANCE.all()) {
            list.add(new JEIIVExtractorRecipe(
                    ShardFactory.createForElement(elementalType),
                    IVExtractorFactory.createElement(elementalType)));
        }

        return list;
    }
}
