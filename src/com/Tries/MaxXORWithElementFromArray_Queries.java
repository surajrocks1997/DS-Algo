package com.Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxXORWithElementFromArray_Queries {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[][] queries = {
                {3, 1},
                {1, 3},
                {5, 6}
        };

        int[] result = solve(nums, queries);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        List<Tuple> queryList = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            queryList.add(new Tuple(queries[i][0], queries[i][1], i));
        }

        queryList.sort((a, b) -> a.m - b.m);

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        Trie_MaxXOROfTwoNumberBetweenTwoArray trie = new Trie_MaxXOROfTwoNumberBetweenTwoArray();

        int ind = 0;
        for (int i = 0; i < queryList.size(); i++) {
            int m = queryList.get(i).m;
            int x = queryList.get(i).x;
            int index = queryList.get(i).index;

            while (ind < nums.length && nums[ind] < m) {
                trie.insert(nums[ind]);
                ind++;
            }
            if (ind == 0)
                result[index] = -1;
            else
                result[index] = trie.getMax(x);
        }
        return result;
    }
}

class Tuple {
    int x;
    int m;
    int index;

    public Tuple(int x, int m, int index) {
        this.x = x;
        this.m = m;
        this.index = index;
    }
}
