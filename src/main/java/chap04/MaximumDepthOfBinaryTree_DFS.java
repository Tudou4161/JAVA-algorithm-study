package chap04;

import java.util.Stack;

public class MaximumDepthOfBinaryTree_DFS {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(3);
        tree.left = new BinaryTree(1);
        tree.right = new BinaryTree(4);
        tree.left.left = new BinaryTree(5);
        tree.left.right = new BinaryTree(8);
        tree.left.left.left = new BinaryTree(7);

        System.out.println("maxDepthDFS(tree) = " + maxDepthDFS(tree));
    }


    public static int maxDepthDFS(BinaryTree root) {
        if (root == null) return 0;

        Stack<BinaryTree> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);
        int max = 0;

        while (!stack.isEmpty()) {
            BinaryTree popElem = stack.pop();
            int cnt = valueStack.pop();
            System.out.println("max = " + max);
            max = Math.max(max, cnt);

            //좌우측이 not null일때만 카운트 값을 상승시킨다!
            if (popElem.left != null) {
                stack.push(popElem.left);
                valueStack.push(1+cnt);
            }
            if (popElem.right != null) {
                stack.push(popElem.right);
                valueStack.push(1+cnt);
            }
        }
        return max;
    }
}
