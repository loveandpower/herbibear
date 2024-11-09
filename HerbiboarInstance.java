public class HerbiboarInstance {
    private final Player player;
    private final HerbiboarHunting hunting;

    public HerbiboarInstance(Player player) {
        this.player = player;
        this.hunting = new HerbiboarHunting(player);
    }

    // Methods to manage this player's Herbiboar hunting instance
}
