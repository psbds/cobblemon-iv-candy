package io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.actions.IVExtractorInteractLivingEntity;
import io.github.psbds.cobblemon.iv.candy.items.objects.shards.ShardType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class IVExtractor extends Item {
    public static final Logger LOGGER = LoggerFactory.getLogger(IVExtractor.class);
    public static final String NAME = "iv_extractor";

    public IVExtractor(Properties properties) {
        super(properties);
    }

    public static ItemStack create(ItemStack baseShard) {
        var shardData = baseShard.get(DataShard.COMPONENT);

        return switch (shardData.shardType()) {
            case ShardType.ELEMENTAL_TYPE -> IVExtractorFactory.createElement(ElementalTypeMap.getElementalType(shardData.elementalType()));
            case ShardType.LEGENDARY -> IVExtractorFactory.createLegendary();
            case ShardType.MYTHICAL -> IVExtractorFactory.createMythical();
            case ShardType.ULTRA_BEAST -> IVExtractorFactory.createUltrabeast();
            case ShardType.PARADOX -> IVExtractorFactory.createParadox();
            default -> throw new IllegalArgumentException("Unknown IVExtractorType: " + shardData.shardType());
        };
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
            InteractionHand hand) {
        return IVExtractorInteractLivingEntity.interactLivingEntity(stack, player, entity, hand);
    }
}
