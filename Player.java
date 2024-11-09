public class Player {
    private Skills skills;
    private Inventory inventory;
    private int x, y, z;
    private HerbiboarHunting herbiboarHunting;

    public void sendMessage(String message) {
        // Code to send a message to the player
    }

    public Skills getSkills() {
        return skills;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setHerbiboarHunting(HerbiboarHunting hunting) {
        this.herbiboarHunting = hunting;
    }

    public HerbiboarHunting getHerbiboarHunting() {
        return herbiboarHunting;
    }
}
