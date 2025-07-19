package io.github.psbds.cobblemon.iv.candy.items.objects.candies.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;

import io.github.psbds.cobblemon.iv.candy.Boot;
import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.components.DataCandy;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.IVStatMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.CandyType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CandyInteractLivingEntity {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandyInteractLivingEntity.class.getName());

    public static InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
            InteractionHand hand) {

        Boot.LOGGER.info("Candy used on Pokémon: 1");

        // 1. Check if it's running on the Client side
        if (player.level().isClientSide) {
            return InteractionResult.SUCCESS;
        }
        Boot.LOGGER.info("Candy used on Pokémon:2");

        // 2. Check if the entity is a PokemonEntity
        if (!(entity instanceof PokemonEntity pokemonEntity)) {
            LOGGER.warn("Tried to use Candy on a non-PokemonEntity: " + entity.getType().getDescriptionId());
            return InteractionResult.FAIL;
        }
        Boot.LOGGER.info("Candy used on Pokémon: 3");

        // 3. Check if the player owns the PokemonEntity
        if (!pokemonEntity.isOwnedBy(player)) {
            player.sendSystemMessage(Component.literal("You do not own this Pokémon."));
            return InteractionResult.FAIL;
        }
        Boot.LOGGER.info("Candy used on Pokémon: 4");

        // 4. Check if the stack has the DataCandy component
        var dataCandy = stack.get(DataCandy.COMPONENT);
        if (dataCandy == null) {
            player.sendSystemMessage(Component.literal("This item is not a valid Candy."));
            return InteractionResult.FAIL;
        }

        // 5. Check if the target is a matching PokemonEntity
        if (!isMatchingTarget(pokemonEntity, dataCandy, player)) {

            return InteractionResult.FAIL;
        }

        Boot.LOGGER.info("Candy used on Pokémon: 5");

        if (dataCandy.targetIVStat() == Candy.IDENTIFIER_RANDOM_IV
                && !handleRandomIV(pokemonEntity.getPokemon(), dataCandy, player)) {
            return InteractionResult.FAIL;
        } else if (dataCandy.targetIVStat() != Candy.IDENTIFIER_RANDOM_IV
                && !handleTargetIv(pokemonEntity.getPokemon(), dataCandy, player, IVStatMap.getStats(dataCandy.targetIVStat()))) {
            return InteractionResult.FAIL;
        }

        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }
        player.sendSystemMessage(Component.literal("You used " + stack.getDisplayName().getString() + " on "
                + pokemonEntity.getPokemon().getSpecies().getName() + "."));
        return InteractionResult.SUCCESS;

    }

    private static Boolean isMatchingTarget(PokemonEntity target, DataCandy candyData, Player player) {
        var pokemon = target.getPokemon();
        if (candyData.candyType().equals(CandyType.SPECIES)) {
            return isMatchingSpecies(pokemon, candyData, player);
        } else if (candyData.candyType().equals(CandyType.ELEMENTAL_TYPE)) {
            return isMatchingElementalType(pokemon, candyData, player);
        } else if (candyData.candyType().equals(CandyType.LEGENDARY)) {
            return isMatchingLegendary(pokemon, candyData, player);
        } else if (candyData.candyType().equals(CandyType.MYTHICAL)) {
            return isMatchingMythical(pokemon, candyData, player);
        } else if (candyData.candyType().equals(CandyType.ULTRA_BEAST)) {
            return isMatchingUltraBeast(pokemon, candyData, player);
        } else if (candyData.candyType().equals(CandyType.PARADOX)) {
            return isMatchingParadox(pokemon, candyData, player);
        }

        LOGGER.error("Failed to match candy type: " + candyData.candyType());
        return false;
    }

    private static Boolean isMatchingSpecies(Pokemon target, DataCandy candyData, Player player) {
        var targetBaseSpecies = CobblemonSpeciesHelper.getFirstEvolution(target.getSpecies());
        if (targetBaseSpecies.getNationalPokedexNumber() == candyData.baseSpeciesPokedexNumber()) {
            return true;
        }
        player.sendSystemMessage(
                Component.literal("This candy is not compatible with " + target.getSpecies().getName() + ", because it does not match the required base species."));
        return false;
    }

    private static Boolean isMatchingElementalType(Pokemon target, DataCandy candyData, Player player) {
        if (ElementalTypeMap.getElementalTypeId(target.getPrimaryType()) == candyData.elementalType()) {
            return true;
        }
        if (target.getSecondaryType() != null
                && ElementalTypeMap.getElementalTypeId(target.getSecondaryType()) == candyData.elementalType()) {
            return true;
        }
        player.sendSystemMessage(
                Component.literal("This candy is not compatible with " + target.getSpecies().getName() + ", because it does not match the required elemental type."));
        return false;
    }

    private static Boolean isMatchingLegendary(Pokemon target, DataCandy candyData, Player player) {
        if (CobblemonSpeciesHelper.isLegendary(target.getSpecies())) {
            return true;
        }
        player.sendSystemMessage(Component.literal("This candy is not compatible with " + target.getSpecies().getName() + ", because it is not a Legendary Pokémon."));
        return false;
    }

    private static Boolean isMatchingMythical(Pokemon target, DataCandy candyData, Player player) {
        if (CobblemonSpeciesHelper.isMythical(target.getSpecies())) {
            return true;
        }
        player.sendSystemMessage(Component.literal("This candy is not compatible with " + target.getSpecies().getName() + ", because it is not a Mythical Pokémon."));
        return false;
    }

    private static Boolean isMatchingUltraBeast(Pokemon target, DataCandy candyData, Player player) {
        if (CobblemonSpeciesHelper.isUltraBeast(target.getSpecies())) {
            return true;
        }
        player.sendSystemMessage(Component.literal("This candy is not compatible with " + target.getSpecies().getName() + ", because it is not an Ultra Beast Pokémon."));
        return false;
    }

    private static Boolean isMatchingParadox(Pokemon target, DataCandy candyData, Player player) {
        if (CobblemonSpeciesHelper.isParadox(target.getSpecies())) {
            return true;
        }
        player.sendSystemMessage(Component.literal("This candy is not compatible with " + target.getSpecies().getName() + ", because it is not a Paradox Pokémon."));
        return false;
    }

    private static Boolean handleRandomIV(Pokemon pokemon, DataCandy candyData, Player player) {
        Stat[] stats = { Stats.HP, Stats.ATTACK, Stats.DEFENCE, Stats.SPECIAL_ATTACK, Stats.SPECIAL_DEFENCE,
                Stats.SPEED };
        // Collect stats that are not maxed out
        List<Stat> availableStats = new ArrayList<>();
        for (Stat stat : stats) {
            if (pokemon.getIvs().get(stat) < 31) {
                availableStats.add(stat);
            }
        }

        if (availableStats.isEmpty()) {
            player.sendSystemMessage(Component.literal("All IVs are already maxed out for " + pokemon.getSpecies().getName() + "."));
            return false;
        }

        var random = new Random();
        int idx = random.nextInt(availableStats.size());
        var targetIVStat = availableStats.get(idx);
        return handleTargetIv(pokemon, candyData, player, targetIVStat);
    }

    private static Boolean handleTargetIv(Pokemon pokemon, DataCandy candyData, Player player, Stat targetIvStat) {
        int currentIV = pokemon.getIvs().get(targetIvStat);
        if (currentIV >= 31) {
            player.sendSystemMessage(Component.literal("The IV for " + targetIvStat.getDisplayName() + " is already maxed out for " + pokemon.getSpecies().getName() + "."));
            return false;
        }
        pokemon.getIvs().set(targetIvStat, pokemon.getIvs().get(targetIvStat) + 1);

        return true;
    }
}
