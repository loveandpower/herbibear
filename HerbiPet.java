public class HerbiPet {
    private static final int HERBI_PET_ID = 21509;
    private static final double PET_CHANCE = 1.0 / 6500;

    public static boolean rollForPet(Player player) {
        if (Math.random() < PET_CHANCE) {
            player.getInventory().add(HERBI_PET_ID, 1);
            player.sendMessage("You have a funny feeling you're being followed...");
            return true;
        }
        return false;
    }
}
