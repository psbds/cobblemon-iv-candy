package io.github.psbds.cobblemon.iv.candy.items.objects.shards;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.items.objects.BaseShard;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Shard extends BaseShard {

    public static final String NAME = "shard";

    public Shard(Properties properties) {
        super(properties);
    }

    public static ItemStack createForSpecies(Species pokemonSpecies) {
        Boot.LOGGER.info("Labels: " + pokemonSpecies.getLabels());
        var shardType = ShardType.getShardType(pokemonSpecies);
        if (shardType.equals(ShardType.SPECIES)) {
            return ShardFactory.createForSpecies(pokemonSpecies);
        } else if (shardType.equals(ShardType.LEGENDARY)) {
            return ShardFactory.createLegendaryShard();
        } else if (shardType.equals(ShardType.MYTHICAL)) {
            return ShardFactory.createMythicalShard();
        } else if (shardType.equals(ShardType.ULTRA_BEAST)) {
            return ShardFactory.createUltraBeastShard();
        } else if (shardType.equals(ShardType.PARADOX)) {
            return ShardFactory.createParadoxShard();
        }

        return ItemStack.EMPTY;
    }

    public static ItemStack createForElement(ElementalType elementalType) {
        return ShardFactory.createForElement(elementalType);
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
