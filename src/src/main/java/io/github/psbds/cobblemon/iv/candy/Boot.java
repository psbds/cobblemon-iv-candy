package io.github.psbds.cobblemon.iv.candy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.psbds.cobblemon.iv.candy.commands.CandyCommand;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.components.BootComponents;
import io.github.psbds.cobblemon.iv.candy.listeners.OnPokemonFainted;
import io.github.psbds.cobblemon.iv.candy.recipes.ModRecipes;

public class Boot implements ModInitializer {
    public static final String MOD_ID = "cobblemon_iv_candy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static MinecraftServer MinecraftServer = null;

    @Override
    public void onInitialize() {
        Boot.LOGGER.info("Booting Cobblemon IV Candy Mod");
        try {
            ServerLifecycleEvents.SERVER_STARTING.register(minecraftServer -> {
                Boot.MinecraftServer = minecraftServer;
            });
            BootComponents.initialize();
            ModItems.initialize();
            ModRecipes.registerRecipes();
            CandyCommand.initialize();
            OnPokemonFainted.initialize();
        } catch (Exception e) {
            Boot.LOGGER.error("Error initializing Cobblemon IV Candy Mod", e);
            throw e;
        }
    }
}
