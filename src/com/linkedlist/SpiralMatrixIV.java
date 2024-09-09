package com.linkedlist;

import java.util.Arrays;

// https://leetcode.com/problems/spiral-matrix-iv/description/
public class SpiralMatrixIV {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        int m = 3;
        int n = 5;
        int[][] result = solve(head, m, n);
        for (int[] rows : result) {
            for (int ele : rows)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    private static int[][] solve(ListNode head, int m, int n) {
        int[][] result = new int[m][n];

        for (int[] rows : result)
            Arrays.fill(rows, -1);

        ListNode curr = head;

        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (curr != null) {
            if (endCol >= startCol) {
                for (int col = startCol; col <= endCol; col++) {
                    result[startRow][col] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }
                if (curr == null) break;
                startRow++;
            }


            if (endRow >= startRow) {
                for (int row = startRow; row <= endRow; row++) {
                    result[row][endCol] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }

                if (curr == null) break;
                endCol--;
            }

            if (endCol >= startCol) {
                for (int col = endCol; col >= startCol; col--) {
                    result[endRow][col] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }

                if (curr == null) break;
                endRow--;
            }


            if (endRow >= startRow) {
                for (int row = endRow; row >= startRow; row--) {
                    result[row][startCol] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }

                if (curr == null) break;
                startCol++;
            }
        }

        return result;
    }
}
