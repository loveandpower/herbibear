public class NPC {
    private int id;
    private int x, y, z;

    public NPC(int id, int x, int y, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void faceEntity(Player player) {
        // Code to make the NPC face the player
    }

    public int getId() {
        return id;
    }
}
