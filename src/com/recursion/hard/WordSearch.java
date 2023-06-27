package com.recursion.hard;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABFD";
        boolean result = solve(board, word);
        System.out.println(result);
    }

    private static boolean solve(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[] delRow = {+1, 0, 0, -1};
        int[] delCol = {0, -1, +1, 0};
        int[][] visited = new int[m][n];
        int charAt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(charAt) && solve(m, n, i, j, delRow, delCol, visited, charAt, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean solve(int m, int n, int row, int col, int[] delRow, int[] delCol, int[][] visited, int charAt, char[][] board, String word) {
        visited[row][col] = 1;
        if (word.length() - 1 == charAt) {
            return true;
        }
        charAt++;
        for (int k = 0; k < 4; k++) {
            int nextRow = row + delRow[k];
            int nextCol = col + delCol[k];
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && visited[nextRow][nextCol] == 0 && board[nextRow][nextCol] == word.charAt(charAt)) {
                if (solve(m, n, nextRow, nextCol, delRow, delCol, visited, charAt, board, word)) {
                    return true;
                }
            }
        }
        visited[row][col] = 0;
        return false;
    }
}
