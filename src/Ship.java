import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String id;
    private int size;
    private List<int[]> coordinates;
    private boolean isDestroyed;

    public Ship(String id, int size, int x, int y) {
        this.id = id;
        this.size = size;
        this.coordinates = calculateCoordinates(x, y);
        this.isDestroyed = false;
    }

    private List<int[]> calculateCoordinates(int x, int y) {
        List<int[]> coords = new ArrayList<>();
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                coords.add(new int[] {i, j});
            }
        }
        return coords;
    }

    public List<int[]> getCoordinates() {
        return coordinates;
    }

    public String getId() {
        return id;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

}
