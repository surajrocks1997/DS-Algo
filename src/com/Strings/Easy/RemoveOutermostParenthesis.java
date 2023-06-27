package com.Strings.Easy;

public class RemoveOutermostParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        String res = solve(s);
        System.out.println(res);
    }

    private static String solve(String s) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        int sum = 0;
        int start = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') sum += 1;
            else sum -= 1;

            if (sum == 0) {
                appendString(str, start, i, s);
                start = i + 1;
            }
            i++;
        }
        return str.toString();
    }

    private static StringBuilder appendString(StringBuilder str, int start, int end, String s) {
        for (int i = start + 1; i < end; i++) {
            str.append(s.charAt(i));
        }
        return str;

    }
}
