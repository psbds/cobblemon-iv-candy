package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.components.DataCandy;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.BaseCandy;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardType;
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

    public static ItemStack create(ItemStack baseShard, Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        var shardData = baseShard.get(DataShard.COMPONENT);
        if (shardData.shardType() == ShardType.SPECIES) {
            var species = CobblemonSpeciesHelper.getSpeciesByPokedexNumber(shardData.baseSpeciesPokedexNumber());
            return CandyFactory.createForSpecies(species, targetIVStat);
        } else if (shardData.shardType() == ShardType.ELEMENTAL_TYPE) {
            var elementalType = ElementalTypeMap.getElementalType(shardData.elementalType());
            return CandyFactory.createForElement(elementalType, targetIVStat);
        } else if (shardData.shardType() == ShardType.LEGENDARY) {
            return CandyFactory.createLegendaryCandy(targetIVStat);
        } else if (shardData.shardType() == ShardType.MYTHICAL) {
            return CandyFactory.createMythicalCandy(targetIVStat);
        } else if (shardData.shardType() == ShardType.ULTRA_BEAST) {
            return CandyFactory.createUltraBeastCandy(targetIVStat);
        } else if (shardData.shardType() == ShardType.PARADOX) {
            return CandyFactory.createParadoxCandy(targetIVStat);
        }

        return itemStack;
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
