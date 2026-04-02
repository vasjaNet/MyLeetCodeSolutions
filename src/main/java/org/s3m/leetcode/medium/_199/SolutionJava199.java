package org.s3m.leetcode.medium._199;

import java.util.*;
import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava199 {

    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        int visiblwNode = root.val;
        result.add(visiblwNode);
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            if(cur.val == visiblwNode && !queue.isEmpty()) {
                visiblwNode = queue.peekLast().val;
                result.add(visiblwNode);
            }
        }
        return result;
    }



    public static void main(String[] args) {

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println("Input:    " + root1);
        System.out.println("Output:   " + new SolutionJava199().rightSideView(root1));
        System.out.println("Expected: [1,3,4]");

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(4);
        System.out.println("Input:    " + root2);
        System.out.println("Output:   " + new SolutionJava199().rightSideView(root2));
        System.out.println("Expected: [1,3,4,5]");

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println("Input:    " + root3);
        System.out.println("Output:   " + new SolutionJava199().rightSideView(root3));
        System.out.println("Expected: [1,3]");

        // Example 4
        TreeNode root4 = null;
        System.out.println("Input:    " + root4);
        System.out.println("Output:   " + new SolutionJava199().rightSideView(root4));
        System.out.println("Expected: []");

    }
}
