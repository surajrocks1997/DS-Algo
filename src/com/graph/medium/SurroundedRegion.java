package com.graph.medium;

public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };

        solve(board);
        for (char[] row : board) {
            for (char ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }

    private static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            if (vis[0][i] == 0 && board[0][i] == 'O')
                dfs(0, i, m, n, vis, board, delrow, delcol);

            if (vis[m - 1][i] == 0 && board[m - 1][i] == 'O')
                dfs(m - 1, i, m, n, vis, board, delrow, delcol);
        }

        for (int i = 0; i < m; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O')
                dfs(i, 0, m, n, vis, board, delrow, delcol);

            if (vis[i][n - 1] == 0 && board[i][n - 1] == 'O')
                dfs(i, n - 1, m, n, vis, board, delrow, delcol);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0)
                    board[i][j] = 'X';
            }
        }
    }

    private static void dfs(int row, int col, int m, int n, int[][] vis, char[][] board, int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                    vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O')
                dfs(nrow, ncol, m, n, vis, board, delrow, delcol);
        }
    }
}
