package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/hand-of-straights/
public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        boolean result = solve(hand, groupSize);
        System.out.println(result);
    }

    // another solution
    // approach -> add to MAP (element, count). sort array. loop through sorted array, see if ele is present in map
    //              start counter, loop till groupSize, increase ele++ and count++
    private static boolean solve1(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: hand){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        Arrays.sort(hand);

        for(int ele: hand){
            int count = 0;
            if(map.containsKey(ele)){
                while(count < groupSize){
                    if(!map.containsKey(ele)) return false;
                    map.put(ele, map.getOrDefault(ele, 0) - 1);
                    if(map.get(ele) == 0)
                        map.remove(ele);

                    ele++;
                    count++;
                }
            }
        }

        return true;
    }

    private static boolean solve(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            if (!map.containsKey(hand[i])) {
                map.put(hand[i], 1);
            } else map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {
            if (map.containsKey(hand[i])) {
                int count = 1;
                int num = hand[i];
                map.put(hand[i], map.getOrDefault(hand[i], 0) - 1);
                if (map.get(hand[i]) == 0) map.remove(hand[i]);
                while (count < groupSize) {
                    if (map.containsKey(num + 1)) {
                        num++;
                        map.put(num, map.getOrDefault(num, 0) - 1);
                        if (map.get(num) == 0) map.remove(num);
                        count++;
                    } else return false;
                }
            }
        }

        return true;
    }
}
