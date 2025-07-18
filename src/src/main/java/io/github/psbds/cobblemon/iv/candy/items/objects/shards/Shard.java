package io.github.psbds.cobblemon.iv.candy.items.objects.shards;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.constants.ShardType;
import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.mappers.CustomModelDataMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.BaseShard;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class Shard extends BaseShard {

    public static final String NAME = "shard";

    public Shard(Properties properties) {
        super(properties);
    }

    public static ItemStack createForSpecies(Species pokemonSpecies) {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);
        Boot.LOGGER.info("Labels: " + pokemonSpecies.getLabels());
        var shardType = ShardType.getShardType(pokemonSpecies);
        if (shardType == ShardType.SPECIES) {
            initialize(itemStack, ShardType.SPECIES, pokemonSpecies, null);
        } else {
            initialize(itemStack, shardType, null, null);
        }
        return itemStack;
    }

    public static ItemStack createForElement(ElementalType elementalType) {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);
        initialize(itemStack, ShardType.ELEMENTAL_TYPE, null, elementalType);
        return itemStack;
    }

    public static void initialize(ItemStack itemStack,
            String shardType,
            Species pokemonSpecies,
            ElementalType elementalTypeOverride) {

        // Initialize Model Data
        var shardName = "IV Shard";
        var shardDataType = shardType;
        int shardDataPokedexNumber = 0;
        int shardDataElementalType = -1;
        int shardModelNumber = 0;

        if (shardType.equals(ShardType.SPECIES)) {
            var baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(pokemonSpecies);
            shardName = String.format("%s %s", baseSpecies.getName(), shardName);
            shardDataPokedexNumber = baseSpecies.getNationalPokedexNumber();
            shardModelNumber = CustomModelDataMap.getElementalTypeCustoModelData(ElementalTypeMap.getElementalTypeId(baseSpecies.getPrimaryType()));
        }

        if (shardType.equals(ShardType.ELEMENTAL_TYPE)) {
            shardDataElementalType = ElementalTypeMap.getElementalTypeId(elementalTypeOverride);
            shardName = String.format("%s [%s]", shardName, elementalTypeOverride.getName());
            shardModelNumber = CustomModelDataMap.getElementalTypeCustoModelData(ElementalTypeMap.getElementalTypeId(elementalTypeOverride));
        }

        if (shardType.equals(ShardType.LEGENDARY)) {
            shardName = String.format("%s Legendary", shardName, shardType);
            shardModelNumber = CustomModelDataMap.getCustomModelForLegendary();
        } else if (shardType.equals(ShardType.MYTHICAL)) {
            shardName = String.format("%s Mythical", shardName, shardType);
            shardModelNumber = CustomModelDataMap.getCustomModelForMythical();
        } else if (shardType.equals(ShardType.ULTRA_BEAST)) {
            shardName = String.format("%s Ultra Beast", shardName, shardType);
            shardModelNumber = CustomModelDataMap.getCustomModelForUltraBeast();
        } else if (shardType.equals(ShardType.PARADOX)) {
            shardName = String.format("%s Paradox", shardName, shardType);
            shardModelNumber = CustomModelDataMap.getCustomModelForParadox();
        }
        // Set Custom Model Data
        itemStack.set(DataShard.COMPONENT, DataShard.of(shardDataType, shardDataPokedexNumber, shardDataElementalType));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
            InteractionHand hand) {
        Print(stack, player);
        return InteractionResult.SUCCESS;
    }

    public static void Print(ItemStack stack, Player player) {
        for (var comp : stack.getComponents()) {
            player.sendSystemMessage(Component.literal(String.format("%s = %s", comp.type(), comp.value())));
        }
    }
}
