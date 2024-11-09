package io.ruin.model.content;

public class HerbiboarAnimations {
    public static final int TRACKING_ANIMATION = 1234; // Animation for tracking the Herbiboar
    public static final int CATCHING_ANIMATION = 5678; // Animation for catching the Herbiboar
    public static final int HARVESTING_ANIMATION = 6789; // Animation for harvesting herbs from the Herbiboar
    public static final int FOOTPRINT_ANIMATION = 2345; // Optional animation for displaying footprints
    public static final int STUNNED_ANIMATION = 3456; // Animation for when the Herbiboar is stunned

    // Additional animations can be added here as needed
    public static final int IDLE_ANIMATION = 1111; // Idle animation when waiting
    public static final int RUNNING_ANIMATION = 2222; // Running animation when moving quickly

    // Method to retrieve an animation based on action type
    public static int getAnimationForAction(String action) {
        switch (action.toLowerCase()) {
            case "track":
                return TRACKING_ANIMATION;
            case "catch":
                return CATCHING_ANIMATION;
            case "harvest":
                return HARVESTING_ANIMATION;
            case "footprint":
                return FOOTPRINT_ANIMATION;
            case "stun":
                return STUNNED_ANIMATION;
            case "idle":
                return IDLE_ANIMATION;
            case "run":
                return RUNNING_ANIMATION;
            default:
                return -1; // Invalid action
        }
    }
}
