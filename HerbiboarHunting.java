import java.util.*;

public class HerbiboarHunting {
    private static final int MIN_HUNTER_LEVEL = 80;
    private static final int MIN_HERBLORE_LEVEL = 31;
    public static final int HERBIBOAR_NPC_ID = 7786;
    private static final Random random = new Random();

    private Player player;
    private int tracksFound;
    private boolean herbiboarFound;
    private String currentTrackingSpot;
    private NPC herbiboarNPC;
    private List<String> currentPath;

    public HerbiboarHunting(Player player) {
        this.player = player;
        resetHunt();
    }

    public void handleObjectClick(int objectId) {
        if (!TrackingData.TRACKING_SPOTS.containsKey(objectId)) {
            player.sendMessage("This isn't a Herbiboar tracking spot.");
            return;
        }

        if (player.getSkills().getLevel(Skills.HUNTER) < MIN_HUNTER_LEVEL) {
            player.sendMessage("You need at least 80 Hunter to track Herbiboar.");
            return;
        }

        String clickedSpot = TrackingData.TRACKING_SPOTS.get(objectId);
        if (clickedSpot.equals(currentTrackingSpot)) {
            tracksFound++;
            player.sendMessage("You find Herbiboar tracks! (" + tracksFound + "/3)");
            if (tracksFound == 3) {
                herbiboarFound = true;
                player.sendMessage("You've found the Herbiboar! Click on it to attempt to catch it.");
                spawnHerbiboar();
            } else {
                currentTrackingSpot = getNextTrackingSpot();
                currentPath.add(currentTrackingSpot);
                player.sendMessage("The tracks lead to a " + currentTrackingSpot + ".");
            }
        } else {
            player.sendMessage("You search the " + clickedSpot + " but find no tracks.");
            if (random.nextDouble() < 0.1) { // 10% chance to fail tracking
                player.sendMessage("The creature has successfully confused you with its tracks, leading you round in circles. You'll need to start again.");
                resetHunt();
            }
        }
    }

    public void handleHerbiboarClick() {
        if (!herbiboarFound) {
            player.sendMessage("You need to find the Herbiboar first!");
            return;
        }

        if (catchHerbiboar()) {
            player.sendMessage("You successfully catch the Herbiboar!");
            harvestHerbs();
        } else {
            player.sendMessage("The Herbiboar escapes!");
            resetHunt();
        }
    }

    private boolean catchHerbiboar() {
        int hunterLevel = player.getSkills().getLevel(Skills.HUNTER);
        double catchChance = Math.min((hunterLevel - 80) * 0.01 + 0.7, 0.95);
        return random.nextDouble() < catchChance;
    }

    private void harvestHerbs() {
        int herbloreLevel = player.getSkills().getLevel(Skills.HERBLORE);
        if (herbloreLevel < MIN_HERBLORE_LEVEL) {
            player.sendMessage("You need at least 31 Herblore to harvest herbs from Herbiboar.");
            resetHunt();
            return;
        }

        boolean hasMagicSecateurs = player.getInventory().contains("Magic secateurs");
        int herbCount = hasMagicSecateurs ? random.nextInt(2, 5) : random.nextInt(1, 4);

        for (int i = 0; i < herbCount; i++) {
            String herb = TrackingData.HERBS.get(random.nextInt(TrackingData.HERBS.size()));
            player.getInventory().add(herb, 1);
            player.sendMessage("You harvest: " + herb);
        }

        int xpGained = XPCalculator.calculateHunterXP(player.getSkills().getLevel(Skills.HUNTER));
        player.getSkills().addXp(Skills.HUNTER, xpGained);
        player.sendMessage("You gain " + xpGained + " Hunter XP.");

        if (random.nextDouble() < 1.0/6500) {
            player.getInventory().add("Herbi", 1);
            player.sendMessage("You have a funny feeling you're being followed...");
        }

        resetHunt();
    }

    private void resetHunt() {
        tracksFound = 0;
        herbiboarFound = false;
        currentTrackingSpot = getRandomStartingSpot();
        currentPath = new ArrayList<>();
        currentPath.add(currentTrackingSpot);
        despawnHerbiboar();
    }

    private String getRandomStartingSpot() {
        List<String> startingSpots = Arrays.asList("A", "B", "C", "D", "E");
        return startingSpots.get(random.nextInt(startingSpots.size()));
    }

    private String getNextTrackingSpot() {
        List<String> possibleSpots = TrackingData.TRACKING_PATHS.get(currentTrackingSpot);
        return possibleSpots.get(random.nextInt(possibleSpots.size()));
    }

    private void spawnHerbiboar() {
        if (herbiboarNPC != null) {
            despawnHerbiboar();
        }
        
        int x = player.getX() + random.nextInt(5) - 2;
        int y = player.getY() + random.nextInt(5) - 2;
        
        herbiboarNPC = new NPC(HERBIBOAR_NPC_ID, x, y, player.getZ());
        World.spawnNPC(herbiboarNPC);
        herbiboarNPC.faceEntity(player);
    }

    private void despawnHerbiboar() {
        if (herbiboarNPC != null) {
            World.removeNPC(herbiboarNPC);
            herbiboarNPC = null;
        }
    }
}
