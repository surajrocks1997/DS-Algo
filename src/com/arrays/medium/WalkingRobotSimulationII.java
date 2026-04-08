package com.arrays.medium;

import java.util.Arrays;

//https://leetcode.com/problems/walking-robot-simulation-ii
public class WalkingRobotSimulationII {

    public static void main(String[] args) {
        Robot robot = new Robot(6, 3);
        robot.step(2);
        robot.step(2);
        System.out.println("Position: " + Arrays.toString(robot.getPos()));
        System.out.println("Direction: " + robot.getDir());
        robot.step(2);
        robot.step(1);
        robot.step(4);
        System.out.println("Position: " + Arrays.toString(robot.getPos()));
        System.out.println("Direction: " + robot.getDir());
    }
}

class Robot {

    int row;
    int col;
    int[][] directions;

    WRSII_Tuple wrsii_tuple;
    String[] directionNames;

    public Robot(int width, int height) {
        this.wrsii_tuple = new WRSII_Tuple(0, 0, 0);
        this.row = width;
        this.col = height;
        this.directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        this.directionNames = new String[]{"East", "North", "West", "South"};
    }

    public void step(int num) {
        int perimeter = 2 * (row + col - 2);
        num %= perimeter;
        if(num == 0) num = perimeter;

        while (num > 0) {
            int stepsToCorner;
            if (wrsii_tuple.getDirection() == 0) stepsToCorner = row - 1 - wrsii_tuple.getX();
            else if (wrsii_tuple.getDirection() == 1) stepsToCorner = col - 1 - wrsii_tuple.getY();
            else if (wrsii_tuple.getDirection() == 2) stepsToCorner = wrsii_tuple.getX();
            else stepsToCorner = wrsii_tuple.getY();

            if (num <= stepsToCorner) {
                wrsii_tuple.setX(wrsii_tuple.getX() + directions[wrsii_tuple.getDirection()][0] * num);
                wrsii_tuple.setY(wrsii_tuple.getY() + directions[wrsii_tuple.getDirection()][1] * num);
                num = 0;
            } else {
                wrsii_tuple.setX(wrsii_tuple.getX() + directions[wrsii_tuple.getDirection()][0] * stepsToCorner);
                wrsii_tuple.setY(wrsii_tuple.getY() + directions[wrsii_tuple.getDirection()][1] * stepsToCorner);
                num -= stepsToCorner;
                wrsii_tuple.setDirection((wrsii_tuple.getDirection() + 1) % 4);
            }
        }

    }

    public int[] getPos() {
        return new int[]{wrsii_tuple.getX(), wrsii_tuple.getY()};
    }

    public String getDir() {
        return directionNames[wrsii_tuple.getDirection()];
    }
}

class WRSII_Tuple {
    int x;
    int y;
    int direction;

    public WRSII_Tuple(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}