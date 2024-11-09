public class NooseWand {
    private static final int NOOSE_WAND_ID = 21633;

    public static boolean hasNooseWand(Player player) {
        return player.getInventory().contains(NOOSE_WAND_ID);
    }

    public static void useNooseWand(Player player) {
        // Animation and logic for using the Noose Wand
    }
}
