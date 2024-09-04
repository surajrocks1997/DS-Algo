package com.arrays.medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/walking-robot-simulation/description/
public class WalkingRobotSimulation {

    public static void main(String[] args) {
        int[] commands = {6, -1, -1, 6};
        int[][] obstacles = {
        };
        int result = solve(commands, obstacles);
        System.out.println(result);
    }

    private static int solve(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int d = 0;
        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        Set<String> obs = new HashSet<>();
        for (int[] row : obstacles) {
            obs.add(row[0] + "," + row[1]);
        }

        int maxDist = 0;
        for (int cmd : commands) {
            if (cmd == -1)
                d = (d + 1) % 4;
            else if (cmd == -2)
                d = (d - 1 + 4) % 4;
            else {
                for (int i = 0; i < cmd; i++) {
                    int delX = x + directions[d][0];
                    int delY = y + directions[d][1];
                    if (obs.contains(delX + "," + delY))
                        break;
                    x = delX;
                    y = delY;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}