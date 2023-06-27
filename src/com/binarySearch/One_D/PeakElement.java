package com.binarySearch.One_D;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        if (arr.length == 1) return 0;

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid == 0) return arr[0] >= arr[1] ? 0 : 1;

            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) return mid;
            if (arr[mid] < arr[mid - 1]) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}
