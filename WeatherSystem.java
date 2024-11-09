public class WeatherSystem {
    private static Weather currentWeather = Weather.CLEAR;

    public enum Weather {
        CLEAR, RAINY, WINDY
    }

    public static void setWeather(Weather weather) {
        currentWeather = weather;
    }

    public static double getTrackingModifier() {
        switch (currentWeather) {
            case RAINY: return 0.9; // Harder to track
            case WINDY: return 1.1; // Easier to track
            default: return 1.0;
        }
    }
}
