package com.binarySearch.One_D;

import java.util.Arrays;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {3, 4, 13, 13, 13, 20, 40};
        int k = 13;
        int[] result = solve(arr, k);
        Arrays.stream(result).forEach(res -> System.out.print(res + " "));
    }

    private static int[] solve(int[] arr, int target) {
        int first = -1, last = -1;
        if (arr.length == 0) return new int[]{first, last};
        if (arr.length == 1 && arr[0] == target) return new int[]{0, 0};
        int low = 0;
        int high = arr.length - 1;

        first = firstIndex(arr, target, low, high);
        last = lastIndex(arr, target, low, high);

        return new int[]{first, last};
    }

    private static int lastIndex(int[] arr, int target, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else low = mid + 1;

            if (arr[mid] == target) index = mid;
        }

        return index;
    }

    private static int firstIndex(int[] arr, int target, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                high = mid - 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else low = mid + 1;

            if (arr[mid] == target) index = mid;
        }

        return index;
    }
}
