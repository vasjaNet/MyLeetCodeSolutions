package org.s3m.leetcode.medium;

import org.s3m.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Binary Search Tree Iterator
 * <p>
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 * <p>
 * Example 1:
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * Explanation
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // return 3
 * bSTIterator.next();    // return 7
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 9
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 15
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 20
 * bSTIterator.hasNext(); // return False
 */
public class Solution173 {

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
        Solution173 solution173 = new Solution173();
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
