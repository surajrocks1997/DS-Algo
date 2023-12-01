package com.arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};

        double result = solve(nums1, nums2);
        System.out.println(result);
    }

    private static double solve(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int i = 0;
        int j = 0;
        int count1 = size / 2;
        int count2 = size / 2 - 1;
        int res1 = 0;
        int res2 = 0;

        while (i < nums1.length && j < nums2.length) {
            if (i + j == count1) {
                res1 = Math.min(nums1[i], nums2[j]);
            }
            if (i + j == count2) {
                res2 = Math.min(nums1[i], nums2[j]);
            }

            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                i++;
            }
        }


        while (i < nums1.length) {
            if (i + j == count1) {
                res1 = nums1[i];
            }
            if (i + j == count2) {
                res2 = nums1[i];
            }
            i++;
        }

        while (j < nums2.length) {
            if (i + j == count1) {
                res1 = nums2[j];
            }
            if (i + j == count2) {
                res2 = nums2[j];
            }
            j++;
        }

        if (size % 2 == 1)
            return res1;
        else return (double) (res1 + res2) / 2;
    }

    // binary search approach
    private static double media(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1 + n2;

        if (n1 > n2) return media(nums2, nums1);

        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1) / 2;   // total number of elements required in left side

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];

            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }


}
