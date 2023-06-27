package com.binarySearch.One_D;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
//        int[] arr = {3, 3, 7, 7, 10, 11, 11};
        int[] arr = {1, 1, 2, 3, 3};
        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        if (arr.length == 1) return arr[0];

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid % 2 != 0) mid--;
            if (arr[mid] != arr[mid + 1])
                high = mid;
            else low = mid + 2;
        }


        return arr[low];
    }
}
