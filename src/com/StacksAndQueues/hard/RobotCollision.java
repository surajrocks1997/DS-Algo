package com.StacksAndQueues.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RobotCollision {

    public static void main(String[] args) {
        int[] positions = {4, 48, 23, 42};
        int[] healths = {16, 25, 26, 16};
        String directions = "LLLR";
        List<Integer> result = solve(positions, healths, directions);
        System.out.println(result);
    }

    private static List<Integer> solve(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Tuple> list = new ArrayList<Tuple>();
        for (int i = 0; i < n; i++) {
            list.add(new Tuple(positions[i], healths[i], directions.charAt(i), i));
        }
        list.sort((a, b) -> a.pos - b.pos);

        Stack<Tuple> stack = new Stack<>();

        for (Tuple t : list) {
            if (stack.isEmpty() || (stack.peek().dir == 'L') || isSameSign(stack.peek(), t)) {
                stack.push(t);
            } else {
                while (!stack.isEmpty() && stack.peek().dir == 'R' && stack.peek().health < t.health) {
                    stack.pop();
                    t.health -= 1;
                }

                if (stack.isEmpty() || stack.peek().dir == 'L')
                    stack.push(t);
                else if (!stack.isEmpty() && stack.peek().health == t.health)
                    stack.pop();
                else stack.peek().health -= 1;
            }
        }


        List<Integer> res = new ArrayList<>();
        stack.sort((a, b) -> a.initPos - b.initPos);
        list = stack.stream().toList();
        for (Tuple tuple : list)
            res.add(tuple.health);

        return res;
    }

    private static boolean isSameSign(Tuple t1, Tuple t2) {
        return t1.dir == t2.dir;
    }
}

class Tuple {
    int pos;
    int health;
    char dir;
    int initPos;

    public Tuple(int pos, int health, char dir, int initPos) {
        this.pos = pos;
        this.health = health;
        this.dir = dir;
        this.initPos = initPos;
    }
}