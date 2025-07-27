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

public record DataShard(
        String shardType, 
        int baseSpeciesPokedexNumber,
        int elementalType
) {

        public static final String NAME = "shard_type";

        public static DataShard of(String shardType, int baseSpeciesPokedexNumber, int elementalType) {
                return new DataShard(shardType, baseSpeciesPokedexNumber, elementalType);
        }

        public static DataComponentType<DataShard> COMPONENT;

        public static void initialize() {
                Boot.LOGGER.info("Registering DataShard component");
                
                COMPONENT = DataComponentType.<DataShard>builder()
                                .persistent(RecordCodecBuilder.create(
                                                instance -> instance.group(
                                                                Codec.STRING.fieldOf("shardType")
                                                                                .forGetter(DataShard::shardType),
                                                                Codec.INT.fieldOf("baseSpeciesPokedexNumber")
                                                                                .forGetter(DataShard::baseSpeciesPokedexNumber),
                                                                Codec.INT.fieldOf("elementalType")
                                                                                .forGetter(DataShard::elementalType))
                                                                .apply(instance, DataShard::new)))
                                .networkSynchronized(StreamCodec.composite(
                                                ByteBufCodecs.STRING_UTF8, DataShard::shardType,
                                                ByteBufCodecs.INT, DataShard::baseSpeciesPokedexNumber,
                                                ByteBufCodecs.INT, DataShard::elementalType,
                                                DataShard::new))
                                .build();
                                
                Registry.register(
                                BuiltInRegistries.DATA_COMPONENT_TYPE,
                                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, NAME),
                                COMPONENT);
                                
                Boot.LOGGER.info("Successfully registered DataShard component");
        }
}
