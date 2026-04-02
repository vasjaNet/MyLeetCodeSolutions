package org.s3m.leetcode.medium._117;

import java.util.ArrayDeque;
import java.util.Queue;
import org.s3m.leetcode.utils.Node;

public class SolutionJava117 {

    //todo: optimize use just additional variable
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if(root == null) return null;
        queue.add(root);
        int count = 1;
        do {
            Node prev = null;
            int countInc = 0;
            for (int i = 0; i < count; i++) {
                var cur = queue.poll();
                if (prev != null) prev.next = cur;
                prev = cur;
                if(cur.left != null){
                    queue.add(cur.left);
                    countInc++;
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                    countInc++;
                }
            }
            count = countInc;
        } while (count > 0);
        return root;
    }


    public static void main(String[] args) {

        // Example 1
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null),new Node(3, null,new Node(7), null), null);
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava117().connect(root));
        System.out.println("Expected: [1,#,2,3,#,4,5,7,#]");

        // Example 2
        root = new Node();
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava117().connect(root));
        System.out.println("Expected: []");

        // Example 3
        root = new Node(1, new Node(2, new Node(4), null, new Node(5)), null, new Node(3, new Node(6), new Node(7), null));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava117().connect(root));
        System.out.println("Expected: [1,#,2,3,#,4,#,5,#,6,#,7,#]");

    }
}
