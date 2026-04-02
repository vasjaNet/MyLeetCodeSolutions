package org.s3m.leetcode.medium._134;


import java.util.Arrays;

public class SolutionJava134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        if(gas.length == 0) return result;
        int debptr = 0;
        int tank = 0;
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                debptr += tank;
                tank = 0;
                result = i+1;
            }
        }
        debptr += tank;
        return debptr >= 0 ? result : -1;
    }

    public static void main(String[] args) {

        // Example 1
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println("Input:    " + Arrays.toString(gas) + ", " + Arrays.toString(cost));
        System.out.println("Output:   " + new SolutionJava134().canCompleteCircuit(gas, cost));
        System.out.println("Expected: 3");

        // Example 2
        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println("Input:    " + Arrays.toString(gas) + ", " + Arrays.toString(cost));
        System.out.println("Output:   " + new SolutionJava134().canCompleteCircuit(gas, cost));
        System.out.println("Expected: -1");

    }
}
