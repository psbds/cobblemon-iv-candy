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

public record DataPokedexNumber(int baseSpeciesPokedexNumber) {

    public static final String NAME = "pokedex_number";

    public static final Codec<DataPokedexNumber> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(Codec.INT.fieldOf("baseSpeciesPokedexNumber").forGetter(DataPokedexNumber::baseSpeciesPokedexNumber))
                    .apply(instance, DataPokedexNumber::new));

    public static final StreamCodec<ByteBuf, DataPokedexNumber> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, DataPokedexNumber::baseSpeciesPokedexNumber,
            DataPokedexNumber::new);

    public static DataPokedexNumber of(int baseSpeciesPokedexNumber) {
        return new DataPokedexNumber(baseSpeciesPokedexNumber);
    }

    public static final DataComponentType<DataPokedexNumber> COMPONENT = DataComponentType.<DataPokedexNumber>builder()
            .persistent(DataPokedexNumber.CODEC)
            .networkSynchronized(DataPokedexNumber.STREAM_CODEC)
            .build();

    public static void initialize() {
        Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Boot.MOD_ID, NAME),
                COMPONENT);
    }
}
