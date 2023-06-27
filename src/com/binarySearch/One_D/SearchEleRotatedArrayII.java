package com.binarySearch.One_D;

public class SearchEleRotatedArrayII {
    public static void main(String[] args) {
//        this problem can contain duplicates
//        int[] arr = {1, 0, 1, 1, 1};
        int[] arr = {2, 2, 2, 2, 0, 1, 2};
        int target = 0;

        boolean result = solve(arr, target);
        System.out.println(result);
    }

    private static boolean solve(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return true;

//            checking if left side is sorted or right side is unsorted
            if (arr[low] < arr[mid] || arr[mid] > arr[high]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid;
                } else low = mid + 1;
            }
//            checking if left side is unsorted or right side is sorted
            else if (arr[low] > arr[mid] || arr[mid] < arr[high]) {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else high = mid;
            }
//            if both of the above cases fails, then it means arr[0] == arr[mid] == arr[high]
//            so in this case we need to remove redundant, in this case we are doing high--;
            else high--;
        }

        return false;
    }
}
