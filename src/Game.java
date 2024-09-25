public class Game {
    private Player playerA;
    private Player playerB;
    private Player currentPlayer;
    public Game(int battlefieldSize) {
        BattleField battlefieldA = new BattleField(battlefieldSize);
        BattleField battlefieldB = new BattleField(battlefieldSize);

        playerA = new Player("PlayerA", battlefieldA);
        playerB = new Player("PlayerB", battlefieldB);
        currentPlayer = playerA;  // PlayerA always starts
    }

    public void addShip(String id, int size, int xA, int yA, int xB, int yB) {
        Ship shipA = new Ship(id, size, xA, yA);
        Ship shipB = new Ship(id, size, xB, yB);

        playerA.getBattleField().addShip(shipA);
        playerB.getBattleField().addShip(shipB);
    }
    public void startGame() {
        while (!isGameOver()) {
            currentPlayer.fireMissile(getOpponent(currentPlayer));
            currentPlayer = getOpponent(currentPlayer);
        }
        System.out.println(currentPlayer.getName() + " wins!");
    }

    private Player getOpponent(Player player) {
        return player == playerA ? playerB : playerA;
    }

    private boolean isGameOver() {
        return playerA.hasLost() || playerB.hasLost();
    }
}
