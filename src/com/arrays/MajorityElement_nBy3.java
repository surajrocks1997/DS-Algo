package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElement_nBy3 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 3, 1, 4, 5, 6};
        List<Integer> result = solve(arr);
        System.out.println(result);
    }

    private static List<Integer> solve(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (count1 == 0 && ele2 != arr[i]) {
                ele1 = arr[i];
                count1 = 1;
            } else if (count2 == 0 && ele1 != arr[i]) {
                ele2 = arr[i];
                count2 = 1;
            } else if (arr[i] == ele1) count1++;
            else if (arr[i] == ele2) count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int j : arr) {
            if (j == ele1) count1++;
            if (j == ele2) count2++;
        }

        int min = arr.length / 3;
        if (count1 > min) result.add(ele1);
        if (count2 > min) result.add(ele2);

        Collections.sort(result);
        return result;
    }
}
