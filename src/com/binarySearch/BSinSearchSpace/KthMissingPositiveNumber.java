package com.binarySearch.BSinSearchSpace;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        int result = solve(arr, k);
        System.out.println(result);
    }

    private static int solve(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if(missing < k)
                low = mid+ 1;
            else
                high = mid - 1;
        }
        return low + k;
    }
}
