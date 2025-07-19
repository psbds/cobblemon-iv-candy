package io.github.psbds.cobblemon.iv.candy.listeners;

import io.github.psbds.cobblemon.iv.candy.Boot;

public class BootListeners {

    public static void initialize() {
        Boot.LOGGER.info("Initializing Boot Listeners");

        // Initialize all listeners
        OnPokemonFainted.initialize();
        OnPokemonCaptured.initialize();

        Boot.LOGGER.info("Successfully initialized Boot Listeners");
    }
}
