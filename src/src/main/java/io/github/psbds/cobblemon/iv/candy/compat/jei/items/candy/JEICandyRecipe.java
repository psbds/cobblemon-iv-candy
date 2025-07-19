package io.github.psbds.cobblemon.iv.candy.compat.jei.items.candy;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.compat.jei.JEICandyCatalog;
import io.github.psbds.cobblemon.iv.candy.compat.jei.JEIShardCatalog;
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
        list.add(new JEICandyRecipe(JEIShardCatalog.legendaryShardItemStack(),
                JEICandyCatalog.legendaryCandyItemStack(null))); // Random IV
        // Add mythical shard
        list.add(
                new JEICandyRecipe(JEIShardCatalog.mythicalShardItemStack(), JEICandyCatalog.mythicalCandyItemStack(null))); // Random IV
        // Add ultra beast shard
        list.add(new JEICandyRecipe(JEIShardCatalog.ultraBeastShardItemStack(),
                JEICandyCatalog.ultraBeastCandyItemStack(null))); // Random IV
        // Add paradox shard
        list.add(new JEICandyRecipe(JEIShardCatalog.paradoxShardItemStack(), JEICandyCatalog.paradoxCandyItemStack(null))); // Random IV

        // Add species shards
        list.add(new JEICandyRecipe(
                JEIShardCatalog.speciesShardItemStack(),
                JEICandyCatalog.speciesCandyItemStack(null))); // Random IV

        for (var elementalType : ElementalTypes.INSTANCE.all()) {

            list.add(new JEICandyRecipe(
                    JEIShardCatalog.elementalShardItemStack(elementalType),
                    JEICandyCatalog.elementalCandyItemStack(elementalType, null))); // Random IV
        }

        return list;
    }
}
