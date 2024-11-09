import java.util.*;

public class TrackingData {
    public static final Map<Integer, String> TRACKING_SPOTS = new HashMap<>();
    public static final Map<String, List<String>> TRACKING_PATHS = new HashMap<>();
    public static final List<String> HERBS = Arrays.asList(
        "Guam", "Marrentill", "Tarromin", "Harralander", "Ranarr", 
        "Toadflax", "Irit", "Avantoe", "Kwuarm", "Snapdragon", 
        "Cadantine", "Lantadyme", "Dwarf weed", "Torstol"
    );

    static {
        TRACKING_SPOTS.put(30525, "Rock");
        TRACKING_SPOTS.put(30526, "Mushroom");
        TRACKING_SPOTS.put(30527, "Seaweed");
        TRACKING_SPOTS.put(30528, "Mud");

        TRACKING_PATHS.put("A", Arrays.asList("B", "C"));
        TRACKING_PATHS.put("B", Arrays.asList("D", "E"));
        TRACKING_PATHS.put("C", Arrays.asList("F", "G"));
        TRACKING_PATHS.put("D", Arrays.asList("H", "I"));
        TRACKING_PATHS.put("E", Arrays.asList("J", "K"));
        TRACKING_PATHS.put("F", Arrays.asList("L", "M"));
        TRACKING_PATHS.put("G", Arrays.asList("N", "O"));
        TRACKING_PATHS.put("H", Arrays.asList("P", "Q"));
        TRACKING_PATHS.put("I", Arrays.asList("R", "S"));
        TRACKING_PATHS.put("J", Arrays.asList("T", "U"));
        TRACKING_PATHS.put("K", Arrays.asList("V", "W"));
        TRACKING_PATHS.put("L", Arrays.asList("X", "Y"));
        TRACKING_PATHS.put("M", Arrays.asList("Z", "AA"));
        TRACKING_PATHS.put("N", Arrays.asList("AB", "AC"));
        TRACKING_PATHS.put("O", Arrays.asList("AD", "AE"));
    }
}
