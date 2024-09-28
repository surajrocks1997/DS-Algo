package com.SlidingWindow_2Pointer;

// https://leetcode.com/problems/grumpy-bookstore-owner/description/
public class GrumpyBookstoreOwner {

    public static void main(String[] args) {
        int[] customer = {3, 2, 5};
        int[] grumpy = {0, 1, 1};
        int minutes = 2;

        int result = solve1(customer, grumpy, minutes);
        System.out.println(result);
    }

    private static int solve1(int[] customer, int[] grumpy, int minutes) {
        int n = customer.length;
        int l = 0;
        int window = 0;
        int maxWindow = 0;
        int satisfied = 0;

        for (int r = 0; r < n; r++) {
            if (grumpy[r] == 1)
                window += customer[r];
            else
                satisfied += customer[r];

            if (r - l + 1 > minutes) {
                if (grumpy[l] == 1)
                    window -= customer[l];
                l++;
            }

            maxWindow = Math.max(window, maxWindow);
        }
        return satisfied + maxWindow;
    }

    private static int solve(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int initSatis = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] != 1) initSatis += customers[i];
        }

        int maxSatis = initSatis;
        int i = 0;
        int j = minutes - 1;

        int maxGrumpyIgnoreSatis = 0;
        for (int index = 0; index < minutes; index++) {
            if (grumpy[index] == 1) {
                maxGrumpyIgnoreSatis += customers[index];
                maxSatis = Math.max(maxSatis, initSatis + maxGrumpyIgnoreSatis);
            }
        }

        initSatis = maxSatis;

        int sum = 0;
        while (j + 1 < n) {
            if (grumpy[i] == 1) sum -= customers[i];
            if (grumpy[j + 1] == 1) sum += customers[j + 1];

            maxSatis = Math.max(maxSatis, sum + initSatis);

            i++;
            j++;
        }

        return maxSatis;
    }
}