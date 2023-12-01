package com.binarySearch.One_D;

public class LowerAndUpperBound {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 5};
        int n = nums.length;
        int x = 2;

        int lowerBound = lowerBound(nums, n, x);    // nums[i] >= x
        int upperBound = upperBound(nums, n, x);    // nums[i] > x
        System.out.println("Lower Bound : " + lowerBound);
        System.out.println("Upper Bound : " + upperBound);

    }

    private static int upperBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public static int lowerBound(int[] arr, int n, int x) {
        if (n == 1) {
            if (x == arr[0]) return 0;
            else if (x > arr[0]) return 1;
        }

        if (x > arr[n - 1]) return n;

        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}