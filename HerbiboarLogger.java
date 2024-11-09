package io.ruin.model.content;

import io.ruin.model.entity.player.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HerbiboarLogger {
    private static final Logger LOGGER = Logger.getLogger(HerbiboarLogger.class.getName());

    public static void log(String message) {
        LOGGER.info(message);
    }

    public static void logError(String message, Exception e) {
        LOGGER.log(Level.SEVERE, message, e);
    }

    public static void logPlayerAction(Player player, String action) {
        LOGGER.info("[Player: " + player.getName() + "] " + action);
    }

    public static void logHerbHarvest(Player player, String herb, int amount) {
        LOGGER.info("[Player: " + player.getName() + "] Harvested " + amount + " " + herb);
    }

    public static void logCatchAttempt(Player player, boolean success) {
        String result = success ? "successful" : "failed";
        LOGGER.info("[Player: " + player.getName() + "] Catch attempt " + result);
    }

    public static void logPetDrop(Player player) {
        LOGGER.info("[Player: " + player.getName() + "] Received Herbi pet");
    }

    public static void logDebug(String message) {
        if (isDebugMode()) {
            LOGGER.fine("[DEBUG] " + message);
        }
    }

    private static boolean isDebugMode() {
        // Implement a way to toggle debug mode, e.g., based on a server configuration
        return false; // Default to false for production
    }
}
