package chap03;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String exp = "()[]{}";
        //String exp = "([)]";
        System.out.println("isValid(exp) = " + isValid(exp));
    }

    private static boolean isValid(String exp) {
        if (exp.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char charElem = exp.charAt(i);
            switch (charElem) {
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                        break;
                    }
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                        break;
                    }
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                default:
                    stack.push(charElem);
                    break;
            }
        }



        return stack.empty();
    }
}





//if (exp.length() % 2 != 0) {
//        return false; //홀수면 어차피 false다!
//        }
//
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < exp.length(); i++) {
//        switch (exp.charAt(i)) {
//        case ')':
//        if (!stack.empty() && stack.peek()=='(') stack.pop();
//        break;
//        case '}':
//        if (!stack.empty() && stack.peek()=='{') stack.pop();
//        break;
//        case ']':
//        if (!stack.empty() && stack.peek()=='[') stack.pop();
//        break;
//
//default:
//        stack.push(exp.charAt(i));
//        break;
//        }
//        }
//
//        while (!stack.isEmpty()) {
//        System.out.println("stack = " + stack.pop());
//        }
//
//        return stack.empty();
//        }
