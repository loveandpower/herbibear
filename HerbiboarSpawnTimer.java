package io.ruin.model.content;

public class HerbiboarSpawnTimer {
    private static final long SPAWN_DELAY = 60000; // 1 minute in milliseconds
    private long lastSpawnTime;

    public HerbiboarSpawnTimer() {
        this.lastSpawnTime = System.currentTimeMillis();
    }

    public boolean canSpawn() {
        return System.currentTimeMillis() - lastSpawnTime >= SPAWN_DELAY;
    }

    public void updateSpawnTime() {
        lastSpawnTime = System.currentTimeMillis();
    }

    public long getTimeUntilNextSpawn() {
        long timeSinceLastSpawn = System.currentTimeMillis() - lastSpawnTime;
        return Math.max(0, SPAWN_DELAY - timeSinceLastSpawn);
    }

    public void reset() {
        lastSpawnTime = System.currentTimeMillis() - SPAWN_DELAY; // Allows immediate spawn
    }
}
