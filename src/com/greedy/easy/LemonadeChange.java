package com.greedy.easy;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 10, 20};

        boolean result = solve(bills);
        System.out.println(result);
    }

    private static boolean solve(int[] bills) {
        int fives = 0;
        int tens = 0;

        for(int bill: bills){
            if(bill == 5) fives++;
            else if(bill == 10){
                if(fives == 0) return false;
                fives--;
                tens++;
            } else {
                if(tens > 0 && fives > 0){
                    tens--;
                    fives--;
                } else if(fives >= 3){
                    fives-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
