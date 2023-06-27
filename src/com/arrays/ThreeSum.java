package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-2, -2, -1, -1, -1, 0, 0, 0, 2, 2};
        List<List<Integer>> result = solve(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            int low = i + 1;
            int high = arr.length - 1;
            while (low < high) {
                if (arr[low] + arr[high] == -arr[i]) {
                    result.add(Arrays.asList(arr[i], arr[low], arr[high]));
                    low++;
                    high--;

                    if (arr[low] == arr[low - 1]) {
                        while (low < high && arr[low] == arr[low - 1]) low++;
                    }
                    if (arr[high + 1] == arr[high]) {
                        while (low < high && arr[high + 1] == arr[high]) high--;
                    }

                } else if (arr[low] + arr[high] < -arr[i]) {
                    low++;
                } else {
                    high--;
                }
            }

            int curr = arr[i];
            while (i + 1 < arr.length - 1 && arr[i + 1] == curr) i++;

        }


        return result;
    }
}
