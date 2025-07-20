package io.github.psbds.cobblemon.iv.candy.items;

import io.github.psbds.cobblemon.iv.candy.items.components.DataShard;
import io.github.psbds.cobblemon.iv.candy.items.components.DataCandy;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.DataIVExtractor;

public class ModItemComponents {

    public static void initialize() {
        DataCandy.initialize();
        DataShard.initialize();
        DataIVExtractor.initialize();
    }
}