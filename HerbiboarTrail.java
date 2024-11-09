public class HerbiboarTrail {
    private static final int FOOTPRINT_OBJECT_ID = 30918;
    private static final int FOOTPRINT_LIFETIME_TICKS = 50;

    private final List<Coordinate> trailCoordinates;
    private final List<HerbiboarFootprint> footprints;

    public HerbiboarTrail(Coordinate start, Coordinate end, int numFootprints) {
        this.trailCoordinates = generateTrail(start, end, numFootprints);
        this.footprints = new ArrayList<>();
        createFootprints();
    }

    private List<Coordinate> generateTrail(Coordinate start, Coordinate end, int numFootprints) {
        List<Coordinate> trail = new ArrayList<>();
        trail.add(start);

        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();

        for (int i = 1; i < numFootprints - 1; i++) {
            int x = start.getX() + (dx * i / (numFootprints - 1));
            int y = start.getY() + (dy * i / (numFootprints - 1));
            trail.add(new Coordinate(x, y, start.getPlane()));
        }

        trail.add(end);
        return trail;
    }

    private void createFootprints() {
        for (Coordinate coord : trailCoordinates) {
            footprints.add(new HerbiboarFootprint(coord, FOOTPRINT_LIFETIME_TICKS));
        }
    }

    public void spawnFootprints(World world) {
        for (HerbiboarFootprint footprint : footprints) {
            world.spawnObject(FOOTPRINT_OBJECT_ID, footprint.getLocation());
        }
    }

    public void tick(World world) {
        for (HerbiboarFootprint footprint : footprints) {
            footprint.tick();
            if (footprint.shouldDespawn()) {
                world.removeObject(FOOTPRINT_OBJECT_ID, footprint.getLocation());
            }
        }
        footprints.removeIf(HerbiboarFootprint::shouldDespawn);
    }
}
