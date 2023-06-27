package com.binarySearch.Two_D;

import java.util.Arrays;

public class PeakElement {
    public static void main(String[] args) {
        int[][] arr = {
                {30, 41, 24, 11, 24},
                {23, 14, 43, 18, 45},
                {44, 42, 5, 39, 41},
                {11, 35, 47, 16, 11},
                {30, 25, 18, 41, 45}
        };
        int[] res = solve(arr);
        Arrays.stream(res).forEach(ele -> System.out.print(ele + " "));
    }

//    code not working
    private static int[] solve(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = (m * n) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            int ele = arr[row][col];

            if (check(arr, row, col, ele)) return new int[]{row, col};

            if (arr[(mid - 1) / n][(mid - 1) % n] >= ele) high = mid - 1;
            else low = mid + 1;

        }
        return new int[]{-1, -1};
    }

    private static boolean check(int[][] arr, int row, int col, int ele) {
        return ele > (row - 1 > 0 ? arr[row - 1][col] : -1) && ele > (row + 1 < arr.length ? arr[row + 1][col] : -1)
                && ele > (col - 1 > 0 ? arr[row][col - 1] : -1) && ele > (col + 1 < arr[0].length ? arr[row][col + 1] : -1);
    }
}
