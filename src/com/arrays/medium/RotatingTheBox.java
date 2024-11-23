package com.arrays.medium;

// https://leetcode.com/problems/rotating-the-box/description/
public class RotatingTheBox {

    public static void main(String[] args) {
        char[][] box = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };

        char[][] result = solve(box);
        print(result);

    }

    private static void print(char[][] result) {
        for (char[] rows : result) {
            for (char ele : rows) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static char[][] solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        char[][] result = new char[n][m];

        int col = 0;
        for (int i = m - 1; i >= 0; i--) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                result[row++][col] = grid[i][j];
            }
            col++;
        }

        print(result);
        System.out.println();

        for (col = 0; col < m; col++) {
            int obstacle = n;
            int empty = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                switch (result[row][col]) {
                    case '*':
                        obstacle = row;
                        empty = obstacle - 1;
                        break;
                    case '#':
                        if (row == n-1 || row == empty) {
                            empty = row-1;
                        }
                        else if (obstacle > empty) {
                            result[empty][col] = '#';
                            result[row][col] = '.';
                            empty = empty - 1;
                        }
                }

            }
        }

        return result;
    }
}