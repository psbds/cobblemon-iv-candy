package io.github.psbds.cobblemon.iv.candy.items.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record DataElementalType(int elementalType) {

    public static final String NAME = "data_elemental_type";

    public static final Codec<DataElementalType> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(Codec.INT.fieldOf("elementalType").forGetter(DataElementalType::elementalType))
                    .apply(instance, DataElementalType::new));

    public static final StreamCodec<ByteBuf, DataElementalType> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, DataElementalType::elementalType,
            DataElementalType::new);

    public static DataElementalType of(int elementalType) {
        return new DataElementalType(elementalType);
    }

    public static final DataComponentType<DataElementalType> COMPONENT = DataComponentType.<DataElementalType>builder()
            .persistent(DataElementalType.CODEC)
            .networkSynchronized(DataElementalType.STREAM_CODEC)
            .build();

    public static void initialize() {
        Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, NAME),
                COMPONENT);
    }
}
