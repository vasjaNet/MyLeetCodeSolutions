package org.s3m.leetcode.hard._23;


import org.s3m.leetcode.utils.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionJava23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        // Example 1
        ListNode[] lists = {new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))};
        System.out.println("Input:    " + Arrays.toString(lists));
        System.out.println("Output:   " + new SolutionJava23().mergeKLists(lists));
        System.out.println("Expected: [1,1,2,3,4,5]");

        // Example 2
        lists = new ListNode[0];
        System.out.println("Input:    " + Arrays.toString(lists));
        System.out.println("Output:   " + new SolutionJava23().mergeKLists(lists));
        System.out.println("Expected: []");
    }

}
