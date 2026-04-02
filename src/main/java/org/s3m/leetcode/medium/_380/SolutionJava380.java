package org.s3m.leetcode.medium._380;


import java.util.*;

public class SolutionJava380 {

    class RandomizedSet {
        private Random random;
        private List<Integer> list;
        private Map<Integer, Integer> map;
        public RandomizedSet() {
            random = new Random();
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int last = list.size() - 1;
            list.set(index, list.get(last));
            map.put(list.get(index), index);
            list.remove(last);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {

        // Example 1


    }
}
