package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringWithNoConsecutive1s {
    public static void main(String[] args) {
        int N = 3;

        List<String> result = solve(N);
        System.out.println(result);
    }

    private static List<String> solve(int N) {
        List<String> result = new ArrayList<>();
        solve(N, "", true, result);
        return result;
    }

    private static void solve(int n, String str, boolean canTakeOne, List<String> result) {
        if (n == 0) {
            result.add(str);
            return;
        }

        solve(n - 1, str + "0", true, result);
        if (canTakeOne)
            solve(n - 1, str + "1", false, result);

    }

}
