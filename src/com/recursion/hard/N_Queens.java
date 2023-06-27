package com.recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solve(n);
        System.out.println(result);
    }

    private static List<List<String>> solve(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, board, result);

        return result;
    }

    private static void solve(int col, char[][] board, List<List<String>> result) {
        if (col >= board.length) {
            result.add(boardToList(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isValid(row, col, board)) {
                board[row][col] = 'Q';
                solve(col + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] board) {
        int safeRow = row;
        int safeCol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        col = safeCol;
        row = safeRow;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        col = safeCol;
        row = safeRow;
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    private static List<String> boardToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}
