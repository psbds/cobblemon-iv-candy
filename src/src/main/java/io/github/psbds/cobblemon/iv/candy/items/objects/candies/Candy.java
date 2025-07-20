package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.BaseCandy;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.actions.CandyInteractLivingEntity;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.DataIVExtractor;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Candy extends BaseCandy {

    public static final Logger LOGGER = LoggerFactory.getLogger(Candy.class);
    public static final String NAME = "candy";
    public static final String IDENTIFIER_RANDOM_IV = "Random IV";

    public Candy(Properties properties) {
        super(properties);
    }

    public static ItemStack create(ItemStack baseShard, Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        var shardData = baseShard.get(DataShard.COMPONENT);
        if (shardData.shardType().equals(ShardType.SPECIES)) {
            var species = CobblemonSpeciesHelper.getSpeciesByPokedexNumber(shardData.baseSpeciesPokedexNumber());
            return CandyFactory.createForSpecies(species, targetIVStat);
        } else if (shardData.shardType().equals(ShardType.ELEMENTAL_TYPE)) {
            var elementalType = ElementalTypeMap.getElementalType(shardData.elementalType());
            return CandyFactory.createForElement(elementalType, targetIVStat);
        } else if (shardData.shardType().equals(ShardType.LEGENDARY)) {
            return CandyFactory.createLegendaryCandy(targetIVStat);
        } else if (shardData.shardType().equals(ShardType.MYTHICAL)) {
            return CandyFactory.createMythicalCandy(targetIVStat);
        } else if (shardData.shardType().equals(ShardType.ULTRA_BEAST)) {
            return CandyFactory.createUltraBeastCandy(targetIVStat);
        } else if (shardData.shardType().equals(ShardType.PARADOX)) {
            return CandyFactory.createParadoxCandy(targetIVStat);
        }

        return itemStack;
    }

    public static ItemStack createByExtractor(ItemStack ivExtractor, Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        var shardData = ivExtractor.get(DataIVExtractor.COMPONENT);
        if (shardData.ivExtractorType().equals(ShardType.ELEMENTAL_TYPE)) {
            var elementalType = ElementalTypeMap.getElementalType(shardData.elementalType());
            return CandyFactory.createForElement(elementalType, targetIVStat);
        } else if (shardData.ivExtractorType().equals(ShardType.LEGENDARY)) {
            return CandyFactory.createLegendaryCandy(targetIVStat);
        } else if (shardData.ivExtractorType().equals(ShardType.MYTHICAL)) {
            return CandyFactory.createMythicalCandy(targetIVStat);
        } else if (shardData.ivExtractorType().equals(ShardType.ULTRA_BEAST)) {
            return CandyFactory.createUltraBeastCandy(targetIVStat);
        } else if (shardData.ivExtractorType().equals(ShardType.PARADOX)) {
            return CandyFactory.createParadoxCandy(targetIVStat);
        }

        return itemStack;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
            InteractionHand hand) {
        Print(stack, player);
        return CandyInteractLivingEntity.interactLivingEntity(stack, player, entity, hand);

    }

    public static void Print(ItemStack stack, Player player) {
        for (var comp : stack.getComponents()) {
            LOGGER.info(String.format("%s = %s", comp.type(), comp.value()));
        }
    }
}
