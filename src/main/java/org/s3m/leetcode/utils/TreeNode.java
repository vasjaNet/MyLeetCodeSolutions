package org.s3m.leetcode.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (this == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        boolean first = true;
        boolean hasMore = true;
        while (hasMore) {
            hasMore = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null");
                } else {
                    sb.append(node.val);
                    if (node.left != null || node.right != null) {
                        hasMore = true;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}