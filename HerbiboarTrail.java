package io.ruin.model.content;

import io.ruin.model.map.Position;
import io.ruin.model.map.object.GameObject;
import java.util.ArrayList;
import java.util.List;

public class HerbiboarTrail {
    private static final int FOOTPRINT_OBJECT_ID = 30918;
    private static final int FOOTPRINT_LIFETIME_TICKS = 50;

    private final List<Position> trailPositions;
    private final List<HerbiboarFootprint> footprints;

    public HerbiboarTrail(Position start, Position end, int numFootprints) {
        this.trailPositions = generateTrail(start, end, numFootprints);
        this.footprints = new ArrayList<>();
        createFootprints();
    }

    private List<Position> generateTrail(Position start, Position end, int numFootprints) {
        List<Position> trail = new ArrayList<>();
        trail.add(start);

        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();

        for (int i = 1; i < numFootprints - 1; i++) {
            int x = start.getX() + (dx * i / (numFootprints - 1));
            int y = start.getY() + (dy * i / (numFootprints - 1));
            trail.add(new Position(x, y, start.getZ()));
        }

        trail.add(end);
        return trail;
    }

    private void createFootprints() {
        for (Position pos : trailPositions) {
            footprints.add(new HerbiboarFootprint(pos));
        }
    }

    public void spawnFootprints() {
        for (HerbiboarFootprint footprint : footprints) {
            GameObject.spawn(FOOTPRINT_OBJECT_ID, footprint.getLocation(), 10, 0);
        }
    }

    public void tick() {
        footprints.removeIf(footprint -> {
            footprint.tick();
            if (footprint.shouldDespawn()) {
                GameObject.remove(FOOTPRINT_OBJECT_ID, footprint.getLocation());
                return true;
            }
            return false;
        });
    }

    public boolean isComplete() {
        return footprints.isEmpty();
    }

    public Position getLastPosition() {
        return trailPositions.get(trailPositions.size() - 1);
    }
}
