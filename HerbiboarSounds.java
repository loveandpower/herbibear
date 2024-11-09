package io.ruin.model.content;

import io.ruin.model.entity.player.Player;
import io.ruin.model.map.Position;

public class HerbiboarSounds {
    // Tracking sounds
    public static final int TRACK_FOUND_SOUND = 3120;
    public static final int FOOTPRINTS_FOUND_SOUND = 3121;
    public static final int INVESTIGATE_OBJECT_SOUND = 3123;
    public static final int DISTURB_OBJECT_SOUND = 3124;

    // Herbiboar sounds
    public static final int HERBIBOAR_STARTLED_SOUND = 3122;
    public static final int HERBIBOAR_CAUGHT_SOUND = 3125;

    // Harvesting sounds
    public static final int HARVEST_HERB_SOUND = 3126;

    // Environment sounds
    public static final int RUSTLING_LEAVES_SOUND = 3127;
    public static final int BIRD_CHIRP_SOUND = 3128;
    public static final int WIND_SOUND = 3129;

    // Player action sounds
    public static final int PLAYER_STEP_SOUND = 3130;
    public static final int PLAYER_BREATHING_SOUND = 3131;

    // Tool sounds
    public static final int NOOSE_WAND_SWING_SOUND = 3132;
    public static final int HERB_SACK_OPEN_SOUND = 3133;

    // Misc sounds
    public static final int LEVEL_UP_SOUND = 3134;
    public static final int FAIL_SOUND = 3135;

    /**
     * Plays a sound for a player.
     * @param player The player to play the sound for
     * @param soundId The ID of the sound to play
     */
    public static void playSound(Player player, int soundId) {
        player.getPacketSender().sendSound(soundId, 0, 0);
    }

    /**
     * Plays a sound for all players in the vicinity of a position.
     * @param position The position to play the sound at
     * @param soundId The ID of the sound to play
     * @param distance The maximum distance at which players can hear the sound
     */
    public static void playSoundAtPosition(Position position, int soundId, int distance) {
        for (Player p : position.getRegion().getPlayers()) {
            if (p.getPosition().isWithinDistance(position, distance)) {
                playSound(p, soundId);
            }
        }
    }
}
