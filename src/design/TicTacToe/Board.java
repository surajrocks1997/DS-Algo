package design.TicTacToe;

import java.util.Arrays;

public class Board {
    int m;
    int n;
    char[][] grid;
    int isFull;

    public Board() {
        this.m = 3;
        this.n = 3;
        this.isFull = m * n;
        this.grid = new char[m][n];
        initialize(grid);
    }

    private void initialize(char[][] grid) {
        for (char[] rows : grid)
            Arrays.fill(rows, '.');
    }

    public void move(int row, int col, Player p) {
        if (grid[row][col] != '.')
            throw new IllegalArgumentException("Invalid move");

        grid[row][col] = p.identity;
        isFull--;
    }

    public boolean isFull() {
        return isFull == 0;
    }

    public boolean checkIfWon(int row, int col, Player p) {
        int tRow = row;
        int tCol = col;
        boolean won = true;

        // check horizontally
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != p.identity) {
                won = false;
                break;
            }
        }

        if (won) return won;

        // check vertically
        won = true;
        for (int i = 0; i < m; i++) {
            if (grid[i][col] != p.identity) {
                won = false;
            }
        }
        if (won) return won;

        //check diagonally
        if (grid[1][1] == p.identity) {
            if ((grid[0][0] == p.identity && grid[2][2] == p.identity) ||
                    grid[2][0] == p.identity && grid[0][2] == p.identity) {
                return true;
            }
        }

        return false;
    }

    public void printCurrentState() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void resetMove(int row, int col) {
        grid[row][col] = '.';
        isFull++;
    }
}
