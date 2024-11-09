public class Herbiboar {
    private HerbiboarTrait trait;
    private int stepsRemaining;

    public Herbiboar() {
        this.trait = HerbiboarTrait.getRandomTrait();
        this.stepsRemaining = trait.getSteps();
    }

    public boolean move() {
        if (stepsRemaining > 0) {
            stepsRemaining--;
            return true;
        }
        return false;
    }

    public boolean attemptCatch(Player player) {
        return trait.attemptCatch(player);
    }
}

public class HerbiboarHunting {
    public void hunt(Player player, Herbiboar herbiboar) {
        while (herbiboar.move()) {
            // Logic for each step (e.g., leaving tracks, updating position)
        }
        
        if (herbiboar.attemptCatch(player)) {
            player.sendMessage("You successfully catch the Herbiboar!");
            // Handle successful catch (give XP, items, etc.)
        } else {
            player.sendMessage("The Herbiboar escapes!");
            // Handle failed catch
        }
    }
}
