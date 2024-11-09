public class MagicSecateurs {
    private static final int MAGIC_SECATEURS_ID = 7409;

    public static boolean hasMagicSecateurs(Player player) {
        return player.getInventory().contains(MAGIC_SECATEURS_ID) || 
               player.getEquipment().contains(MAGIC_SECATEURS_ID);
    }

    public static int getHerbBonus(int baseHerbCount) {
        return (int) Math.floor(baseHerbCount * 1.1);
    }
}
