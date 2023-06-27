package com.Strings.Easy;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        boolean res = solve(s, goal);
        System.out.println(res);
    }

    private static boolean solve(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);

    }
}
