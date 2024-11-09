public class FossilIslandManager {
    public static final int HERBIBOAR_REGION_ID = 14652; // Actual OSRS region ID

    public static boolean isInHerbiboarArea(int x, int y, int plane) {
        return x >= 3680 && x <= 3711 && y >= 3871 && y <= 3903 && plane == 0;
    }

    public static boolean isInHerbiboarArea(Coordinate location) {
        return isInHerbiboarArea(location.getX(), location.getY(), location.getPlane());
    }

    // Other Fossil Island related methods
}
