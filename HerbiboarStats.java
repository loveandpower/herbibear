package io.ruin.model.content;

import java.util.HashMap;
import java.util.Map;

public class HerbiboarStats {
    private int totalCaught;
    private int failedAttempts;
    private int totalHerbsCollected;
    private Map<String, Integer> herbsCollected;
    private long totalHuntingTime; // in milliseconds
    private long bestCatchTime; // in milliseconds
    private int consecutiveCatches;
    private int maxConsecutiveCatches;

    public HerbiboarStats() {
        this.herbsCollected = new HashMap<>();
        this.bestCatchTime = Long.MAX_VALUE;
    }

    public void incrementCaught() {
        totalCaught++;
        consecutiveCatches++;
        if (consecutiveCatches > maxConsecutiveCatches) {
            maxConsecutiveCatches = consecutiveCatches;
        }
    }

    public void incrementFailed() {
        failedAttempts++;
        consecutiveCatches = 0;
    }

    public void addHerb(String herbName, int amount) {
        herbsCollected.merge(herbName, amount, Integer::sum);
        totalHerbsCollected += amount;
    }

    public void addHuntingTime(long timeInMillis) {
        totalHuntingTime += timeInMillis;
    }

    public void updateBestCatchTime(long timeInMillis) {
        if (timeInMillis < bestCatchTime) {
            bestCatchTime = timeInMillis;
        }
    }

    public int getTotalCaught() {
        return totalCaught;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public int getTotalHerbsCollected() {
        return totalHerbsCollected;
    }

    public Map<String, Integer> getHerbsCollected() {
        return new HashMap<>(herbsCollected);
    }

    public long getTotalHuntingTime() {
        return totalHuntingTime;
    }

    public long getBestCatchTime() {
        return bestCatchTime == Long.MAX_VALUE ? 0 : bestCatchTime;
    }

    public int getConsecutiveCatches() {
        return consecutiveCatches;
    }

    public int getMaxConsecutiveCatches() {
        return maxConsecutiveCatches;
    }

    public double getSuccessRate() {
        int totalAttempts = totalCaught + failedAttempts;
        return totalAttempts > 0 ? (double) totalCaught / totalAttempts : 0;
    }

    public double getAverageHerbsPerCatch() {
        return totalCaught > 0 ? (double) totalHerbsCollected / totalCaught : 0;
    }

    @Override
    public String toString() {
        return "HerbiboarStats{" +
                "totalCaught=" + totalCaught +
                ", failedAttempts=" + failedAttempts +
                ", totalHerbsCollected=" + totalHerbsCollected +
                ", herbsCollected=" + herbsCollected +
                ", totalHuntingTime=" + totalHuntingTime +
                ", bestCatchTime=" + bestCatchTime +
                ", maxConsecutiveCatches=" + maxConsecutiveCatches +
                '}';
    }
}
