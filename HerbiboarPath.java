package io.ruin.model.content;

import io.ruin.model.map.Position;
import java.util.*;

public class HerbiboarPath {
    private final List<TrackingSpot> spots;
    private int currentSpotIndex;

    // All possible tracking spots in OSRS
    private static final Map<String, Position> TRACKING_SPOTS = new HashMap<>();
    static {
        TRACKING_SPOTS.put("A", new Position(3680, 3871, 0));
        TRACKING_SPOTS.put("B", new Position(3688, 3874, 0));
        TRACKING_SPOTS.put("C", new Position(3683, 3881, 0));
        TRACKING_SPOTS.put("D", new Position(3694, 3877, 0));
        TRACKING_SPOTS.put("E", new Position(3688, 3885, 0));
        TRACKING_SPOTS.put("F", new Position(3675, 3880, 0));
        TRACKING_SPOTS.put("G", new Position(3682, 3889, 0));
        TRACKING_SPOTS.put("H", new Position(3697, 3887, 0));
        TRACKING_SPOTS.put("I", new Position(3702, 3879, 0));
        TRACKING_SPOTS.put("J", new Position(3690, 3893, 0));
        TRACKING_SPOTS.put("K", new Position(3696, 3893, 0));
        TRACKING_SPOTS.put("L", new Position(3671, 3890, 0));
        TRACKING_SPOTS.put("M", new Position(3677, 3897, 0));
        TRACKING_SPOTS.put("N", new Position(3685, 3901, 0));
        TRACKING_SPOTS.put("O", new Position(3681, 3907, 0));
        TRACKING_SPOTS.put("P", new Position(3701, 3894, 0));
        TRACKING_SPOTS.put("Q", new Position(3706, 3887, 0));
        TRACKING_SPOTS.put("R", new Position(3710, 3880, 0));
        TRACKING_SPOTS.put("S", new Position(3709, 3873, 0));
        TRACKING_SPOTS.put("T", new Position(3693, 3900, 0));
        TRACKING_SPOTS.put("U", new Position(3690, 3907, 0));
        TRACKING_SPOTS.put("V", new Position(3700, 3902, 0));
        TRACKING_SPOTS.put("W", new Position(3703, 3909, 0));
        TRACKING_SPOTS.put("X", new Position(3669, 3898, 0));
        TRACKING_SPOTS.put("Y", new Position(3672, 3905, 0));
        TRACKING_SPOTS.put("Z", new Position(3678, 3906, 0));
        TRACKING_SPOTS.put("AA", new Position(3676, 3912, 0));
        TRACKING_SPOTS.put("AB", new Position(3688, 3909, 0));
        TRACKING_SPOTS.put("AC", new Position(3686, 3915, 0));
        TRACKING_SPOTS.put("AD", new Position(3679, 3916, 0));
        TRACKING_SPOTS.put("AE", new Position(3674, 3921, 0));
    }

    // All possible paths in OSRS
    private static final Map<String, List<String>> PATH_OPTIONS = new HashMap<>();
    static {
        PATH_OPTIONS.put("A", Arrays.asList("B", "C"));
        PATH_OPTIONS.put("B", Arrays.asList("D", "E"));
        PATH_OPTIONS.put("C", Arrays.asList("F", "G"));
        PATH_OPTIONS.put("D", Arrays.asList("H", "I"));
        PATH_OPTIONS.put("E", Arrays.asList("J", "K"));
        PATH_OPTIONS.put("F", Arrays.asList("L", "M"));
        PATH_OPTIONS.put("G", Arrays.asList("N", "O"));
        PATH_OPTIONS.put("H", Arrays.asList("P", "Q"));
        PATH_OPTIONS.put("I", Arrays.asList("R", "S"));
        PATH_OPTIONS.put("J", Arrays.asList("T", "U"));
        PATH_OPTIONS.put("K", Arrays.asList("V", "W"));
        PATH_OPTIONS.put("L", Arrays.asList("X", "Y"));
        PATH_OPTIONS.put("M", Arrays.asList("Z", "AA"));
        PATH_OPTIONS.put("N", Arrays.asList("AB", "AC"));
        PATH_OPTIONS.put("O", Arrays.asList("AD", "AE"));
        PATH_OPTIONS.put("P", Arrays.asList("T", "V"));
        PATH_OPTIONS.put("Q", Arrays.asList("H", "R"));
        PATH_OPTIONS.put("R", Arrays.asList("Q", "S"));
        PATH_OPTIONS.put("S", Arrays.asList("I", "R"));
        PATH_OPTIONS.put("T", Arrays.asList("J", "U"));
        PATH_OPTIONS.put("U", Arrays.asList("T", "AB"));
        PATH_OPTIONS.put("V", Arrays.asList("K", "W"));
        PATH_OPTIONS.put("W", Arrays.asList("V", "P"));
        PATH_OPTIONS.put("X", Arrays.asList("L", "Y"));
        PATH_OPTIONS.put("Y", Arrays.asList("X", "Z"));
        PATH_OPTIONS.put("Z", Arrays.asList("M", "AA"));
        PATH_OPTIONS.put("AA", Arrays.asList("Z", "AD"));
        PATH_OPTIONS.put("AB", Arrays.asList("N", "AC"));
        PATH_OPTIONS.put("AC", Arrays.asList("AB", "U"));
        PATH_OPTIONS.put("AD", Arrays.asList("O", "AE"));
        PATH_OPTIONS.put("AE", Arrays.asList("AD", "AA"));
    }

    private HerbiboarPath(List<TrackingSpot> spots) {
        this.spots = new ArrayList<>(spots);
        this.currentSpotIndex = 0;
    }

    public TrackingSpot getCurrentSpot() {
        return currentSpotIndex < spots.size() ? spots.get(currentSpotIndex) : null;
    }

    public TrackingSpot getNextSpot() {
        if (currentSpotIndex + 1 < spots.size()) {
            return spots.get(currentSpotIndex + 1);
        }
        return null;
    }

    public boolean advanceToNextSpot() {
        if (currentSpotIndex + 1 < spots.size()) {
            currentSpotIndex++;
            return true;
        }
        return false;
    }

    public boolean isComplete() {
        return currentSpotIndex == spots.size() - 1;
    }

    public List<Position> generateFootprintPath() {
        if (getCurrentSpot() == null || getNextSpot() == null) {
            return new ArrayList<>();
        }
        return getCurrentSpot().getPosition().generateFootprintPath(getNextSpot().getPosition(), 5);
    }

    public static class TrackingSpot {
        private final String id;
        private final Position position;

        public TrackingSpot(String id, Position position) {
            this.id = id;
            this.position = position;
        }

        public String getId() {
            return id;
        }

        public Position getPosition() {
            return position;
        }
    }

    public static HerbiboarPath generateRandomPath() {
        List<TrackingSpot> randomPath = new ArrayList<>();
        String currentSpot = getRandomStartingSpot();
        
        while (randomPath.size() < 3) { // Herbiboar paths typically have 3 spots
            randomPath.add(new TrackingSpot(currentSpot, TRACKING_SPOTS.get(currentSpot)));
            
            List<String> options = PATH_OPTIONS.get(currentSpot);
            if (options == null || options.isEmpty()) {
                break; // End of path
            }
            
            currentSpot = options.get(new Random().nextInt(options.size()));
        }
        
        return new HerbiboarPath(randomPath);
    }

    private static String getRandomStartingSpot() {
        List<String> startingSpots = Arrays.asList("A", "B", "C", "D", "E");
        return startingSpots.get(new Random().nextInt(startingSpots.size()));
    }
}
