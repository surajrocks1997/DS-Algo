package com.recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens_Optimized {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solve(n);
        System.out.println(result);
    }

    private static List<List<String>> solve(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[(2 * n) - 1];
        int[] lowerDiagonal = new int[(2 * n) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, board, result, leftRow, upperDiagonal, lowerDiagonal);

        return result;
    }

    private static void solve(int col, char[][] board, List<List<String>> result, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if (col >= board.length) {
            result.add(boardToList(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + (col - row)] == 0) {
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + (col - row)] = 1;
                board[row][col] = 'Q';
                solve(col + 1, board, result, leftRow, upperDiagonal, lowerDiagonal);
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + (col - row)] = 0;
                board[row][col] = '.';
            }
        }
    }

    private static List<String> boardToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}
