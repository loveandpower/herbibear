package io.ruin.model.content;

import java.util.Random;

public class HerbiboarTrait {
    private static final Random RANDOM = new Random();

    private final String name;
    private final int minSteps;
    private final int maxSteps;

    public static final HerbiboarTrait STANDARD = new HerbiboarTrait("Standard", 3, 5);
    public static final HerbiboarTrait QUICK = new HerbiboarTrait("Quick", 4, 6);
    public static final HerbiboarTrait SLUGGISH = new HerbiboarTrait("Sluggish", 2, 4);

    private HerbiboarTrait(String name, int minSteps, int maxSteps) {
        this.name = name;
        this.minSteps = minSteps;
        this.maxSteps = maxSteps;
    }

    public String getName() {
        return name;
    }

    public int getSteps() {
        return RANDOM.nextInt(maxSteps - minSteps + 1) + minSteps;
    }

    public static HerbiboarTrait getRandomTrait() {
        double roll = RANDOM.nextDouble();
        if (roll < 0.2) return QUICK;
        if (roll < 0.4) return SLUGGISH;
        return STANDARD;
    }

    public static double calculateCatchChance(int hunterLevel) {
        // Base catch chance starts at 65% at level 80
        double baseChance = 0.65;
        
        // Increase by 1% for every level above 80, up to 95% at level 99
        if (hunterLevel > 80) {
            baseChance += Math.min((hunterLevel - 80) * 0.01, 0.30);
        }
        
        return Math.min(baseChance, 0.95);
    }

    public boolean attemptCatch(Player player) {
        int hunterLevel = player.getStats().get(StatType.Hunter).currentLevel;
        double catchChance = calculateCatchChance(hunterLevel);
        return RANDOM.nextDouble() < catchChance;
    }
}
