package io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.actions;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;

import io.github.psbds.cobblemon.iv.candy.helpers.CobblemonSpeciesHelper;
import io.github.psbds.cobblemon.iv.candy.items.mappers.ElementalTypeMap;
import io.github.psbds.cobblemon.iv.candy.items.mappers.IVStatMap;
import io.github.psbds.cobblemon.iv.candy.items.objects.candies.Candy;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.DataIVExtractor;
import io.github.psbds.cobblemon.iv.candy.items.objects.iv_extractor.IVExtractorType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class IVExtractorInteractLivingEntity {

    private static final Logger LOGGER = LoggerFactory.getLogger(IVExtractorInteractLivingEntity.class.getName());

    public static InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity,
            InteractionHand hand) {

        // 1. Check if it's running on the Client side
        if (player.level().isClientSide) {
            return InteractionResult.SUCCESS;
        }

        // 2. Check if the entity is a PokemonEntity
        if (!(entity instanceof PokemonEntity pokemonEntity)) {
            LOGGER.warn("Tried to use Candy on a non-PokemonEntity: " + entity.getType().getDescriptionId());
            return InteractionResult.FAIL;
        }

        // 3. Check if the player owns the PokemonEntity
        if (!pokemonEntity.isOwnedBy(player)) {
            player.sendSystemMessage(Component.literal("You do not own this Pokémon."));
            return InteractionResult.FAIL;
        }

        // 4. Check if the stack has the DataIVExtractor component
        var dataIVExtractor = stack.get(DataIVExtractor.COMPONENT);
        if (dataIVExtractor == null) {
            player.sendSystemMessage(Component.literal("This item is not a valid Candy."));
            return InteractionResult.FAIL;
        }

        // 5. Check if the target is a matching PokemonEntity
        if (!isMatchingTarget(pokemonEntity, dataIVExtractor, player)) {

            return InteractionResult.FAIL;
        }

        if (!handleIVExtraction(pokemonEntity.getPokemon(), stack, player)) {
            return InteractionResult.FAIL;
        }

        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        return InteractionResult.SUCCESS;

    }

    private static Boolean isMatchingTarget(PokemonEntity target, DataIVExtractor ivExtractorData, Player player) {
        var pokemon = target.getPokemon();
        if (ivExtractorData.ivExtractorType().equals(IVExtractorType.ELEMENTAL_TYPE)) {
            return isMatchingElementalType(pokemon, ivExtractorData, player);
        } else if (ivExtractorData.ivExtractorType().equals(IVExtractorType.LEGENDARY)) {
            return isMatchingLegendary(pokemon, ivExtractorData, player);
        } else if (ivExtractorData.ivExtractorType().equals(IVExtractorType.MYTHICAL)) {
            return isMatchingMythical(pokemon, ivExtractorData, player);
        } else if (ivExtractorData.ivExtractorType().equals(IVExtractorType.ULTRA_BEAST)) {
            return isMatchingUltraBeast(pokemon, ivExtractorData, player);
        } else if (ivExtractorData.ivExtractorType().equals(IVExtractorType.PARADOX)) {
            return isMatchingParadox(pokemon, ivExtractorData, player);
        }

        LOGGER.error("Failed to match candy type: " + ivExtractorData.ivExtractorType());
        return false;
    }

    private static Boolean isMatchingElementalType(Pokemon target, DataIVExtractor ivExtractorData, Player player) {
        if (ElementalTypeMap.getElementalTypeId(target.getPrimaryType()) == ivExtractorData.elementalType()) {
            return true;
        }
        if (target.getSecondaryType() != null
                && ElementalTypeMap.getElementalTypeId(target.getSecondaryType()) == ivExtractorData.elementalType()) {
            return true;
        }
        String message = String.format(
                "This IV Extractor is not compatible with %s, because it does not match the required elemental type: %s.",
                target.getSpecies().getName(), ElementalTypeMap.getElementalType(ivExtractorData.elementalType()));
        player.sendSystemMessage(Component.literal(message));
        return false;
    }

    private static Boolean isMatchingLegendary(Pokemon target, DataIVExtractor ivExtractorData, Player player) {
        if (CobblemonSpeciesHelper.isLegendary(target.getSpecies())) {
            return true;
        }
        String message = String.format(
                "This IV Extractor is not compatible with %s, because it is not a Legendary Pokémon.",
                target.getSpecies().getName());
        player.sendSystemMessage(Component.literal(message));
        return false;
    }

    private static Boolean isMatchingMythical(Pokemon target, DataIVExtractor ivExtractorData, Player player) {
        if (CobblemonSpeciesHelper.isMythical(target.getSpecies())) {
            return true;
        }
        String message = String.format(
                "This IV Extractor is not compatible with %s, because it is not a Mythical Pokémon.",
                target.getSpecies().getName());
        player.sendSystemMessage(Component.literal(message));
        return false;
    }

    private static Boolean isMatchingUltraBeast(Pokemon target, DataIVExtractor ivExtractorData, Player player) {
        if (CobblemonSpeciesHelper.isUltraBeast(target.getSpecies())) {
            return true;
        }
        String message = String.format(
                "This IV Extractor is not compatible with %s, because it is not an Ultra Beast Pokémon.",
                target.getSpecies().getName());
        player.sendSystemMessage(Component.literal(message));
        return false;
    }

    private static Boolean isMatchingParadox(Pokemon target, DataIVExtractor ivExtractorData, Player player) {
        if (CobblemonSpeciesHelper.isParadox(target.getSpecies())) {
            return true;
        }
        String message = String.format(
                "This IV Extractor is not compatible with %s, because it is not a Paradox Pokémon.",
                target.getSpecies().getName());
        player.sendSystemMessage(Component.literal(message));
        return false;
    }

    private static boolean handleIVExtraction(Pokemon pokemon, ItemStack ivExtractor, Player player) {
        Stats[] stats = { Stats.HP, Stats.ATTACK, Stats.DEFENCE, Stats.SPECIAL_ATTACK, Stats.SPECIAL_DEFENCE,
                Stats.SPEED };
        var ivs = pokemon.getIvs();
        var fullIVs = new ArrayList<Stats>();

        for (Stats stat : stats) {
            if (ivs.get(stat) == 31) {
                fullIVs.add(stat);
            }
        }
        if (fullIVs.isEmpty()) {
            player.sendSystemMessage(Component.literal("This Pokémon has no IVs to extract."));
            return false;
        }

        for (var fullIV : fullIVs) {
            var candy = Candy.createByExtractor(ivExtractor, fullIV);
            player.getInventory().add(candy);
            pokemon.getIvs().set(fullIV, 1);
            player.sendSystemMessage(Component.literal(
                    String.format("Extracted %s IV from %s and created a Candy.", IVStatMap.getIVStat(fullIV),
                            pokemon.getSpecies().getName())));
        }

        return true;
    }
}
