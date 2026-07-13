package design.TicTacToe;

import java.util.Scanner;
import java.util.Stack;

public class TicTacToeMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to tic-tac-toe!");

        Stack<Tuple> lastMove = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player1 Name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Player2 Name: ");
        String player2Name = scanner.nextLine();
        Game game = new Game(new Player(player1Name), new Player(player2Name));

        while (true) {
            game.printCurrentState();
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn");
            System.out.println("Enter row and col index with space between 0 and 2: ");
            String input = scanner.nextLine();
            if (input.equals("UNDO")) {
                Tuple resetMove = lastMove.pop();
                game.resetMove(resetMove.row, resetMove.col);
                continue;
            }

            String[] data = input.split(" ");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);

            try {
                game.move(row, col, currentPlayer);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input, please try again");
                continue;
            }
            if (game.gameState != GameState.playing) {
                if (game.gameState == GameState.draw) {
                    System.out.println("Draw");
                    game.printCurrentState();
                    break;
                }
                if (game.gameState == GameState.won) {
                    System.out.println(currentPlayer.getName() + " WON! Congratulations!");
                    game.printCurrentState();
                    break;
                }
            }
            lastMove.push(new Tuple(row, col));
        }
    }
}

class Tuple {
    int row, col;

    public Tuple(int row, int col) {
        this.row = row;
        this.col = col;

    }
}