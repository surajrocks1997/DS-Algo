package com.arrays;

public class MediaOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0,0};
        int[] nums2 = {0,0};

        double result = solve(nums1, nums2);
        System.out.println(result);
    }

    private static double solve(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int i = 0;
        int j = 0;
        int count1 = size/2;
        int count2 = size/2-1;
        int res1 = 0;
        int res2 = 0;

        while(i < nums1.length && j < nums2.length){
            if(i+j == count1){
                res1 = Math.min(nums1[i], nums2[j]);
            }
            if(i+j == count2){
                res2 = Math.min(nums1[i], nums2[j]);
            }

            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else if(nums1[i] == nums2[j]){
                i++;
            }
        }


        while(i<nums1.length){
            if(i+j == count1){
                res1 = nums1[i];
            }
            if(i+j == count2){
                res2 = nums1[i];
            }
            i++;
        }

        while(j<nums2.length){
            if(i+j == count1){
                res1 = nums2[j];
            }
            if(i+j == count2){
                res2 = nums2[j];
            }
            j++;
        }

        if(size % 2 == 1)
            return res1;
        else return (double) (res1 + res2) /2;
    }


}
