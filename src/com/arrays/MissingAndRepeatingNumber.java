package com.arrays;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] a = {5, 2, 3, 4, 3};

        int[] result = solve(a);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] solve(int[] a) {
        int n = a.length;
        int[] temp = new int[n];

        int first = 0;
        for (int i = 0; i < n; i++) {
            temp[a[i] - 1]++;
            if (temp[a[i] - 1] == 2)
                first = a[i];
        }


        for (int i = 0; i < n; i++) {
            if (temp[i] == 0)
                return new int[]{first, i + 1};

        }
        return new int[]{};
    }
}
