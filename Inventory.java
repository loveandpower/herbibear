package io.ruin.model.item.containers;

import io.ruin.model.entity.player.Player;
import io.ruin.model.item.Item;
import io.ruin.cache.ItemDef;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static final int MAX_SIZE = 28;
    private final Player player;
    private final Item[] items;

    public Inventory(Player player) {
        this.player = player;
        this.items = new Item[MAX_SIZE];
    }

    public boolean contains(String itemName) {
        for (Item item : items) {
            if (item != null && item.getDef().name.equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(int itemId) {
        for (Item item : items) {
            if (item != null && item.getId() == itemId) {
                return true;
            }
        }
        return false;
    }

    public void add(String itemName, int amount) {
        int itemId = ItemDef.getIdByName(itemName);
        if (itemId == -1) {
            System.err.println("Invalid item name: " + itemName);
            return;
        }
        add(itemId, amount);
    }

    public void add(int itemId, int amount) {
        Item item = new Item(itemId, amount);
        int freeSlot = getFreeSlot();
        if (freeSlot == -1) {
            player.sendMessage("Not enough space in your inventory.");
            return;
        }
        items[freeSlot] = item;
        refresh();
    }

    public void remove(String itemName, int amount) {
        int itemId = ItemDef.getIdByName(itemName);
        if (itemId == -1) {
            System.err.println("Invalid item name: " + itemName);
            return;
        }
        remove(itemId, amount);
    }

    public void remove(int itemId, int amount) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == itemId) {
                if (items[i].getAmount() > amount) {
                    items[i].incrementAmount(-amount);
                } else {
                    items[i] = null;
                }
                refresh();
                return;
            }
        }
    }

    public int getFreeSlot() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int getCount(int itemId) {
        int count = 0;
        for (Item item : items) {
            if (item != null && item.getId() == itemId) {
                count += item.getAmount();
            }
        }
        return count;
    }

    public boolean hasSpace() {
        return getFreeSlot() != -1;
    }

    public void refresh() {
        player.getPacketSender().sendItems(-1, 64207, 93, items);
    }

    public Item[] getItems() {
        return items;
    }
}
