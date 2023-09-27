package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        boolean result = solve(hand, groupSize);
        System.out.println(result);
    }

    private static boolean solve(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length; i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i], 1);
            } else map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++){
            if(map.containsKey(hand[i])){
                int count = 1;
                int num = hand[i];
                map.put(hand[i], map.getOrDefault(hand[i], 0) - 1);
                if(map.get(hand[i]) == 0) map.remove(hand[i]);
                while(count < groupSize){
                    if(map.containsKey(num+1)){
                        num++;
                        map.put(num, map.getOrDefault(num, 0) - 1);
                        if(map.get(num) == 0) map.remove(num);
                        count++;
                    }
                    else return false;
                }
            }
        }

        return true;
    }
}
