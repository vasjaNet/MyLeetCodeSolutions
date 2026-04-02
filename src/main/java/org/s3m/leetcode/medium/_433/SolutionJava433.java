package org.s3m.leetcode.medium._433;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionJava433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        queue.offer(startGene);
        int count = 0;
        while(!queue.isEmpty()) {
            for (int m = queue.size(); m > 0; --m) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return count;
                }
                for (String bankGene : bank) {
                    int diff = 0;
                    for (int i = 0; i < 8 && diff < 2; i++) {
                        if (gene.charAt(i) != bankGene.charAt(i)) {
                            diff++;
                        }
                    }
                    if (diff < 2 && !visited.contains(bankGene)) {
                        queue.offer(bankGene);
                        visited.add(bankGene);
                    }
                }
            }
            count++;
        }
        return -1;
    }



    public static void main(String[] args) {

        // Example 1
        String[] bank = {"AACCGGTA"};
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        System.out.println("Input:    " + startGene + ", " + endGene + ", " + bank);
        System.out.println("Output:   " + new SolutionJava433().minMutation(startGene, endGene, bank));
        System.out.println("Expected: 1");

        // Example 2
        startGene = "AACCGGTT";
        endGene = "AAACGGTA";
        bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println("Input:    " + startGene + ", " + endGene + ", " + bank);
        System.out.println("Output:   " + new SolutionJava433().minMutation(startGene, endGene, bank));
        System.out.println("Expected: 2");

    }
}
