package io.ruin.model.map;

public class FossilIslandManager {
    public static final int HERBIBOAR_REGION_ID = 14652; // Actual OSRS region ID

    public static boolean isInHerbiboarArea(int x, int y, int plane) {
        return x >= 3680 && x <= 3711 && y >= 3871 && y <= 3903 && plane == 0;
    }

    public static boolean isInHerbiboarArea(Position position) {
        return isInHerbiboarArea(position.getX(), position.getY(), position.getZ());
    }

    public static boolean isInHerbiboarArea(Entity entity) {
        return isInHerbiboarArea(entity.getPosition());
    }

    // You can add more methods here related to Fossil Island or Herbiboar hunting as needed.
}
