package org.s3m.leetcode.medium._399;


import java.util.*;

public class SolutionJava399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map =  new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            var a = equations.get(i).get(0);
            var b = equations.get(i).get(1);
            var val = values[i];

            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, val);
            map.get(b).put(a, 1/val);
        }
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            var a = queries.get(i).get(0);
            var b = queries.get(i).get(1);
            result[i] = compute(a, b, map, new HashSet<>(), 1);
        }
        return result;
    }

    private double compute(String a, String b, Map<String, Map<String, Double>> map, HashSet<Object> visited,
                           double curVal) {
        if(!map.containsKey(a)) {
            return -1;
        }
        if(a.equals(b)) {
            return curVal;
        }
        visited.add(a);
        var chield = map.get(a);
        for(var c: chield.entrySet()) {
            if(visited.contains(c.getKey())) {
                continue;
            }
            double compute = compute(c.getKey(), b, map, visited, curVal * c.getValue());
            if(compute != -1) {
                return compute;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SolutionJava399 solution = new SolutionJava399();

        // Example 1
        List<List<String>> equations1 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );
        System.out.println("Example 1:");
        System.out.println("Input: equations = [[a,b],[b,c]], values = [2.0,3.0], queries = [[a,c],[b,a],[a,e],[a,a],[x,x]]");
        double[] result1 = solution.calcEquation(equations1, values1, queries1);
        System.out.println("Output:   " + Arrays.toString(result1));
        System.out.println("Expected: [6.00000, 0.50000, -1.00000, 1.00000, -1.00000]");

        // Example 2
        List<List<String>> equations2 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c"),
            Arrays.asList("bc", "cd")
        );
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("c", "b"),
            Arrays.asList("bc", "cd"),
            Arrays.asList("cd", "bc")
        );
        System.out.println("\nExample 2:");
        System.out.println("Input: equations = [[a,b],[b,c],[bc,cd]], values = [1.5,2.5,5.0], queries = [[a,c],[c,b],[bc,cd],[cd,bc]]");
        double[] result2 = solution.calcEquation(equations2, values2, queries2);
        System.out.println("Output:   " + Arrays.toString(result2));
        System.out.println("Expected: [3.75000, 0.40000, 5.00000, 0.20000]");

        // Example 3
        List<List<String>> equations3 = Arrays.asList(
            Arrays.asList("a", "b")
        );
        double[] values3 = {0.5};
        List<List<String>> queries3 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "c"),
            Arrays.asList("x", "y")
        );
        System.out.println("\nExample 3:");
        System.out.println("Input: equations = [[a,b]], values = [0.5], queries = [[a,b],[b,a],[a,c],[x,y]]");
        double[] result3 = solution.calcEquation(equations3, values3, queries3);
        System.out.println("Output:   " + Arrays.toString(result3));
        System.out.println("Expected: [0.50000, 2.00000, -1.00000, -1.00000]");
    }
}
