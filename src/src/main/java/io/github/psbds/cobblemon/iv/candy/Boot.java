package io.github.psbds.cobblemon.iv.candy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.psbds.cobblemon.iv.candy.commands.CommandRouter;
import io.github.psbds.cobblemon.iv.candy.config.ConfigManager;
import io.github.psbds.cobblemon.iv.candy.items.ModItems;
import io.github.psbds.cobblemon.iv.candy.items.ModCreativeTabs;
import io.github.psbds.cobblemon.iv.candy.items.ModItemComponents;
import io.github.psbds.cobblemon.iv.candy.listeners.BootListeners;
import io.github.psbds.cobblemon.iv.candy.recipes.ModRecipes;

public class Boot implements ModInitializer {
    public static final String MOD_ID = "cobblemon_iv_candy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static MinecraftServer MinecraftServer = null;

    @Override
    public void onInitialize() {
        Boot.LOGGER.info("Booting Cobblemon IV Candy Mod");
        try {
            // Load configuration first
            ConfigManager.getConfig();
            Boot.LOGGER.info("Configuration loaded successfully");

            ServerLifecycleEvents.SERVER_STARTING.register(minecraftServer -> {
                Boot.MinecraftServer = minecraftServer;
            });
            ModItemComponents.initialize();
            ModItems.initialize();
            ModCreativeTabs.registerCreativeTabs();
            ModRecipes.registerRecipes();
            CommandRouter.initialize();
            BootListeners.initialize();
        } catch (Exception e) {
            Boot.LOGGER.error("Error initializing Cobblemon IV Candy Mod", e);
            throw e;
        }
    }
}
