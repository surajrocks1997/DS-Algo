package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class AlternativePositiveNegative {
    public static void main(String[] args) {
//      where arr has equal numbers of positive and negative elements
        int[] arr = {3, 1, -2, -5, 2, -4};
        for (int x : solve(arr)) {
            System.out.print(x + " ");
        }
        System.out.println();

//      where arr does not have equal numbers of positive and negative elements
        int[] arr2 = {-1, 2, 3, 4, -3, 1};
        for (int x : solve1(arr2)) {
            System.out.print(x + " ");
        }

    }

    private static int[] solve1(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int x : arr) {
            if (x > 0) positives.add(x);
            else negatives.add(x);
        }

        int i = 0, j = 0;
        int index = 0;
        while (index < arr.length - 1 && i < positives.size() && j < negatives.size()) {
            arr[index++] = positives.get(i++);
            arr[index++] = negatives.get(j++);
        }

        while (index < arr.length - 1 && i < positives.size() - 1) arr[index++] = positives.get(i++);
        while (index < arr.length - 1 && j < negatives.size() - 1) arr[index++] = negatives.get(j++);

        return arr;
    }
    private static int[] solve(int[] arr) {
        int posIndex = 0;
        int negIndex = 1;
        int[] res = new int[arr.length];

        for (int j : arr) {
            if (j > 0) {
                res[posIndex] = j;
                posIndex += 2;
            } else {
                res[negIndex] = j;
                negIndex += 2;
            }
        }

        return res;

    }
}
