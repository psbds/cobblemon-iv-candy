package io.github.psbds.cobblemon.iv.candy.items;

import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.components.DataPokedexNumber;
import io.github.psbds.cobblemon.iv.candy.items.components.DataElementalType;
import io.github.psbds.cobblemon.iv.candy.items.components.DataIVStat;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.Shard;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {

	public static final Item CANDY = registerItem(Candy.NAME, new Candy(new Item.Properties()));
	public static final Item SHARD = registerItem(Shard.NAME, new Shard(new Item.Properties()));

	private static Item registerItem(String name, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, name),
				item);
	}

	public static void initialize() {
		DataIVStat.initialize();
		DataPokedexNumber.initialize();
		DataElementalType.initialize();
	}
}