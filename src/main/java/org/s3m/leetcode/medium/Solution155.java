package org.s3m.leetcode.medium;



/**
 * Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * <p>
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 */
public class Solution155 {



    static class MinStack {
        public static class StackNode {
            int val;
            int min;
            StackNode next;
            StackNode(int val, int min, StackNode next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
        StackNode head = null;

        public MinStack() {

        }

        public void push(int val) {
            if(head == null) {
                head = new StackNode(val, val, null);
            } else {
                head = new StackNode(val, Math.min(head.min, val), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }



    public static void main(String[] args) {

        // Example 1
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Output:   " + minStack.getMin());
        System.out.println("Expected: -3");
        minStack.pop();
        System.out.println("Output:   " + minStack.top());
        System.out.println("Expected: 0");
        System.out.println("Output:   " + minStack.getMin());
        System.out.println("Expected: -2");
        minStack.pop();
        System.out.println("Output:   " + minStack.getMin());
        System.out.println("Expected: -2");
    }
}
