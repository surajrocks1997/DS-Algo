package com.arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 2, 3};

        double result = solve(nums1, nums2);
        System.out.println(result);
    }

    // most efficient solution
    private static double solve(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (n < m) return solve(nums2, nums1);

        int low = 0;
        int high = m - 1;
        int total = m + n;
        int required = (m + n) / 2;

        while (true) {
            // to understand this, try with case {1,3} & {2}. high goes -1 but mid continues to be 0 if we do normal calculation of mid
            int mid = (int) (low + Math.floor((double) (high - low) / 2));
            int nums2LIndex = required - (mid + 1) - 1;

            int nums1L = mid < 0 ? Integer.MIN_VALUE : nums1[mid];
            int nums1R = mid + 1 >= m ? Integer.MAX_VALUE : nums1[mid + 1];
            int nums2L = nums2LIndex < 0 ? Integer.MIN_VALUE : nums2[nums2LIndex];
            int nums2R = nums2LIndex + 1 >= n ? Integer.MAX_VALUE : nums2[nums2LIndex + 1];

            if (nums1L <= nums2R && nums2L <= nums1R) {
                if (total % 2 == 0) {
                    return (double) ((Math.max(nums1L, nums2L)) + Math.min(nums1R, nums2R)) / 2;
                } else
                    return Math.min(nums1R, nums2R);
            } else if (nums1L > nums2R) high = mid - 1;
            else low = mid + 1;
        }
    }
}
