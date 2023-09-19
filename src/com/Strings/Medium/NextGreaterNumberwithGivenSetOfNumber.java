package com.Strings.Medium;

import java.util.Arrays;

public class NextGreaterNumberwithGivenSetOfNumber {
    public static void main(String[] args) {
        String str = "218765";
        String result = solve(str);
        System.out.println(result);
    }

    private static String solve(String str) {
        char[] input = str.toCharArray();
        int n = input.length;

        int i = 0;
        for (i = n - 1; i > 0; i--) {
            if (input[i - 1] < input[i])
                break;
        }


        int min;
        if (i == 0) return null;
        else {
            min = i;
            int x = input[i - 1];
            for (int j = i; j < n; j++) {
                if (input[j] > x && input[j] < input[min])
                    min = j;
            }
        }

        char temp = input[min];
        input[min] = input[i - 1];
        input[i - 1] = temp;

        Arrays.sort(input, i, n);

        return Arrays.toString(input);


    }
}
