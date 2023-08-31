package com.arrays;

import java.util.HashMap;
import java.util.Map;

//separate solution positive + negative
public class longestSubArray_Pos_Neg {

    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 3};
        int k = 3;
        int result = longestSubarrayforPositiveArray(arr, k);
        System.out.println(result);

        result = longestSubArray_pos_neg(arr, k);
        System.out.println(result);
    }

    private static int longestSubArray_pos_neg(int[] arr, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (!preSumMap.containsKey(sum)) preSumMap.put(sum, i);
            if (preSumMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - preSumMap.get(sum - k));
            }
        }
        return maxLength;
    }

    private static int longestSubarrayforPositiveArray(int[] arr, int k) {
        int right = 0;
        int left = 0;
        int sum = arr[0];
        int maxLength = 0;

        while (right < arr.length) {
            while (left <= right && sum > k) {
                sum -= arr[left++];
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            if (++right < arr.length) {
                sum += arr[right];
            }
        }

        return maxLength;
    }
}
