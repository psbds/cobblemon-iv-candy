package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataPokedexNumber;
import io.github.psbds.cobblemon.iv.candy.items.components.DataIVStat;
import io.github.psbds.cobblemon.iv.candy.items.components.DataElementalType;
import io.github.psbds.cobblemon.iv.candy.items.mappers.CustomModelDataMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.BaseCandy;
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

    public static ItemStack create(Species pokemonSpecies, String targetIVStat, ElementalType elementalType) {

        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        initialize(itemStack, pokemonSpecies, targetIVStat, elementalType);
        return itemStack;
    }

    public static void initialize(
            ItemStack itemStack,
            Species pokemonSpecies,
            String targetIVStat,
            ElementalType elementalType) {

        var itemName = "IV Candy";
        // Set Species Info
        if (pokemonSpecies != null) {
            var baseSpecies = CobblemonSpeciesHelper.getFirstEvolution(pokemonSpecies);
            var candyBaseSpecies = DataPokedexNumber.of(baseSpecies.getNationalPokedexNumber());
            itemStack.set(DataPokedexNumber.COMPONENT, candyBaseSpecies);
            itemName = String.format("%s [%s]", itemName, baseSpecies.getName());
            itemStack.set(DataComponents.CUSTOM_MODEL_DATA,
                    new CustomModelData(CustomModelDataMap.getElementalTypeCustoModelData(
                            ElementalTypeMap.getElementalTypeId(baseSpecies.getPrimaryType()))));
        }

        // Set Elemental Info
        if (elementalType != null) {
            var candyElementalType = DataElementalType.of(ElementalTypeMap.getElementalTypeId(elementalType));
            itemStack.set(DataElementalType.COMPONENT, candyElementalType);
            itemName = String.format("%s [%s]", itemName, elementalType.getName());
            itemStack.set(DataComponents.CUSTOM_MODEL_DATA,
                    new CustomModelData(CustomModelDataMap.getElementalTypeCustoModelData(
                            ElementalTypeMap.getElementalTypeId(elementalType))));
        }

        // Set Target IV Stat
        if (targetIVStat != null) {
            var candyIVType = DataIVStat.of(targetIVStat);
            itemStack.set(DataIVStat.COMPONENT, candyIVType);
            itemName = String.format("%s (%s)", itemName, targetIVStat);
        }
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(itemName));

    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
            InteractionHand hand) {
        Print(stack, player);
        return InteractionResult.SUCCESS;
    }

    public static void Print(ItemStack stack, Player player) {
        var baseSpecies = stack.get(DataPokedexNumber.COMPONENT);
        var targetIvStat = stack.get(DataIVStat.COMPONENT);
        if (baseSpecies != null) {
            player.sendSystemMessage(
                    Component.literal("This IV Candy is for " + baseSpecies.baseSpeciesPokedexNumber() + "!"));
        } else {
            player.sendSystemMessage(Component.literal("This IV Candy has no species data!"));
        }
        if (targetIvStat != null) {
            player.sendSystemMessage(Component.literal("This IV Candy is for " + targetIvStat.targetStat() + "!"));
        } else {
            player.sendSystemMessage(Component.literal("This IV Candy has no IV type data!"));
        }
    }
}
