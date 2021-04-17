package chap03;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("strs = " + points(strs));
    }

    private static int points(String[] strs) {
        Stack<Integer> stack = new Stack<>();

        for (String op : strs) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    int x = stack.peek();
                    stack.push(x*2);
                    break;
                case "+":
                    int x1 = stack.pop();
                    int x2 = stack.pop();
                    stack.push(x2);
                    stack.push(x1);
                    stack.push(x1+x2);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
                    break;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            System.out.println("stack = " + stack.peek());
            sum += stack.pop();
        }

        return sum;
    }
}
