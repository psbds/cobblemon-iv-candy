package io.github.psbds.cobblemon.iv.candy.items.objects.candies;

import java.util.ArrayList;
import java.util.List;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.types.ElementalTypes;

import net.minecraft.world.item.ItemStack;

public class CandyCatalog {

    public static List<ItemStack> getCatalogCandys() {
        List<ItemStack> candys = new ArrayList<>();

        var targetIVStats = List.of(Stats.ATTACK, Stats.DEFENCE, Stats.SPECIAL_ATTACK,
                Stats.SPECIAL_DEFENCE, Stats.SPEED, Stats.HP);

        candys.addAll(createCandiesForIVStat(null));

        for (var targetIVStat : targetIVStats) {
            candys.addAll(createCandiesForIVStat(targetIVStat));
        }

        return candys;
    }

    private static List<ItemStack> createCandiesForIVStat(Stats targetIVStat) {
        List<ItemStack> candies = new ArrayList<>();
        candies.add(CandyFactory.createForSpeciesSample(targetIVStat));

        for (var elementalType : ElementalTypes.INSTANCE.all()) {
            candies.add(CandyFactory.createForElement(elementalType, targetIVStat));
        }

        candies.add(CandyFactory.createLegendaryCandy(targetIVStat));
        candies.add(CandyFactory.createMythicalCandy(targetIVStat));
        candies.add(CandyFactory.createUltraBeastCandy(targetIVStat));
        candies.add(CandyFactory.createParadoxCandy(targetIVStat));

        return candies;
    }
}
