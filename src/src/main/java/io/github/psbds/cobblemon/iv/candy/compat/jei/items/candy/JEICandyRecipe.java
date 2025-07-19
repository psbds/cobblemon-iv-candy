package io.github.psbds.cobblemon.iv.candy.compat.jei.items.candy;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyCatalog;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import net.minecraft.world.item.ItemStack;

/**
 * A wrapper recipe class specifically for JEI display purposes.
 * This allows us to show different variants of the candy recipe
 * with different shard types.
 */
public record JEICandyRecipe(
        ItemStack inputShard,
        ItemStack outputCandy) {
    public static List<JEICandyRecipe> getRecipes() {
        var list = new ArrayList<JEICandyRecipe>();
        // Add legendary shard
        list.add(new JEICandyRecipe(ShardFactory.createLegendaryShard(),
                CandyFactory.createLegendaryCandy(null))); // Random IV
        // Add mythical shard
        list.add(new JEICandyRecipe(ShardFactory.createMythicalShard(),
                CandyFactory.createMythicalCandy(null))); // Random IV
        // Add ultra beast shard
        list.add(new JEICandyRecipe(ShardFactory.createUltraBeastShard(),
                CandyFactory.createUltraBeastCandy(null))); // Random IV
        // Add paradox shard
        list.add(new JEICandyRecipe(ShardFactory.createParadoxShard(),
                CandyFactory.createParadoxCandy(null))); // Random IV

        // Add species shards
        list.add(new JEICandyRecipe(
                ShardFactory.createForSpeciesSample(),
                CandyFactory.createForSpeciesSample(null))); // Random IV

        for (var elementalType : ElementalTypes.INSTANCE.all()) {
            list.add(new JEICandyRecipe(
                    ShardFactory.createForElement(elementalType),
                    CandyFactory.createForElement(elementalType, null))); // Random IV
        }

        return list;
    }
}
