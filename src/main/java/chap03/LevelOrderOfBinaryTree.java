package chap03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//default data structure!
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        this.val = x;
    }
}

public class LevelOrderOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> result = solve(root);
        System.out.println("result = " + result);
    }

    private static List<List<Integer>> solve(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            //for문 밖에서 정의한 size대로 result에 값을 찍어준다. 매우 중요.
            int size = q.size();
            System.out.println("size = " + size);
            List<Integer> semiResult = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                //내부에서 size를 정의하면 값이 이상하게 찍힘.
                System.out.println("q.size() = " + q.size());
                TreeNode pollElem = q.poll();
                System.out.println("pollElem.val = " + pollElem.val);
                semiResult.add(pollElem.val);

                if (pollElem.left != null) {
                    q.offer(pollElem.left);
                }
                if (pollElem.right != null) {
                    q.offer(pollElem.right);
                }
            }
            
            result.add(semiResult);
        }
        return result;
    }
}