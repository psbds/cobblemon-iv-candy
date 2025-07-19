package io.github.psbds.cobblemon.iv.candy.items.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.github.psbds.cobblemon.iv.candy.Boot;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record DataCandy(
                String candyType,
                int baseSpeciesPokedexNumber,
                int elementalType,
                String targetIVStat) {

        public static final String NAME = "candy_type";

        public static DataCandy of(String candyType, int baseSpeciesPokedexNumber, int elementalType,
                        String targetIVStat) {
                return new DataCandy(candyType, baseSpeciesPokedexNumber, elementalType, targetIVStat);
        }

        public static final DataComponentType<DataCandy> COMPONENT = DataComponentType.<DataCandy>builder()
                        .persistent(RecordCodecBuilder.create(
                                        instance -> instance.group(
                                                        Codec.STRING.fieldOf("candyType")
                                                                        .forGetter(DataCandy::candyType),
                                                        Codec.INT.fieldOf("baseSpeciesPokedexNumber")
                                                                        .forGetter(DataCandy::baseSpeciesPokedexNumber),
                                                        Codec.INT.fieldOf("elementalType")
                                                                        .forGetter(DataCandy::elementalType),
                                                        Codec.STRING.fieldOf("targetIVStat")
                                                                        .forGetter(DataCandy::candyType))
                                                        .apply(instance, DataCandy::new)))
                        .networkSynchronized(StreamCodec.composite(
                                        ByteBufCodecs.STRING_UTF8, DataCandy::candyType,
                                        ByteBufCodecs.INT, DataCandy::baseSpeciesPokedexNumber,
                                        ByteBufCodecs.INT, DataCandy::elementalType,
                                        ByteBufCodecs.STRING_UTF8, DataCandy::targetIVStat,
                                        DataCandy::new))
                        .build();

        public static void initialize() {
                Registry.register(
                                BuiltInRegistries.DATA_COMPONENT_TYPE,
                                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, NAME),
                                COMPONENT);
        }
}
