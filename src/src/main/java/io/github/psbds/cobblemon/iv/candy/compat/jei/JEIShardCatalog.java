package io.github.psbds.cobblemon.iv.candy.compat.jei;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.mappers.CustomModelDataMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class JEIShardCatalog {

    public static List<ItemStack> getAllShards() {
        List<ItemStack> shards = new ArrayList<>();

        // Add legendary shard
        shards.add(legendaryShardItemStack());
        // Add mythical shard
        shards.add(mythicalShardItemStack());
        // Add ultra beast shard
        shards.add(ultraBeastShardItemStack());
        // Add paradox shard
        shards.add(paradoxShardItemStack());

        // Add species shards
        shards.add(speciesShardItemStack());

        for (var elementalType : ElementalTypes.INSTANCE.all()) {
            shards.add(elementalShardItemStack(elementalType));
        }

        return shards;
    }

    public static ItemStack speciesShardItemStack() {
        var speciesShard = new ItemStack(ModItems.SHARD);
        speciesShard.set(DataComponents.CUSTOM_NAME, Component.literal("<Species> IV Shard"));
        speciesShard.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getElementalTypeCustomModelData(ElementalTypes.INSTANCE.getNORMAL())));

        return speciesShard;
    }

    public static ItemStack elementalShardItemStack(ElementalType type) {
        var speciesShard = new ItemStack(ModItems.SHARD);
        speciesShard.set(DataComponents.CUSTOM_NAME,
                Component.literal(String.format("%s IV Shard", type.getName())));
        speciesShard.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getElementalTypeCustomModelData(type)));

        return speciesShard;
    }

    public static ItemStack legendaryShardItemStack() {
        var legendaryShard = new ItemStack(ModItems.SHARD);
        legendaryShard.set(DataComponents.CUSTOM_NAME, Component.literal("Legendary IV Shard"));
        legendaryShard.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForLegendary())); // Example model data

        return legendaryShard;
    }

    public static ItemStack mythicalShardItemStack() {
        var mythicalShard = new ItemStack(ModItems.SHARD);
        mythicalShard.set(DataComponents.CUSTOM_NAME, Component.literal("Mythical IV Shard"));
        mythicalShard.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForMythical())); // Example model data

        return mythicalShard;
    }

    public static ItemStack ultraBeastShardItemStack() {
        var ultraBeastShard = new ItemStack(ModItems.SHARD);
        ultraBeastShard.set(DataComponents.CUSTOM_NAME, Component.literal("Ultra Beast IV Shard"));
        ultraBeastShard.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForUltraBeast())); // Example model data

        return ultraBeastShard;
    }

    public static ItemStack paradoxShardItemStack() {
        var paradoxShard = new ItemStack(ModItems.SHARD);
        paradoxShard.set(DataComponents.CUSTOM_NAME, Component.literal("Paradox IV Shard"));
        paradoxShard.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForParadox())); // Example model data

        return paradoxShard;
    }
}