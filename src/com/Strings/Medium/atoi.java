package com.Strings.Medium;

public class atoi {
    public static void main(String[] args) {
        String s = "   -42";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        if (s.length() == 0) return 0;
        boolean isNegative = false;
        int index = 0;

//        skipping whitespaces
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                isNegative = true;
                index++;
            } else if (s.charAt(index) == '+') index++;
        }

        int result = 0;
        while (index < s.length() && isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result = (result * 10) + digit;
            index++;
        }

        return isNegative ? (-1) * result : result;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
