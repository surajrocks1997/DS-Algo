package com.binarySearch.One_D;

public class kthElementOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int m = arr1.length;
        int n = arr2.length;
        int k = 5;
        int result = solve(arr1, arr2, m, n, k);
        System.out.println(result);

    }

    private static int solve(int[] arr1, int[] arr2, int m, int n, int k) {
        if (m > n)
            return solve(arr2, arr1, n, m, k);

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return -1;
    }
}
