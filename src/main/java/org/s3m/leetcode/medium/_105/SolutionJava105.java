package org.s3m.leetcode.medium._105;

import org.s3m.leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionJava105 {

    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int totalNodes = preorder.length;
        if (totalNodes == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, 0, totalNodes);
    }

    private TreeNode buildTree(int[] preorder, int index, int start, int subtreeSize) {
        if (subtreeSize <= 0) {
            return null;
        }
        int rootValue = preorder[index];

        int rootInorderIndex = map.get(rootValue);

        int leftSubtreeSize = rootInorderIndex - start;

        TreeNode leftChild = buildTree(preorder, index + 1, start, leftSubtreeSize);

        TreeNode rightChild = buildTree(preorder, index + 1 + leftSubtreeSize,
                rootInorderIndex + 1,
                subtreeSize - 1 - leftSubtreeSize);

        return new TreeNode(rootValue, leftChild, rightChild);
    }

    public static void main(String[] args) {

        // Example 1
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println("Input:    " + Arrays.toString(preorder) + ", " + Arrays.toString(inorder));
        System.out.println("Output:   " + new SolutionJava105().buildTree(preorder, inorder));
        System.out.println("Expected: [3,9,20,null,null,15,7]");

        // Example 2
        preorder = new int[]{-1};
        inorder = new int[]{-1};
        System.out.println("Input:    " + Arrays.toString(preorder) + ", " + Arrays.toString(inorder));
        System.out.println("Output:   " + new SolutionJava105().buildTree(preorder, inorder));
        System.out.println("Expected: [-1]");

    }
}
