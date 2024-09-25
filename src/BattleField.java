import java.util.HashMap;
import java.util.Map;

public class BattleField {
    private int gridSize;
    private char[][] grid;
    private Map<String, Ship> ships;
    public BattleField(int battlefieldSize) {
        this.gridSize = battlefieldSize;
        this.grid = new char[battlefieldSize][battlefieldSize];
        this.ships = new HashMap<>();
        initializeGrid();
    }
    public int getGridSize() {
        return gridSize;
    }

    private void initializeGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public boolean addShip(Ship ship) {
        if (isValidPlacement(ship)) {
            ships.put(ship.getId(), ship);
            markShipOnGrid(ship);
            return true;
        }
        return false;
    }

    private boolean isValidPlacement(Ship ship) {
        for (int[] coordinate : ship.getCoordinates()) {
            int x = coordinate[0];
            int y = coordinate[1];
            if (x >= gridSize || y >= gridSize || grid[x][y] != '.') {
                return false;
            }
        }
        return true;
    }
    private void markShipOnGrid(Ship ship) {
        for (int[] coordinate : ship.getCoordinates()) {
            int x = coordinate[0];
            int y = coordinate[1];
            grid[x][y] = 'S';
        }
    }

    public boolean missileHit(int x, int y) {
        if (grid[x][y] == 'S') {
            grid[x][y] = 'X';  // Hit the ship
            Ship hitShip = findHitShip(x, y);
            if (hitShip != null) {
                checkIfShipDestroyed(hitShip);
            }
            return true;
        } else {
            grid[x][y] = 'O';  // Miss
            return false;
        }
    }

    private Ship findHitShip(int x, int y) {
        for (Ship ship : ships.values()) {
            for (int[] coordinate : ship.getCoordinates()) {
                if (coordinate[0] == x && coordinate[1] == y) {
                    return ship;
                }
            }
        }
        return null;
    }

    private void checkIfShipDestroyed(Ship ship) {
        boolean allHit = true;
        for (int[] coordinate : ship.getCoordinates()) {
            if (grid[coordinate[0]][coordinate[1]] != 'X') {
                allHit = false;
                break;
            }
        }
        if (allHit) {
            ship.setDestroyed(true);
            System.out.println("Ship " + ship.getId() + " is destroyed!");
        }
    }

    public boolean allShipsDestroyed() {
        for (Ship ship : ships.values()) {
            if (!ship.isDestroyed()) {
                return false;
            }
        }
        return true;
    }
}
