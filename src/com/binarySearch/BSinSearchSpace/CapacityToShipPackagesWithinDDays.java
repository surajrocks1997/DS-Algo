package com.binarySearch.BSinSearchSpace;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        int result = solve(weights, days);
        System.out.println(result);
    }

    private static int solve(int[] weights, int days) {
        if (weights.length == 1) return weights[0];

        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int ele : weights) {
            high += ele;
            low = Math.max(low, ele);
        }

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;


    }

    private static boolean isPossible(int[] weights, int days, int mid) {
        int count = 0;
        int reqDays = 0;
        for (int ele : weights) {
            if (ele > mid) return false;
            if (ele + count > mid) {
                reqDays++;
                count = 0;
            }
            count += ele;

            if (reqDays > days) return false;
        }
        reqDays += 1;

        return reqDays <= days;
    }
}
