public class HerbDropTable {
    private static final Map<String, Integer> HERB_WEIGHTS = new HashMap<>();
    static {
        HERB_WEIGHTS.put("Guam", 100);
        HERB_WEIGHTS.put("Marrentill", 90);
        // ... other herbs with their weights
    }

    public static String getRandomHerb() {
        // Implement weighted random selection
    }
}
