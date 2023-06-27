package com.binarySearch.One_D;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 1};
        int min = solve(arr);
        System.out.println(min);
    }

    private static int solve(int[] arr) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            if (arr[low] <= arr[high]) return Math.min(min, arr[low]);

            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }

        return min;
    }
}
