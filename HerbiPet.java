public class HerbiPet {
    private static final int HERBI_PET_ID = 21509;
    private static final double PET_CHANCE = 1.0 / 6500;

    public static void rollForPet(Player player) {
        if (Math.random() < PET_CHANCE) {
            if (player.getInventory().contains(HERBI_PET_ID) || player.getBank().contains(HERBI_PET_ID)) {
                player.sendMessage("You have a funny feeling like you would have been followed...");
            } else if (player.hasFollower()) {
                player.sendMessage("You have a funny feeling like you're being followed, but you already have a follower.");
                player.getBank().add(HERBI_PET_ID, 1);
            } else if (player.getInventory().hasSpace()) {
                player.getInventory().add(HERBI_PET_ID, 1);
                player.sendMessage("You have a funny feeling you're being followed...");
            } else {
                player.getBank().add(HERBI_PET_ID, 1);
                player.sendMessage("You feel something weird sneaking into your bank account.");
            }
        }
    }
}
