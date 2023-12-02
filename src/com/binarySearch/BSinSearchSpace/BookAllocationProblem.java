package com.binarySearch.BSinSearchSpace;

import java.util.ArrayList;
import java.util.Arrays;

public class BookAllocationProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int m = 4;

        int result = solve(arr, m);
        System.out.println(result);
    }

    private static int solve(ArrayList<Integer> arr, int m) {
        if (m > arr.size()) return -1;

        int low = -1;
        int high = 0;
        for (int ele : arr) {
            low = Math.max(low, ele);
            high += ele;
        }

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isStudentAllocationLess(arr, m, mid)) {
                ans = mid;
                high = mid - 1;

            } else
                low = mid + 1;
        }
        return ans;
    }

    private static boolean isStudentAllocationLess(ArrayList<Integer> arr, int students, int mid) {
        int reqStudents = 0;
        int count = 0;
        for (int pages : arr) {
            if (count + pages > mid) {
                reqStudents++;
                count = 0;
            }
            count += pages;

            if (reqStudents > students) return false;
        }
        if (count >= 0) reqStudents++;

        return reqStudents <= students;
    }
}
