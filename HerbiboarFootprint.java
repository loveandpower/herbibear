public class HerbiboarFootprint {
    private static final int FOOTPRINT_OBJECT_ID = 30918;
    private static final int DESPAWN_TICKS = 50; // Adjust as needed

    private final Coordinate location;
    private int despawnTimer;

    public HerbiboarFootprint(Coordinate location) {
        this.location = location;
        this.despawnTimer = DESPAWN_TICKS;
    }

    public void tick() {
        if (despawnTimer > 0) {
            despawnTimer--;
        }
    }

    public boolean shouldDespawn() {
        return despawnTimer == 0;
    }
}
