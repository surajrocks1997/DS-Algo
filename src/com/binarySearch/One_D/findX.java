package com.binarySearch.One_D;

public class findX {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int k = 2;
        int index = solve(arr, k);
        System.out.println(index);
    }

    private static int solve(int[] arr, int target) {
        if (arr.length == 1 && arr[0] == target) return 0;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            }
        }

//        return low to know the correct index of target in arr
        return low;
    }
}
