package io.ruin.model.content;

import java.util.*;

public class HerbDropTable {
    private static final Map<String, Double> HERB_WEIGHTS = new HashMap<>();
    
    static {
        HERB_WEIGHTS.put("Guam", 0.15);
        HERB_WEIGHTS.put("Marrentill", 0.14);
        HERB_WEIGHTS.put("Tarromin", 0.12);
        HERB_WEIGHTS.put("Harralander", 0.10);
        HERB_WEIGHTS.put("Ranarr", 0.09);
        HERB_WEIGHTS.put("Toadflax", 0.08);
        HERB_WEIGHTS.put("Irit", 0.07);
        HERB_WEIGHTS.put("Avantoe", 0.06);
        HERB_WEIGHTS.put("Kwuarm", 0.05);
        HERB_WEIGHTS.put("Snapdragon", 0.04);
        HERB_WEIGHTS.put("Cadantine", 0.03);
        HERB_WEIGHTS.put("Lantadyme", 0.02);
        HERB_WEIGHTS.put("Dwarf weed", 0.01);
        HERB_WEIGHTS.put("Torstol", 0.005); // Rare drop
    }

    public static List<String> getRandomHerbs(int rollCount) {
        List<String> herbs = new ArrayList<>();
        
        for (int i = 0; i < rollCount; i++) {
            String herb = getRandomHerb();
            if (herb != null) {
                herbs.add(herb);
            }
        }
        
        return herbs;
    }

    public static String getRandomHerb() {
        double totalWeight = HERB_WEIGHTS.values().stream().mapToDouble(Double::doubleValue).sum();
        double randomValue = Math.random() * totalWeight;

        for (Map.Entry<String, Double> entry : HERB_WEIGHTS.entrySet()) {
            randomValue -= entry.getValue();
            if (randomValue <= 0) {
                return entry.getKey();
            }
        }
        
        return null; // Fallback, should not happen
    }
}
