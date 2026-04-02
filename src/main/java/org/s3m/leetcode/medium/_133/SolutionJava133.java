package org.s3m.leetcode.medium._133;


import java.util.*;

public class SolutionJava133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    //todo: use dfs with recursion
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        if(node == null) {
            return null;
        }
        Node clone = new Node(node.val);
        queue.add(node);
        map.put(node, clone);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            Node curClone = map.get(cur);
            for(Node neighbor : cur.neighbors) {
                if(!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    Node clonedNeighbor = new Node(neighbor.val);
                    map.put(neighbor, clonedNeighbor);
                    curClone.neighbors.add(clonedNeighbor);
                } else {
                    curClone.neighbors.add(map.get(neighbor));
                }
            }
        }
        return clone;
    }

    public static void main(String[] args) {
        SolutionJava133 solution = new SolutionJava133();

        // Example 1: adjList = [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = solution.new Node(1);
        Node node2 = solution.new Node(2);
        Node node3 = solution.new Node(3);
        Node node4 = solution.new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloned1 = solution.cloneGraph(node1);
        System.out.println("Example 1:");
        System.out.println("Original node val: " + node1.val + ", neighbors: " + node1.neighbors.stream().map(n -> n.val).toList());
        System.out.println("Cloned node val: " + cloned1.val + ", neighbors: " + cloned1.neighbors.stream().map(n -> n.val).toList());
        System.out.println("Expected: [[2,4],[1,3],[2,4],[1,3]]");

        // Example 2: adjList = [[]] - one node with no neighbors
        Node nodeSingle = solution.new Node(1);
        Node cloned2 = solution.cloneGraph(nodeSingle);
        System.out.println("\nExample 2:");
        System.out.println("Original node val: " + nodeSingle.val + ", neighbors: " + nodeSingle.neighbors);
        System.out.println("Cloned node val: " + cloned2.val + ", neighbors: " + cloned2.neighbors);
        System.out.println("Expected: [[]]");

        // Example 3: adjList = [] - empty graph
        Node cloned3 = solution.cloneGraph(null);
        System.out.println("\nExample 3:");
        System.out.println("Cloned node: " + cloned3);
        System.out.println("Expected: []");
    }
}
