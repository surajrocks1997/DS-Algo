package com.Strings.Medium;

// https://leetcode.com/problems/move-pieces-to-obtain-a-string/

public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L______RR";

        boolean result = solve(start, target);
        System.out.println(result);
    }

    private static boolean solve(String start, String target) {
        int n = start.length();

        int iS = 0;
        int iT = 0;

        char[] startArr = start.toCharArray();
        char[] targetArr = target.toCharArray();

        while (true) {
            while (iS < n && startArr[iS] == '_') iS++;
            while (iT < n && targetArr[iT] == '_') iT++;

            if (iS == n && iT == n) return true;
            if (iS == n || iT == n) return false;

            if (startArr[iS] != targetArr[iT]) return false;

            if (startArr[iS] == 'L') {
                if (iS < iT) return false;
            } else {
                if (iT < iS) return false;
            }

            iS++;
            iT++;
        }
    }
}
