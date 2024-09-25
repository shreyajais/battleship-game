import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        //System.out.println("Hello Game");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter battlefield size: ");
        int battlefieldSize = scanner.nextInt();

        Game game = new Game(battlefieldSize);

        // Adding ships for demonstration
        game.addShip("SH1", 2, 0, 0, battlefieldSize/2, 0);
        game.addShip("SH2", 3, 1, 1, battlefieldSize/2 + 1, 1);

        // Start the game
        game.startGame();
    }
}
