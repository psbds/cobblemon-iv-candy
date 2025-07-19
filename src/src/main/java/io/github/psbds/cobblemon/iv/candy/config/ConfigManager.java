package io.github.psbds.cobblemon.iv.candy.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import io.github.psbds.cobblemon.iv.candy.Boot;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Manages the configuration file for the Cobblemon IV Candy mod.
 * Handles loading, saving, and validation of configuration settings.
 */
public class ConfigManager {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private static final String CONFIG_DIR = "config";
    private static final String CONFIG_FILE_NAME = "cobblemon_iv_candy.json";
    private static final Path CONFIG_PATH = Paths.get(CONFIG_DIR, CONFIG_FILE_NAME);

    private static ModConfig instance;

    /**
     * Gets the current configuration instance.
     * If not loaded yet, loads it from file or creates default.
     */
    public static ModConfig getConfig() {
        if (instance == null) {
            instance = loadConfig();
        }
        return instance;
    }

    /**
     * Loads the configuration from the JSON file.
     * If the file doesn't exist or is invalid, creates a new one with defaults.
     */
    public static ModConfig loadConfig() {
        Boot.LOGGER.info("Loading configuration from: " + CONFIG_PATH);

        try {
            // Create config directory if it doesn't exist
            Files.createDirectories(CONFIG_PATH.getParent());

            File configFile = CONFIG_PATH.toFile();

            if (!configFile.exists()) {
                Boot.LOGGER.info("Configuration file not found, creating default configuration");
                ModConfig defaultConfig = new ModConfig();
                defaultConfig.validate();
                saveConfig(defaultConfig);
                return defaultConfig;
            }

            // Try to read existing config
            try (FileReader reader = new FileReader(configFile)) {
                ModConfig config = GSON.fromJson(reader, ModConfig.class);

                if (config == null) {
                    Boot.LOGGER.warn("Configuration file is empty or invalid, creating default");
                    config = new ModConfig();
                }

                // Validate and fix any invalid values
                config.validate();

                // Save back to file to update any missing fields or fix invalid values
                saveConfig(config);

                Boot.LOGGER.info("Configuration loaded successfully");
                return config;

            } catch (JsonSyntaxException e) {
                Boot.LOGGER.error("Invalid JSON in configuration file, creating backup and using defaults", e);
                createBackup(configFile);
                ModConfig defaultConfig = new ModConfig();
                defaultConfig.validate();
                saveConfig(defaultConfig);
                return defaultConfig;
            }

        } catch (IOException e) {
            Boot.LOGGER.error("Error loading configuration file, using defaults", e);
            ModConfig defaultConfig = new ModConfig();
            defaultConfig.validate();
            return defaultConfig;
        }
    }

    /**
     * Saves the configuration to the JSON file.
     */
    public static void saveConfig(ModConfig config) {
        try {
            // Ensure config directory exists
            Files.createDirectories(CONFIG_PATH.getParent());

            // Validate before saving
            config.validate();

            try (FileWriter writer = new FileWriter(CONFIG_PATH.toFile())) {
                GSON.toJson(config, writer);
                Boot.LOGGER.info("Configuration saved successfully");
            }

        } catch (IOException e) {
            Boot.LOGGER.error("Error saving configuration file", e);
        }
    }

    /**
     * Reloads the configuration from file.
     */
    public static void reloadConfig() {
        Boot.LOGGER.info("Reloading configuration");
        instance = loadConfig();
    }

    /**
     * Creates a backup of the corrupted config file.
     */
    private static void createBackup(File originalFile) {
        try {
            String timestamp = String.valueOf(System.currentTimeMillis());
            Path backupPath = Paths.get(CONFIG_DIR, "cobblemon_iv_candy.json.backup." + timestamp);
            Files.copy(originalFile.toPath(), backupPath);
            Boot.LOGGER.info("Created backup of corrupted config file: " + backupPath);
        } catch (IOException e) {
            Boot.LOGGER.error("Failed to create backup of corrupted config file", e);
        }
    }

    /**
     * Gets the path to the configuration file.
     */
    public static Path getConfigPath() {
        return CONFIG_PATH;
    }

    /**
     * Checks if the configuration file exists.
     */
    public static boolean configExists() {
        return Files.exists(CONFIG_PATH);
    }
}
