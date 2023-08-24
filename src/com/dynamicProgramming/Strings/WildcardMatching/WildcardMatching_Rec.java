package com.dynamicProgramming.Strings.WildcardMatching;

public class WildcardMatching_Rec {
    public static void main(String[] args) {
        String p = "*cb*b";
        String s = "cbasdawadwabb";

        boolean result = solve(s, p);
        System.out.println(result);
    }

    private static boolean solve(String s, String p) {
        int m = s.length();
        int n = p.length();
        return solve(m - 1, n - 1, s, p);
    }

    private static boolean solve(int stri, int patternj, String str, String pattern) {
        if (stri < 0 && patternj < 0) return true;
        if (patternj < 0 && stri >= 0) return false;
        if (patternj >= 0 && stri < 0) {
            for (int index = 0; index <= patternj; index++)
                if (pattern.charAt(index) != '*')
                    return false;
            return true;
        }

        if (str.charAt(stri) == pattern.charAt(patternj) || pattern.charAt(patternj) == '?')
            return solve(stri - 1, patternj - 1, str, pattern);

        if (pattern.charAt(patternj) == '*')
            return solve(stri, patternj - 1, str, pattern) || solve(stri - 1, patternj, str, pattern);

        return false;
    }
}
