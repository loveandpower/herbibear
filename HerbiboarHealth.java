public class HerbiboarHealth {
    private int currentHealth;
    private static final int MAX_HEALTH = 100;

    public HerbiboarHealth() {
        this.currentHealth = MAX_HEALTH;
    }

    public void damage(int amount) {
        currentHealth = Math.max(0, currentHealth - amount);
    }

    public boolean isDead() {
        return currentHealth <= 0;
    }
}
