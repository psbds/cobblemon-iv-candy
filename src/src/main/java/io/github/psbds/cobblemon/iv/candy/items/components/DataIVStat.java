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

public record DataIVStat(String targetStat) {

    public static final String NAME = "iv_stat";

    public static final Codec<DataIVStat> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(Codec.STRING.fieldOf("targetStat").forGetter(DataIVStat::targetStat))
                    .apply(instance, DataIVStat::new));

    public static final StreamCodec<ByteBuf, DataIVStat> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, DataIVStat::targetStat,
            DataIVStat::new);

    public static DataIVStat of(String targetStat) {
        return new DataIVStat(targetStat);
    }

    public static final DataComponentType<DataIVStat> COMPONENT = DataComponentType.<DataIVStat>builder()
            .persistent(DataIVStat.CODEC)
            .networkSynchronized(DataIVStat.STREAM_CODEC)
            .build();

    public static void initialize() {
        Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, NAME),
                COMPONENT);
    }
}
