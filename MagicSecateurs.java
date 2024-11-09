package io.ruin.model.content;

import io.ruin.model.entity.player.Player;

public class MagicSecateurs {
    public static final int MAGIC_SECATEURS_ID = 7409;

    public static boolean hasMagicSecateurs(Player player) {
        return player.getInventory().contains(MAGIC_SECATEURS_ID) || 
               player.getEquipment().hasId(MAGIC_SECATEURS_ID);
    }

    public static int getHerbBonus(Player player, int baseHerbCount) {
        if (hasMagicSecateurs(player)) {
            return (int) Math.ceil(baseHerbCount * 1.1);
        }
        return baseHerbCount;
    }
}
