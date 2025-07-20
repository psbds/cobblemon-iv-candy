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
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorType;
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
        
        return switch (shardData.shardType()) {
            case ShardType.SPECIES -> CandyFactory.createForSpecies(CobblemonSpeciesHelper.getSpeciesByPokedexNumber(shardData.baseSpeciesPokedexNumber()), targetIVStat);
            case ShardType.ELEMENTAL_TYPE -> CandyFactory.createForElement(ElementalTypeMap.getElementalType(shardData.elementalType()), targetIVStat);
            case ShardType.LEGENDARY -> CandyFactory.createLegendaryCandy(targetIVStat);
            case ShardType.MYTHICAL -> CandyFactory.createMythicalCandy(targetIVStat);
            case ShardType.ULTRA_BEAST -> CandyFactory.createUltraBeastCandy(targetIVStat);
            case ShardType.PARADOX -> CandyFactory.createParadoxCandy(targetIVStat);
            default -> itemStack;
        };
    }

    public static ItemStack createByExtractor(ItemStack ivExtractor, Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        var ivExtractorData = ivExtractor.get(DataIVExtractor.COMPONENT);
        
        return switch (ivExtractorData.ivExtractorType()) {
            case IVExtractorType.ELEMENTAL_TYPE -> CandyFactory.createForElement(ElementalTypeMap.getElementalType(ivExtractorData.elementalType()), targetIVStat);
            case IVExtractorType.LEGENDARY -> CandyFactory.createLegendaryCandy(targetIVStat);
            case IVExtractorType.MYTHICAL -> CandyFactory.createMythicalCandy(targetIVStat);
            case IVExtractorType.ULTRA_BEAST -> CandyFactory.createUltraBeastCandy(targetIVStat);
            case IVExtractorType.PARADOX -> CandyFactory.createParadoxCandy(targetIVStat);
            default -> itemStack;
        };
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
            InteractionHand hand) {
        return CandyInteractLivingEntity.interactLivingEntity(stack, player, entity, hand);
    }
}
