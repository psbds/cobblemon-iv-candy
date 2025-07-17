package io.github.psbds.cobblemon.iv.candy.items.objects.shards;

import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataPokedexNumber;
import io.github.psbds.cobblemon.iv.candy.items.components.DataElementalType;
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

    public static ItemStack create(Species pokemonSpecies) {
        ItemStack itemStack = new ItemStack(ModItems.SHARD);
        initialize(itemStack, pokemonSpecies);
        return itemStack;
    }

    public static void initialize(ItemStack itemStack, Species pokemonSpecies) {
        // Set Species
        var baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(pokemonSpecies);
        var candyBaseSpecies = DataPokedexNumber.of(baseSpecies.getNationalPokedexNumber());
        itemStack.set(DataPokedexNumber.COMPONENT, candyBaseSpecies);

        // Set Primary Elemental Type
        var elementalType = DataElementalType.of(ElementalTypeMap.getElementalTypeId(baseSpecies.getPrimaryType()));
        itemStack.set(DataElementalType.COMPONENT, elementalType);

        // Set DisplayName
        var itemName = String.format("%s IV Shard", baseSpecies.getName());
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(itemName));

        // Set Custom Model Data
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(CustomModelDataMap
                .getElementalTypeCustoModelData(ElementalTypeMap.getElementalTypeId(baseSpecies.getPrimaryType()))));
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
