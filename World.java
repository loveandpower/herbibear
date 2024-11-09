public class World {
    public static final int HERBIBOAR_REGION_ID = 1234; // Replace with actual region ID

    public static void handleObjectClick(Player player, int objectId) {
        if (player.getHerbiboarHunting() != null) {
            player.getHerbiboarHunting().handleObjectClick(objectId);
        }
    }

    public static void handleNPCClick(Player player, NPC npc) {
        if (player.getHerbiboarHunting() != null && npc.getId() == HerbiboarHunting.HERBIBOAR_NPC_ID) {
            player.getHerbiboarHunting().handleHerbiboarClick();
        }
    }

    public static void onRegionEnter(Player player, int regionId) {
        if (regionId == HERBIBOAR_REGION_ID) {
            player.setHerbiboarHunting(new HerbiboarHunting(player));
        }
    }

    public static void onRegionExit(Player player, int regionId) {
        if (regionId == HERBIBOAR_REGION_ID) {
            player.setHerbiboarHunting(null);
        }
    }

    public static void spawnNPC(NPC npc) {
        // Code to spawn an NPC in the game world
    }

    public static void removeNPC(NPC npc) {
        // Code to remove an NPC from the game world
    }
}
