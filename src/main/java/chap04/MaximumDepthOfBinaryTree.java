package chap04;

class BinaryTree {
    int val;
    BinaryTree left, right;
    BinaryTree(int x) {
        this.val = x;
    }
}

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(3);
        tree.left = new BinaryTree(1);
        tree.right = new BinaryTree(4);
        tree.left.left = new BinaryTree(5);
        tree.left.right = new BinaryTree(8);
        tree.left.left.left = new BinaryTree(7);

        System.out.println("maxDepth(tree) = " + maxDepth(tree));
    }

    private static int maxDepth(BinaryTree root) {
        //재귀 탈출조건!
        if (root == null) return 0;

        System.out.println("root.val = " + root.val);
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        //올라오면서 왼쪽과 오른쪽 방향의 브랜치 level을 비교한다.
        // 또한 양쪽 모두 null일때 강제로 +1시켜준다.
        System.out.println("Math.max(leftMax, rightMax) + 1 = " + Math.max(leftMax, rightMax)+1);
        return Math.max(leftMax, rightMax) + 1;
    }
}
