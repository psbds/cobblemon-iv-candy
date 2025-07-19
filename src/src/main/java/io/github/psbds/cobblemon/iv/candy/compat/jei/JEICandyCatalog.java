package io.github.psbds.cobblemon.iv.candy.compat.jei;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.mappers.CustomModelDataMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.IVStatMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class JEICandyCatalog {

    public static List<ItemStack> getAllCandies() {
        List<ItemStack> candies = new ArrayList<>();

        // Add species candys
        candies.add(speciesCandyItemStack(null)); // Random IV version

        for (var elementalType : ElementalTypes.INSTANCE.all()) {
            candies.add(elementalCandyItemStack(elementalType, null)); // Random IV version
        }

        // Add legendary candy
        candies.add(legendaryCandyItemStack(null)); // Random IV version
        // Add mythical candy
        candies.add(mythicalCandyItemStack(null)); // Random IV version
        // Add ultra beast candy
        candies.add(ultraBeastCandyItemStack(null)); // Random IV version
        // Add paradox candy
        candies.add(paradoxCandyItemStack(null)); // Random IV version

        return candies;
    }

    public static ItemStack speciesCandyItemStack(Stats targetIVStat) {
        var speciesCandy = new ItemStack(ModItems.CANDY);
        speciesCandy.set(DataComponents.CUSTOM_NAME, Component.literal(String.format("Species IV Candy %s", targetIVStat == null ? "[Random IV]" : IVStatMap.getIVStat(targetIVStat))));
        speciesCandy.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(
                        CustomModelDataMap.getElementalTypeCustomModelData(ElementalTypes.INSTANCE.getNORMAL())));

        return speciesCandy;
    }

    public static ItemStack elementalCandyItemStack(ElementalType type, Stats targetIVStat) {
        var speciesCandy = new ItemStack(ModItems.CANDY);
        speciesCandy.set(DataComponents.CUSTOM_NAME,
                Component.literal(String.format("%s IV Candy %s", type.getName(), targetIVStat == null ? " [Random IV]" : IVStatMap.getIVStat(targetIVStat))));
        speciesCandy.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getElementalTypeCustomModelData(type)));

        return speciesCandy;
    }

    public static ItemStack legendaryCandyItemStack(Stats targetIVStat) {
        var legendaryCandy = new ItemStack(ModItems.CANDY);
        legendaryCandy.set(DataComponents.CUSTOM_NAME, Component.literal(String.format("Legendary IV Candy %s", targetIVStat == null ? " [Random IV]" : IVStatMap.getIVStat(targetIVStat))));
        legendaryCandy.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForLegendary())); // Example model data

        return legendaryCandy;
    }

    public static ItemStack mythicalCandyItemStack(Stats targetIVStat) {
        var mythicalCandy = new ItemStack(ModItems.CANDY);
        mythicalCandy.set(DataComponents.CUSTOM_NAME, Component.literal(String.format("Mythical IV Candy %s", targetIVStat == null ? " [Random IV]" : IVStatMap.getIVStat(targetIVStat))));
        mythicalCandy.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForMythical())); // Example model data

        return mythicalCandy;
    }

    public static ItemStack ultraBeastCandyItemStack(Stats targetIVStat) {
        var ultraBeastCandy = new ItemStack(ModItems.CANDY);
        ultraBeastCandy.set(DataComponents.CUSTOM_NAME, Component.literal(String.format("Ultra Beast IV Candy %s", targetIVStat == null ? " [Random IV]" : IVStatMap.getIVStat(targetIVStat))));
        ultraBeastCandy.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForUltraBeast())); // Example model data

        return ultraBeastCandy;
    }

    public static ItemStack paradoxCandyItemStack(Stats targetIVStat) {
        var paradoxCandy = new ItemStack(ModItems.CANDY);
        paradoxCandy.set(DataComponents.CUSTOM_NAME, Component.literal(String.format("Paradox IV Candy %s", targetIVStat == null ? " [Random IV]" : IVStatMap.getIVStat(targetIVStat))));
        paradoxCandy.set(DataComponents.CUSTOM_MODEL_DATA,
                new CustomModelData(CustomModelDataMap.getCustomModelForParadox())); // Example model data

        return paradoxCandy;
    }
}