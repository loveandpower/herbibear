package io.ruin.model.content;

import io.ruin.model.map.Position;

public class HerbiboarFootprint {
    private static final int FOOTPRINT_OBJECT_ID = 30918; // Object ID for the footprint
    private static final int DESPAWN_TICKS = 50; // Time in ticks before the footprint despawns

    private final Position location; // Use Position instead of Coordinate
    private int despawnTimer;

    public HerbiboarFootprint(Position location) {
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

    public Position getLocation() {
        return location;
    }

    public void spawnFootprint() {
        GameObject.spawn(FOOTPRINT_OBJECT_ID, location); // Spawn the footprint at the location
    }

    public void removeFootprint() {
        GameObject.remove(FOOTPRINT_OBJECT_ID, location); // Remove the footprint from the game world
    }
}
