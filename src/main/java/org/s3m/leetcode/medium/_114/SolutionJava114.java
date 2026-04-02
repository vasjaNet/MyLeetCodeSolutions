package org.s3m.leetcode.medium._114;

import java.util.ArrayDeque;
import java.util.Deque;
import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava114 {

    public void flatten_(TreeNode root) {
        if(root == null) return;
        TreeNode cur = root;
        Deque<TreeNode> queue = new ArrayDeque<>();

        while(cur.right != null || cur.left != null || !queue.isEmpty()) {

            if(cur.left != null) {
                if(cur.right!=null)
                    queue.push(cur.right);
                cur.right = cur.left;
                cur.left = null;

            } else {
                if(cur.right == null) {
                    cur.right = queue.pop();
                }
            }
            cur = cur.right;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if (cur.left != null) {
                TreeNode tmp = cur.left;
                while(tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;
        }
    }


    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        System.out.println("Input:    " + root);
        new SolutionJava114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: [1,null,2,null,3,null,4,null,5,null,6]");

        // Example 2
        root = new TreeNode();
        System.out.println("Input:    " + root);
        new SolutionJava114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: []");

        // Example 3
        root = new TreeNode(0);
        System.out.println("Input:    " + root);
        new SolutionJava114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: [0]");

        // Example 4
        root = new TreeNode(1, new TreeNode(2), null);
        System.out.println("Input:    " + root);
        new SolutionJava114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: [1,null,2]");

    }
}
