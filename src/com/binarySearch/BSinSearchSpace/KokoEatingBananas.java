package com.binarySearch.BSinSearchSpace;

//        Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
//        If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//        Return the minimum integer k such that she can eat all the bananas within h hours.

//        Example 1:
//        Input: piles = [3,6,7,11], h = 8
//        Output: 4

//        Example 2:
//        Input: piles = [30,11,23,4,20], h = 5
//        Output: 30

//        Example 3:
//        Input: piles = [30,11,23,4,20], h = 6
//        Output: 23

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;
        int result = solve(piles, h);
        System.out.println(result);
    }

    private static int solve(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int ele : piles)
            max = Math.max(ele, max);

        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (calculate(mid, piles) <= h) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    private static int calculate(int mid, int[] piles) {
        int sum = 0;
        for (int ele : piles) {
            sum += ele / mid;
            if (ele % mid != 0) sum++;

        }
        return sum;
    }
}
