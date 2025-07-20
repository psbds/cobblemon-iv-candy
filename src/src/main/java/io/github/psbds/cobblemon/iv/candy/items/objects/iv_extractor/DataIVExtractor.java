package io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.github.psbds.cobblemon.iv.candy.Boot;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record DataIVExtractor(
        String ivExtractorType, 
        int baseSpeciesPokedexNumber,
        int elementalType
) {

        public static final String NAME = "iv_extractor_type";

        public static DataIVExtractor of(String ivExtractorType, int baseSpeciesPokedexNumber, int elementalType) {
                return new DataIVExtractor(ivExtractorType, baseSpeciesPokedexNumber, elementalType);
        }

        public static final DataComponentType<DataIVExtractor> COMPONENT = DataComponentType.<DataIVExtractor>builder()
                        .persistent(RecordCodecBuilder.create(
                                        instance -> instance.group(
                                                        Codec.STRING.fieldOf("ivExtractorType")
                                                                        .forGetter(DataIVExtractor::ivExtractorType),
                                                        Codec.INT.fieldOf("baseSpeciesPokedexNumber")
                                                                        .forGetter(DataIVExtractor::baseSpeciesPokedexNumber),
                                                        Codec.INT.fieldOf("elementalType")
                                                                        .forGetter(DataIVExtractor::elementalType))
                                                        .apply(instance, DataIVExtractor::new)))
                        .networkSynchronized(StreamCodec.composite(
                                        ByteBufCodecs.STRING_UTF8, DataIVExtractor::ivExtractorType,
                                        ByteBufCodecs.INT, DataIVExtractor::baseSpeciesPokedexNumber,
                                        ByteBufCodecs.INT, DataIVExtractor::elementalType,
                                        DataIVExtractor::new))
                        .build();

        public static void initialize() {
                Registry.register(
                                BuiltInRegistries.DATA_COMPONENT_TYPE,
                                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, NAME),
                                COMPONENT);
        }
}
