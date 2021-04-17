package chap04;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_BFS {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(3);
        tree.left = new BinaryTree(1);
        tree.right = new BinaryTree(4);
        tree.left.left = new BinaryTree(5);
        tree.left.right = new BinaryTree(8);
        tree.left.left.left = new BinaryTree(7);
        tree.left.left.left.left = new BinaryTree(10);

        System.out.println("maxDepthDFS(tree) = " + maxDepthBFS(tree));
    }

    private static int maxDepthBFS(BinaryTree root) {
        if (root == null) return 0;

        Queue<BinaryTree> q = new LinkedList<>();
        int cnt = 0;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                System.out.println("q.peek().val = " + q.peek().val);
                BinaryTree pollElem = q.poll();

                if(pollElem.left != null) {
                    q.offer(pollElem.left);
                }
                if (pollElem.right != null) {
                    q.offer(pollElem.right);
                }
            }
            cnt++;
        }

        return cnt;
    }
}
