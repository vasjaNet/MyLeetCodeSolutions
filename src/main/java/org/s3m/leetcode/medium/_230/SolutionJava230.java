package org.s3m.leetcode.medium._230;


import org.s3m.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionJava230 {

    //todo: optimize use recursion
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        while(root != null || !queue.isEmpty()) {
            if(root != null) {
                queue.push(root);
                root = root.left;
            } else {
                root = queue.pop();
                if(--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }



    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        System.out.println("Input:    " + root + ", " + 1);
        System.out.println("Output:   " + new SolutionJava230().kthSmallest(root, 1));
        System.out.println("Expected: 1");

        // Example 2
        root = new TreeNode(5, new TreeNode(3), new TreeNode(6, new TreeNode(2), new TreeNode(4, null, new TreeNode(7))));
        System.out.println("Input:    " + root + ", " + 3);
        System.out.println("Output:   " + new SolutionJava230().kthSmallest(root, 3));
        System.out.println("Expected: 3");

    }
}
