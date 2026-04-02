package org.s3m.leetcode.medium._173;

import org.s3m.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionJava173 {

    class BSTIterator {

        private Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            pushLeft(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }


    public static void main(String[] args) {
        // Build tree from [7, 3, 15, null, null, 9, 20]
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Example 1
        SolutionJava173 solution173 = new SolutionJava173();
        BSTIterator bstIterator = solution173.new BSTIterator(root);
        System.out.println(bstIterator.next());    // return 3
        System.out.println(bstIterator.next());    // return 7
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 9
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 15
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 20
        System.out.println(bstIterator.hasNext()); // return False
    }
}
