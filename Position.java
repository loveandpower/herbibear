package io.ruin.model.map;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Position {

    @Expose private int x, y, z;

    private int firstChunkX, firstChunkY;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        updateFirstChunk();
    }

    public void updateFirstChunk() {
        firstChunkX = x >> 3;
        firstChunkY = y >> 3;
    }

    public boolean updateRegion() {
        int diffX = firstChunkX - getChunkX();
        int diffY = firstChunkY - getChunkY();
        int size = Region.CLIENT_SIZE;
        int updateSize = ((size >> 3) / 2) - 1;
        if (Math.abs(diffX) >= updateSize || Math.abs(diffY) >= updateSize) {
            updateFirstChunk();
            return true;
        }
        return false;
    }

    public static Position of(int x, int y) {
        return new Position(x, y, 0);
    }

    public static Position of(int x, int y, int z) {
        return new Position(x, y, z);
    }

    public Position copy() {
        return new Position(x, y, z);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Position translate(int changeX, int changeY, int changeZ) {
        x += changeX;
        y += changeY;
        z += changeZ;
        return this;
    }

    public Position translate(int changeX, int changeY) {
        x += changeX;
        y += changeY;
        return this;
    }

    public Position relative(int changeX, int changeY, int changeZ) {
        return copy().translate(changeX, changeY, changeZ);
    }

    public Position relative(int changeX, int changeY) {
        return relative(changeX, changeY, 0);
    }

    public List<Position> generateFootprintPath(Position target, int steps) {
        List<Position> path = new ArrayList<>();
        
        // Calculate differences
        int dx = target.getX() - x;
        int dy = target.getY() - y;

        for (int i = 1; i <= steps; i++) {
            // Interpolate positions between current and target
            int newX = x + (dx * i / (steps + 1));
            int newY = y + (dy * i / (steps + 1));
            path.add(Position.of(newX, newY, z));
        }
        
        return path;
    }

    // Existing getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    
    // Additional utility methods
    public boolean isWithinDistance(Position other, int distance) {
        return Math.abs(x - other.x) <= distance && Math.abs(y - other.y) <= distance && z == other.z;
    }

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + ", z=" + z + "]";
    }
}
