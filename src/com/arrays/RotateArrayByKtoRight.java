package com.arrays;

import java.util.Arrays;

public class RotateArrayByKtoRight {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        solve(nums, k);
        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
    }

//    for left rotate do this
//    swap(0, k-1, nums);
//    swap(k,nums.length-1, nums);
//    swap(0,nums.length-1,nums);
    private static void solve(int[] nums, int k) {
        if(k==0) return;
        k = (k % nums.length);
        swap(0,nums.length-1,nums);
        swap(0, k-1, nums);
        swap(k,nums.length-1, nums);
    }

    public static void swap(int left, int right, int[] arr){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right]=temp;
            left++;right--;
        }
    }
}
