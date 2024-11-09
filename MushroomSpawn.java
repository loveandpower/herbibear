public class MushroomSpawn {
    private static final int MUSHROOM_OBJECT_ID = 30917;
    private static final int RESPAWN_TICKS = 100; // Adjust as needed

    private final Coordinate location;
    private int respawnTimer;

    public MushroomSpawn(Coordinate location) {
        this.location = location;
        this.respawnTimer = 0;
    }

    public void pick(Player player) {
        if (respawnTimer == 0) {
            player.getInventory().add("Mushroom", 1);
            respawnTimer = RESPAWN_TICKS;
        }
    }

    public void tick() {
        if (respawnTimer > 0) {
            respawnTimer--;
        }
    }

    public boolean isAvailable() {
        return respawnTimer == 0;
    }
}
