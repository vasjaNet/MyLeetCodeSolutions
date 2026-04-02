package org.s3m.leetcode.easy._226;

import java.util.ArrayDeque;
import java.util.Deque;
import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }





    public static void main(String[] args) {
        // Example 1
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava226().invertTree(root));
        System.out.println("Expected: [4,7,2,9,6,3,1]");

        // Example 2
        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava226().invertTree(root));
        System.out.println("Expected: [2,1,3]");

        // Example 3
        root = new TreeNode();
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava226().invertTree(root));
        System.out.println("Expected: []");


    }
}
