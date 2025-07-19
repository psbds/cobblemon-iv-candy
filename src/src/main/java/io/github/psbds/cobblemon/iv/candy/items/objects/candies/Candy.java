package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.constants.ShardType;
import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.components.DataCandy;
import io.github.psbds.cobblemon.iv.candy.items.mappers.CustomModelDataMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.BaseCandy;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.Shard;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class Candy extends BaseCandy {

    public static final String NAME = "candy";

    public Candy(Properties properties) {
        super(properties);
    }

    public static ItemStack create(ItemStack baseShard, String targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        initialize(itemStack, baseShard, targetIVStat);
        return itemStack;
    }

    public static void initialize(
            ItemStack itemStack,
            ItemStack baseShard,
            String targetIVStat) {
        var shardData = baseShard.get(DataShard.COMPONENT);

        // Initialize Model Data
        var candyName = "IV Candy";
        var candyDataType = shardData.shardType();
        int candyDataPokedexNumber = shardData.baseSpeciesPokedexNumber();
        int candyDataElementalType = shardData.elementalType();
        var candyModelNumber = baseShard.get(DataComponents.CUSTOM_MODEL_DATA).value();
        var candyTargetIVStat = targetIVStat;

        // Type = Species
        if (candyDataType.equals(ShardType.SPECIES)) {
            var species = CobblemonSpeciesHelper.getSpeciesByPokedexNumber(candyDataPokedexNumber);
            candyName = String.format("%s %s", species.getName(), candyName);
        }
        // Type = Elemental Type
        if (candyDataType.equals(ShardType.ELEMENTAL_TYPE)) {
            var elementalType = ElementalTypeMap.getElementalTypeId(candyDataElementalType);
            candyName = String.format("%s %s", elementalType, candyName);
        }

        // Type = Legendary, Mythical, Ultra Beast, Paradox
        if (candyDataType.equals(ShardType.LEGENDARY)) {
            candyName = String.format("Legendary %s ", candyName);
        } else if (candyDataType.equals(ShardType.MYTHICAL)) {
            candyName = String.format("Mythical %s", candyName);
        } else if (candyDataType.equals(ShardType.ULTRA_BEAST)) {
            candyName = String.format("Ultra Beast %s", candyName);
        } else if (candyDataType.equals(ShardType.PARADOX)) {
            candyName = String.format("Paradox %s", candyName);
        }

        // TargetIV
        if (targetIVStat != null && !targetIVStat.equals("RANDOM")) {
            candyName = String.format("%s [%s]", candyName, targetIVStat);
        } else {
            candyName = String.format("%s [Random IV]", candyName);
        }

        /// Set Data Components
        itemStack.set(DataCandy.COMPONENT, DataCandy.of(candyDataType, candyDataPokedexNumber, candyDataElementalType, candyTargetIVStat));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(candyModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(candyName));
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
