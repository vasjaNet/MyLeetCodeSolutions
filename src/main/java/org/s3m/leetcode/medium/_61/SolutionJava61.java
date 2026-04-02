package org.s3m.leetcode.medium._61;


import org.s3m.leetcode.utils.ListNode;


public class SolutionJava61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0) return head;
        if(head == null) return null;
        ListNode cur = head;
        ListNode last = null;
        int length = 0;
        while(cur != null) {
            length++;
            last = cur;
            cur = cur.next;
        }
        if(length == 1) return head;
        int shift = k % length;
        int headLength = length - shift;
        cur = head;
        ListNode prev = null;
        if(shift == 0) return head;
        for(int i = 0; i < headLength; i++) {
            prev = cur;
            cur = cur.next;
        }
        last.next = head;
        head = cur;
        prev.next = null;
        return head;
    }


    public static void main(String[] args) {

        // Example 1
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava61().rotateRight(head, 2));
        System.out.println("Expected: [4,5,1,2,3]");

        // Example 2
        head = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava61().rotateRight(head, 4));
        System.out.println("Expected: [2,0,1]");

    }
}
