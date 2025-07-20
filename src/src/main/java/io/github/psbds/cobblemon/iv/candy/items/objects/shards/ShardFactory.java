package io.github.psbds.cobblemon.iv.candy.items.objects.shards;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;
import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.model.CustomModelDataMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class ShardFactory {
    private static final String BASE_SHARD_NAME = "IV Shard";

    public static Shard createDefault() {
        var props = new Item.Properties();

        var elementalType = ElementalTypes.INSTANCE.getNORMAL();
        var shardDataElementalType = ElementalTypeMap.getElementalTypeId(elementalType);
        var shardName = String.format("%s %s", elementalType.getName(), BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap.getElementalTypeCustomModelData(shardDataElementalType);

        props.component(DataShard.COMPONENT, DataShard.of(ShardType.ELEMENTAL_TYPE, 0, shardDataElementalType));
        props.component(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        props.component(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return new Shard(props);
    }

    /// Create species Sample Shard
    public static ItemStack createForSpeciesSample() {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);

        var shardName = String.format("<Base Species> %s", BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap.getElementalTypeCustomModelData(
                ElementalTypeMap.getElementalTypeId(ElementalTypes.INSTANCE.getNORMAL()));

        itemStack.set(DataShard.COMPONENT, DataShard.of(ShardType.SPECIES, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create a shard for a specific species
    public static ItemStack createForSpecies(Species pokemonSpecies) {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);
        var baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(pokemonSpecies);
        var shardDataPokedexNumber = baseSpecies.getNationalPokedexNumber();

        var shardName = String.format("%s %s", baseSpecies.getName(), BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap
                .getElementalTypeCustomModelData(ElementalTypeMap.getElementalTypeId(baseSpecies.getPrimaryType()));

        itemStack.set(DataShard.COMPONENT, DataShard.of(ShardType.SPECIES, shardDataPokedexNumber, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Legendary shard with specific properties
    public static ItemStack createLegendaryShard() {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);

        var shardName = String.format("Legendary %s", BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap.getCustomModelForLegendary();

        itemStack.set(DataShard.COMPONENT, DataShard.of(ShardType.LEGENDARY, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Mythical shard with specific properties
    public static ItemStack createMythicalShard() {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);

        var shardName = String.format("Mythical %s", BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap.getCustomModelForMythical();

        itemStack.set(DataShard.COMPONENT, DataShard.of(ShardType.MYTHICAL, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Ultra Beast shard with specific properties
    public static ItemStack createUltraBeastShard() {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);

        var shardName = String.format("Ultra Beast %s", BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap.getCustomModelForUltraBeast();

        itemStack.set(DataShard.COMPONENT, DataShard.of(ShardType.ULTRA_BEAST, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Paradox shard with specific properties
    public static ItemStack createParadoxShard() {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);

        var shardName = String.format("Paradox %s", BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap.getCustomModelForParadox();

        itemStack.set(DataShard.COMPONENT, DataShard.of(ShardType.PARADOX, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create a shard for a specific elemental type
    public static ItemStack createForElement(ElementalType elementalType) {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);
        var shardDataElementalType = ElementalTypeMap.getElementalTypeId(elementalType);
        var shardName = String.format("%s %s", elementalType.getName(), BASE_SHARD_NAME);
        var shardModelNumber = CustomModelDataMap.getElementalTypeCustomModelData(shardDataElementalType);

        itemStack.set(DataShard.COMPONENT, DataShard.of(ShardType.ELEMENTAL_TYPE, 0, shardDataElementalType));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }
}
