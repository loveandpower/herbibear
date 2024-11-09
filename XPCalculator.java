public class XPCalculator {
    public static int calculateHunterXP(int hunterLevel) {
        if (hunterLevel >= 99) {
            return 2461;
        } else if (hunterLevel >= 95) {
            return 1950 + (hunterLevel - 80) * 17 + (hunterLevel - 94) * 15;
        } else {
            return 1950 + (hunterLevel - 80) * 30;
        }
    }
}
