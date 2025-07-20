package io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor;

import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.api.types.ElementalTypes;

import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.model.CustomModelDataMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class IVExtractorFactory {
    private static final String BASE_IV_EXTRACTOR_NAME = "IV Extractor";

    public static IVExtractor createDefault() {
        var props = new Item.Properties();

        var elementalType = ElementalTypes.INSTANCE.getNORMAL();
        var ivExtractorDataElementalType = ElementalTypeMap.getElementalTypeId(elementalType);
        var ivExtractorName = String.format("%s %s", elementalType.getName(), BASE_IV_EXTRACTOR_NAME);
        var ivExtractorModelNumber = IVExtractorModel.getElemental(elementalType);

        props.component(DataIVExtractor.COMPONENT, DataIVExtractor.of(IVExtractorType.ELEMENTAL_TYPE, 0, ivExtractorDataElementalType));
        props.component(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(ivExtractorModelNumber));
        props.component(DataComponents.CUSTOM_NAME, Component.literal(ivExtractorName));

        return new IVExtractor(props);
    }

    /// Create the Legendary ivExtractor with specific properties
    public static ItemStack createLegendary() {
        ItemStack itemStack = new ItemStack(ModItems.IV_EXTRACTOR);

        var ivExtractorName = String.format("Legendary %s", BASE_IV_EXTRACTOR_NAME);
        var ivExtractorModelNumber = IVExtractorModel.getLegendary();

        itemStack.set(DataIVExtractor.COMPONENT, DataIVExtractor.of(IVExtractorType.LEGENDARY, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(ivExtractorModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(ivExtractorName));

        return itemStack;
    }

    /// Create the Mythical ivExtractor with specific properties
    public static ItemStack createMythical() {
        ItemStack itemStack = new ItemStack(ModItems.IV_EXTRACTOR);

        var ivExtractorName = String.format("Mythical %s", BASE_IV_EXTRACTOR_NAME);
        var ivExtractorModelNumber = IVExtractorModel.getMythical();

        itemStack.set(DataIVExtractor.COMPONENT, DataIVExtractor.of(IVExtractorType.MYTHICAL, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(ivExtractorModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(ivExtractorName));

        return itemStack;
    }

    /// Create the Ultra Beast ivExtractor with specific properties
    public static ItemStack createUltrabeast() {
        ItemStack itemStack = new ItemStack(ModItems.IV_EXTRACTOR);

        var ivExtractorName = String.format("Ultra Beast %s", BASE_IV_EXTRACTOR_NAME);
        var ivExtractorModelNumber = IVExtractorModel.getUltraBeast();

        itemStack.set(DataIVExtractor.COMPONENT, DataIVExtractor.of(IVExtractorType.ULTRA_BEAST, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(ivExtractorModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(ivExtractorName));

        return itemStack;
    }

    /// Create the Paradox ivExtractor with specific properties
    public static ItemStack createParadox() {
        ItemStack itemStack = new ItemStack(ModItems.IV_EXTRACTOR);

        var ivExtractorName = String.format("Paradox %s", BASE_IV_EXTRACTOR_NAME);
        var ivExtractorModelNumber = IVExtractorModel.getParadox();

        itemStack.set(DataIVExtractor.COMPONENT, DataIVExtractor.of(IVExtractorType.PARADOX, 0, -1));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(ivExtractorModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(ivExtractorName));

        return itemStack;
    }

    /// Create a ivExtractor for a specific elemental type
    public static ItemStack createElement(ElementalType elementalType) {
        ItemStack itemStack = new ItemStack(ModItems.IV_EXTRACTOR);
        var ivExtractorDataElementalType = ElementalTypeMap.getElementalTypeId(elementalType);
        var ivExtractorName = String.format("%s %s", elementalType.getName(), BASE_IV_EXTRACTOR_NAME);
        var ivExtractorModelNumber = IVExtractorModel.getElemental(elementalType);

        itemStack.set(DataIVExtractor.COMPONENT, DataIVExtractor.of(IVExtractorType.ELEMENTAL_TYPE, 0, ivExtractorDataElementalType));
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(ivExtractorModelNumber));
        itemStack.set(DataComponents.CUSTOM_NAME, Component.literal(ivExtractorName));

        return itemStack;
    }
}
