package org.s3m.leetcode.medium;

import org.s3m.leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class Solution106 {

    private final Map<Integer, Integer> mapInorder = new HashMap<>();
    private int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int totalNodes = inorder.length;
        for (int i = 0; i < inorder.length; i++) {
            mapInorder.put(inorder[i], i);
        }
        this.post = postorder;
        return build(0, totalNodes - 1, 0, totalNodes - 1);
    }

    private TreeNode build( int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd)
            return null;

        final int rootVal = post[postEnd];
        final int rootInIndex = mapInorder.get(rootVal);
        final int leftSize = rootInIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(inStart, rootInIndex - 1, postStart, postStart + leftSize - 1);
        root.right = build(rootInIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {

        // Example 1
        int[] preorder = {9,3,15,20,7};
        int[] inorder = {9,15,7,20,3};
        System.out.println("Input:    " + Arrays.toString(preorder) + ", " + Arrays.toString(inorder));
        System.out.println("Output:   " + new Solution106().buildTree(preorder, inorder));
        System.out.println("Expected: [3,9,20,null,null,15,7]");

        // Example 2
        preorder = new int[]{-1};
        inorder = new int[]{-1};
        System.out.println("Input:    " + Arrays.toString(preorder) + ", " + Arrays.toString(inorder));
        System.out.println("Output:   " + new Solution106().buildTree(preorder, inorder));
        System.out.println("Expected: [-1]");

        // Example 3
        preorder = new int[]{1,2};
        inorder = new int[]{2,1};
        System.out.println("Input:    " + Arrays.toString(preorder) + ", " + Arrays.toString(inorder));
        System.out.println("Output:   " + new Solution106().buildTree(preorder, inorder));
        System.out.println("Expected: [1, null, 2]");

    }
}
