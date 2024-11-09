public class HerbiboarSpawnTimer {
    private static final long SPAWN_DELAY = 60000; // 1 minute in milliseconds
    private long lastSpawnTime;

    public boolean canSpawn() {
        return System.currentTimeMillis() - lastSpawnTime >= SPAWN_DELAY;
    }

    public void updateSpawnTime() {
        lastSpawnTime = System.currentTimeMillis();
    }
}
