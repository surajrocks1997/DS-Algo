package com.binarySearch.One_D;

public class SearchEleRotatedArray {
    public static void main(String[] args) {
        int[] arr = {1,3};
        int target = 4;

        int result = solve(arr, target);
        System.out.println(result);
    }

    private static int solve(int[] arr, int target) {
        if(arr.length == 1 && target == arr[0]) return 0;

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;

//            check if left part is sorted or not, and if yes, whether target lies in that range.
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target <= arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid + 1] <= arr[high]) {
                if (target >= arr[mid + 1] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return -1;
    }
}
