package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Connect4 {
    public static void main(String[] args) {
        Grid grid = new Grid(6, 7);
        Game game = new Game(grid, 4, 1);
        game.play();
    }
}

enum GridPosition {
    EMPTY, RED, YELLOW
}

class Grid {
    private int rows;
    private int cols;
    private int[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initGrid();
    }

    public void initGrid() {
        this.grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = GridPosition.EMPTY.ordinal();
            }
        }
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public int getColumnCount() {
        return this.cols;
    }

    public int placePiece(int column, GridPosition piece) {
        if (column < 0 || column >= this.cols)
            throw new Error("Invalid Column");

        if (piece.equals(GridPosition.EMPTY))
            throw new Error("Invalid Piece");

        for (int row = this.rows - 1; row >= 0; row--) {
            if (this.grid[row][column] == GridPosition.EMPTY.ordinal()) {
                this.grid[row][column] = piece.ordinal();
                return row;
            }
        }

        return -1;
    }

    public boolean checkIfWon(int connectN, int row, int col, GridPosition piece) {
        int count = 0;

        // horizontal
        for (int c = 0; c < this.cols; c++) {
            if (this.grid[row][c] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
        }

        // vertical
        count = 0;
        for (int r = 0; r < this.rows; r++) {
            if (this.grid[r][col] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
        }

        // \ diagonally
        count = 0;
        for (int r = 0; r < this.rows; r++) {
            int c = row + col - r;  // checks \ diagonally
            if (c >= 0 && c < this.cols && this.grid[r][c] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
        }

        // / diagonally
        count = 0;
        for (int r = 0; r < this.rows; r++) {
            int c = col - row + r; // checks / diagonally
            if (c >= 0 && c < this.cols && this.grid[r][c] == piece.ordinal())
                count++;
            else
                count = 0;

            if (count == connectN)
                return true;
        }

        return false;
    }
}

class Player {
    private String name;
    private GridPosition piece;

    public Player(String name, GridPosition piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public GridPosition getPieceColor() {
        return piece;
    }
}

class Game {
    static Scanner input = new Scanner(System.in);
    private Grid grid;
    private int connectN;
    private Player[] players;
    private Map<String, Integer> score;
    private int targetScore;

    public Game(Grid grid, int connectN, int targetScore) {
        this.grid = grid;
        this.connectN = connectN;
        this.targetScore = targetScore;

        this.players = new Player[]{
                new Player("Player1", GridPosition.RED),
                new Player("Player2", GridPosition.YELLOW)
        };

        this.score = new HashMap<>();
        for (Player player : this.players)
            this.score.put(player.getName(), 0);

    }

    private void printBoard() {
        System.out.println("Board: ");

        int[][] grid = this.grid.getGrid();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int piece : grid[i]) {
                if (piece == GridPosition.EMPTY.ordinal())
                    row.append("0 ");
                else if (piece == GridPosition.RED.ordinal())
                    row.append("1 ");
                else
                    row.append("2 ");
            }
            System.out.println(row);
        }
        System.out.println();
    }

    private int[] playMove(Player player) {
        printBoard();
        System.out.println(player.getName() + "'s turn: ");
        int colCount = this.grid.getColumnCount();

        System.out.print("Enter column between 0 & " + (colCount - 1) + " to add piece: ");
        int moveColumn = input.nextInt();
        int moveRow = this.grid.placePiece(moveColumn, player.getPieceColor());
        return new int[]{moveRow, moveColumn};
    }

    private Player playRound() {
        while (true) {
            for (Player player : this.players) {
                int[] pos = playMove(player);
                int row = pos[0];
                int col = pos[1];
                GridPosition pieceColor = player.getPieceColor();
                if (this.grid.checkIfWon(this.connectN, row, col, pieceColor)) {
                    this.score.put(player.getName(), this.score.get(player.getName()) + 1);
                    return player;
                }
            }
        }
    }

    public void play() {
        int maxScore = 0;
        Player winner = null;
        while (maxScore < this.targetScore) {
            winner = playRound();
            printBoard();
            System.out.println(winner.getName() + " won the Round. Congratulations!!!");
            maxScore = Math.max(maxScore, this.score.get(winner.getName()));

            this.grid.initGrid();
        }

        System.out.println(winner.getName() + " won the GAME. Congratulations!!!");
    }
}

