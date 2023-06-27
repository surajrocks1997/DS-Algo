package com.binarySearch.BSinSearchSpace;

public class NthRoot {
    public static void main(String[] args) {
        int m = 27;
        int n = 3;
        double ans = solve(m, n);
        System.out.println(ans);
    }

    private static double solve(int m, int n) {
        double low = 1;
        double high = m;

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2;
            if (multiply(mid, n) > m) {
                high = mid;
            } else low = mid;
        }

        return low;
    }

    private static double multiply(double mid, int n) {
        for (int i = 1; i < n; i++) {
            mid = mid * n;
        }
        return mid;
    }
}
