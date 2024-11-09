public class HerbiboarAchievements {
    private Map<String, Boolean> achievements = new HashMap<>();

    public HerbiboarAchievements() {
        achievements.put("First Catch", false);
        achievements.put("100 Catches", false);
        achievements.put("Rare Herb", false);
        // Add more achievements
    }

    public void checkAndUpdateAchievements(Player player, HerbiboarHunting hunting) {
        // Logic to check and update achievements based on player's actions
    }
}
