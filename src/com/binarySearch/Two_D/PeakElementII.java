package com.binarySearch.Two_D;

import java.util.Arrays;

public class PeakElementII {
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
    private static int[] solve(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int rowMax = findMaxRowInCol(mat, mid, m);

            int left = mid - 1 >= 0 ? mat[rowMax][mid - 1] : -1;
            int right = mid + 1 < n ? mat[rowMax][mid + 1] : -1;

            if (mat[rowMax][mid] > left && mat[rowMax][mid] > right)
                return new int[]{rowMax, mid};

            else if (left > mat[rowMax][mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return new int[]{-1, -1};
    }

    private static int findMaxRowInCol(int[][] mat, int col, int m) {
        int max = Integer.MIN_VALUE;
        int row = -1;
        for (int i = 0; i < m; i++) {
            if (mat[i][col] > max) {
                max = Math.max(max, mat[i][col]);
                row = i;
            }
        }

        return row;
    }
}
