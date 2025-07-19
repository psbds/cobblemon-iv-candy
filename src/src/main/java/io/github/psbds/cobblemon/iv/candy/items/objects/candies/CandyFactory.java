package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;
import com.cobblemon.mod.common.pokemon.Species;

import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.DataCandy;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.IVStatMap;
import io.github.psbds.cobblemon.iv.candy.items.model.CustomModelDataMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class CandyFactory {
    private static final String BASE_CANDY_NAME = "IV Candy";

    /// Create species Sample Candy
    public static ItemStack createForSpeciesSample(Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        var statName = targetIVStat != null ? IVStatMap.getIVStat(targetIVStat) : "Random IV";

        var shardName = String.format("<Base Species> %s [%s]", BASE_CANDY_NAME, statName);
        var shardModelNumber = CandyModel.getElemental(
                ElementalTypeMap.getElementalTypeId(ElementalTypes.INSTANCE.getNORMAL()), targetIVStat);

        itemStack.set(DataCandy.COMPONENT, DataCandy.of(CandyType.SPECIES, 0, -1, statName));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create species candy
    public static ItemStack createForSpecies(Species pokemonSpecies, Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);

        var statName = targetIVStat != null ? IVStatMap.getIVStat(targetIVStat) : "Random IV";

        var shardName = String.format("%s %s [%s]", pokemonSpecies.getName(), BASE_CANDY_NAME, statName);
        var shardModelNumber = CandyModel.getElemental(
                ElementalTypeMap.getElementalTypeId(ElementalTypes.INSTANCE.getNORMAL()), targetIVStat);

        itemStack.set(DataCandy.COMPONENT,
                DataCandy.of(CandyType.SPECIES, pokemonSpecies.getNationalPokedexNumber(), -1, statName));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Legendary candy with specific properties
    public static ItemStack createLegendaryCandy(Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);

        var statName = targetIVStat != null ? IVStatMap.getIVStat(targetIVStat) : "Random IV";
        var shardName = String.format("Legendary %s [%s]", BASE_CANDY_NAME, statName);
        var shardModelNumber = CandyModel.getLegendary(targetIVStat);

        itemStack.set(DataCandy.COMPONENT, DataCandy.of(CandyType.LEGENDARY, 0, -1, statName));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Mythical candy with specific properties
    public static ItemStack createMythicalCandy(Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);

        var statName = targetIVStat != null ? IVStatMap.getIVStat(targetIVStat) : "Random IV";
        var shardName = String.format("Mythical %s [%s]", BASE_CANDY_NAME, statName);
        var shardModelNumber = CandyModel.getMythical(targetIVStat);

        itemStack.set(DataCandy.COMPONENT, DataCandy.of(CandyType.MYTHICAL, 0, -1, statName));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Ultra Beast candy with specific properties
    public static ItemStack createUltraBeastCandy(Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);

        var statName = targetIVStat != null ? IVStatMap.getIVStat(targetIVStat) : "Random IV";
        var shardName = String.format("Ultra Beast %s [%s]", BASE_CANDY_NAME, statName);
        var shardModelNumber = CandyModel.getUltraBeast(targetIVStat);

        itemStack.set(DataCandy.COMPONENT, DataCandy.of(CandyType.ULTRA_BEAST, 0, -1, statName));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create the Paradox candy with specific properties
    public static ItemStack createParadoxCandy(Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);

        var statName = targetIVStat != null ? IVStatMap.getIVStat(targetIVStat) : "Random IV";
        var shardName = String.format("Paradox %s [%s]", BASE_CANDY_NAME, statName);
        var shardModelNumber = CandyModel.getParadox(targetIVStat);

        itemStack.set(DataCandy.COMPONENT, DataCandy.of(CandyType.PARADOX, 0, -1, statName));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }

    /// Create a candy for a specific elemental type
    public static ItemStack createForElement(ElementalType elementalType, Stats targetIVStat) {
        ItemStack itemStack = new ItemStack(ModItems.CANDY);
        var shardDataElementalType = ElementalTypeMap.getElementalTypeId(elementalType);
        var statName = targetIVStat != null ? IVStatMap.getIVStat(targetIVStat) : "Random IV";
        var shardName = String.format("%s %s [%s]", elementalType.getName(), BASE_CANDY_NAME, statName);
        var shardModelNumber = CandyModel.getElemental(shardDataElementalType, targetIVStat);

        itemStack.set(DataCandy.COMPONENT, DataCandy.of(CandyType.ELEMENTAL_TYPE, 0, shardDataElementalType, statName));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(shardModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(shardName));

        return itemStack;
    }
}
