package design;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        String s = "3+2*2";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;
            else if (s.charAt(i) == '*') {
                int[] res = giveNumber(i + 1, s);
                stack.push(stack.pop() * res[1]);
                i = res[0];
            } else if (s.charAt(i) == '/') {
                int[] res = giveNumber(i + 1, s);
                stack.push(stack.pop() / res[1]);
                i = res[0];
            } else if (s.charAt(i) == '-') {
                int[] res = giveNumber(i + 1, s);
                stack.push(-1 * res[1]);
                i = res[0];
            } else if (s.charAt(i) == '+') {
                int[] res = giveNumber(i + 1, s);
                stack.push(res[1]);
                i = res[0];
            } else {
                int[] res = giveNumber(i, s);
                stack.push(res[1]);
                i = res[0];
            }
        }
        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        return sum;
    }

    private static int[] giveNumber(int index, String s) {   // returns [index, number]
        StringBuilder sb = new StringBuilder();
        int num = index;
        while (num < s.length()) {
            if (s.charAt(num) >= '0' && s.charAt(num) <= '9')
                sb.append(s.charAt(num++));
            else if (s.charAt(num) == ' ') num++;
            else break;
        }

        return new int[]{num - 1, Integer.parseInt(sb.toString())};

    }
}