package com.Strings;

// https://leetcode.com/problems/fraction-to-recurring-decimal/description

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        int numerator = -1;
        int denominator = -2147483648;

        String result = solve(numerator, denominator);
        System.out.println(result);

    }

    private static String solve(int numerator, int denominator) {
        long num = (long) numerator;
        long den = (long) denominator;
        boolean isNegative = false;
        if (num < 0 && den < 0) {
            num = -1 * num;
            den = -1 * den;
        } else if (num < 0 && den > 0) {
            num = -1 * num;
            isNegative = true;
        } else if (num > 0 && den < 0) {
            den = -1 * den;
            isNegative = true;
        }
        StringBuilder ans = new StringBuilder();

        long q = num / den;
        long r = num % den;
        ans.append(q);

        if (r == 0) return isNegative ? ans.insert(0, "-").toString() : ans.toString();
        else ans.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (r != 0) {
            if (!map.containsKey(r))
                map.put(r, ans.length());
            else {
                int ind = map.get(r);
                ans.insert(ind, "(").append(")");
                return isNegative ? ans.insert(0, "-").toString() : ans.toString();
            }
            r *= 10;
            q = r / den;
            r = r % den;
            ans.append(q);
        }

        return isNegative ? ans.insert(0, "-").toString() : ans.toString();
    }
}


// NOT PASSING VERY LARGE DECIMAL TEST CASES.

//    private static String solve(int numerator, int denominator) {
//        double x = (double) numerator / (double) denominator;
//        boolean isNegative = false;
//        if (x < 0) {
//            isNegative = true;
//            x = (-1) * x;
//        }
//
//        String str = String.valueOf(x);
//        String[] strArr = str.split("\\.");
//
//        if (strArr[1].length() == 1) {
//            if (strArr[1].equals("0")) {
//                return isNegative ? "-" + strArr[0] : strArr[0];
//            }
//        } else {
//            char[] arr = strArr[1].toCharArray();
//            String ans = isRepeating(arr);
//            return isNegative ? "-" + strArr[0] + "." + ans : strArr[0] + "." + ans;
//        }
//
//        return str;
//    }
//
//    private static String isRepeating(char[] arr) {
//        int i = 0;
//        int j = 1;
//        while (i < j && i < arr.length) {
//            j = i + 1;
//            while (j < arr.length) {
//                if (arr[i] == arr[j]) {
//                    int iPos = i;
//                    int jPos = j;
//                    int count = j - i + 1;
//                    if (isTrue(iPos, jPos, count, arr)) {
//                        String ans = String.valueOf(arr);
//                        if (i == 0) {
//                            return "(" + ans.substring(i, j) + ")";
//                        } else {
//                            return ans.substring(0, i) + "(" + ans.substring(i, j) + ")";
//                        }
//                    }
//                }
//                j++;
//            }
//            i++;
//        }
//
//        return String.valueOf(arr);
//    }
//
//    private static boolean isTrue(int iPos, int jPos, int count, char[] arr) {
//        while (jPos < arr.length && arr[iPos] == arr[jPos]) {
//            iPos++;
//            jPos++;
//            count--;
//            if (count == 0) return true;
//        }
//        if (jPos == arr.length) return true;
//        else return false;
//    }
//}