package com.Strings.Medium;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 5;

        String result = solve(n);
        System.out.println(result);
    }

    private static String solve(int n) {
        return solve(1, n, "1");
    }

    private static String solve(int index, int n, String str) {
        if (index == n) return str;

        char[] arr = str.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < arr.length) {
            int ele = Integer.parseInt(String.valueOf(arr[i]));
            int count = 0;
            while (i < arr.length && Integer.parseInt(String.valueOf(arr[i])) == ele) {
                count++;
                i++;
            }
            sb.append(count).append(ele);
        }
        return solve(index + 1, n, sb.toString());
    }
}
