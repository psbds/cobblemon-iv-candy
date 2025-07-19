package io.github.psbds.cobblemon.iv.candy.compat.jei.items.super_candy;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyFactory;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardFactory;
import net.minecraft.world.item.ItemStack;

/**
 * A wrapper recipe class specifically for JEI display purposes.
 * This allows us to show different variants of the super candy recipe
 * with different shard types in a 3x3 grid plus a middle item.
 */
public record JEISuperCandyRecipe(
		ItemStack inputShard, // The shard that fills the 3x3 grid (9 total)
		ItemStack middleItem, // The special item in the center
		ItemStack outputCandy) { // The resulting super candy

	public static List<JEISuperCandyRecipe> getRecipes() {
		var list = new ArrayList<JEISuperCandyRecipe>();

		list.addAll(getRecipes(new ItemStack(CobblemonItems.RED_APRICORN), Stats.HP));
		list.addAll(getRecipes(new ItemStack(CobblemonItems.BLACK_APRICORN), Stats.SPECIAL_ATTACK));
		list.addAll(getRecipes(new ItemStack(CobblemonItems.YELLOW_APRICORN), Stats.ATTACK));
		list.addAll(getRecipes(new ItemStack(CobblemonItems.GREEN_APRICORN), Stats.DEFENCE));
		list.addAll(getRecipes(new ItemStack(CobblemonItems.BLUE_APRICORN), Stats.SPECIAL_DEFENCE));
		list.addAll(getRecipes(new ItemStack(CobblemonItems.WHITE_APRICORN), Stats.SPEED));

		return list;
	}

	public static List<JEISuperCandyRecipe> getRecipes(ItemStack apricornItem, Stats targetIVStat) {
		var list = new ArrayList<JEISuperCandyRecipe>();
		// Add legendary shard
		list.add(new JEISuperCandyRecipe(ShardFactory.createLegendaryShard(),
				apricornItem,
				CandyFactory.createLegendaryCandy(targetIVStat)));
		// Add mythical shard
		list.add(new JEISuperCandyRecipe(ShardFactory.createMythicalShard(),
				apricornItem,
				CandyFactory.createMythicalCandy(targetIVStat)));
		// Add ultra beast shard
		list.add(new JEISuperCandyRecipe(ShardFactory.createUltraBeastShard(),
				apricornItem,
				CandyFactory.createUltraBeastCandy(targetIVStat)));
		// Add paradox shard
		list.add(new JEISuperCandyRecipe(ShardFactory.createParadoxShard(),
				apricornItem,
				CandyFactory.createParadoxCandy(targetIVStat)));

		// Add species shards
		list.add(new JEISuperCandyRecipe(
				ShardFactory.createForSpeciesSample(),
				apricornItem,
				CandyFactory.createForSpeciesSample(targetIVStat)));

		for (var elementalType : ElementalTypes.INSTANCE.all()) {
			list.add(new JEISuperCandyRecipe(
					ShardFactory.createForElement(elementalType),
					apricornItem,
					CandyFactory.createForElement(elementalType, targetIVStat)));
		}

		return list;
	}
}
