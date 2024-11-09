package io.ruin.model.content;

import io.ruin.model.entity.player.Player;

public class HerbiPet {
    private static final int HERBI_PET_ID = 21509; // ID for the Herbi pet
    private static final double PET_CHANCE = 1.0 / 6500; // Chance to receive the pet

    public static void rollForPet(Player player) {
        if (Math.random() < PET_CHANCE) {
            // Check if the player already has the pet in their inventory or bank
            if (player.getInventory().contains(HERBI_PET_ID) || player.getBank().contains(HERBI_PET_ID)) {
                player.sendMessage("You have a funny feeling like you would have been followed...");
            } 
            // Check if the player already has a follower
            else if (player.hasFollower()) {
                player.sendMessage("You have a funny feeling like you're being followed, but you already have a follower.");
                player.getBank().add(HERBI_PET_ID, 1); // Send to bank if they can't hold it
            } 
            // If they have space in their inventory
            else if (player.getInventory().hasSpace()) {
                player.getInventory().add(HERBI_PET_ID, 1);
                player.sendMessage("You have a funny feeling you're being followed...");
            } 
            // If inventory is full, send to bank
            else {
                player.getBank().add(HERBI_PET_ID, 1);
                player.sendMessage("You feel something weird sneaking into your bank account.");
            }
        }
    }
}
