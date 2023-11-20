package com.binarySearch.BSinSearchSpace;

// https://leetcode.com/problems/koko-eating-bananas/

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
        int[] piles = {805306368, 805306368, 805306368}; // 2415919104 > 1000000000
        int h = 1000000000;
        int result = solve(piles, h);
        System.out.println(result);
    }

    private static int solve(int[] piles, int h) {
        int lowSpeed = 1;
        int highSpeed = (int) 1e12;


        while(lowSpeed <= highSpeed){
            int midSpeed = lowSpeed + (highSpeed-lowSpeed)/2;

            int timeTakenToEatAllBanana = 0;
            for(int i = 0; i < piles.length; i++){
                timeTakenToEatAllBanana += (int) Math.ceil((double) piles[i] / (double) midSpeed);
            }

            if(timeTakenToEatAllBanana <= h)
                highSpeed = midSpeed - 1;
            else
                lowSpeed = midSpeed + 1;

        }

        return lowSpeed;
    }
}
