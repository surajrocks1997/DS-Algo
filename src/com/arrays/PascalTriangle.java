package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int rows = 5;
        List<List<Integer>> result = generate(rows);
        System.out.println(result);
    }

    private static List<List<Integer>> generate(int rows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        List<Integer> prevList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) currList.add(1);
                else {
                    currList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            result.add(currList);
            prevList = currList;
            currList = new ArrayList<>();
        }

        return result;
    }
}
