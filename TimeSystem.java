public class TimeSystem {
    private static int currentHour = 0;

    public static void updateTime() {
        currentHour = (currentHour + 1) % 24;
    }

    public static double getHerbiboarActivityModifier() {
        if (currentHour >= 6 && currentHour < 18) {
            return 1.0; // Normal activity during day
        } else {
            return 0.7; // Reduced activity at night
        }
    }
}
