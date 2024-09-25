import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Player {
    private String name;
    private BattleField battlefield;
    private Set<String> missileHistory;
    public Player(String name, BattleField battlefield) {
            this.name = name;
            this.battlefield = battlefield;
            this.missileHistory = new HashSet<>();
        }
    public String getName() {
        return name;
    }

    public BattleField getBattleField() {
        return battlefield;
    }
        public boolean fireMissile(Player opponent) {
            int x, y;
            do {
                x = new Random().nextInt(opponent.battlefield.getGridSize());
                y = new Random().nextInt(opponent.battlefield.getGridSize());
            } while (missileHistory.contains(x + "," + y));
            missileHistory.add(x + "," + y);

            boolean hit = opponent.battlefield.missileHit(x, y);
            System.out.println(name + "'s turn: Missile fired at (" + x + ", " + y + "). " + (hit ? "Hit!" : "Miss."));
            return hit;
        }

    public boolean hasLost() {
            return battlefield.allShipsDestroyed();
        }
}
