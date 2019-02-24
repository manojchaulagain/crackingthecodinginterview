package com.tutorial.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Disjoint {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));
            DisjointSet disjointSet = new Disjoint().new DisjointSet();
            String line = scanner.nextLine();
            String[] stringNums = line.split(" ");
            for (int i = 0; i < Integer.parseInt(stringNums[0]); i++) {
                Set<Integer> integers = new HashSet<>();
                integers.add(i);
                disjointSet.addSet(integers);
            }
            int j = Integer.parseInt(stringNums[1]);
            while (j > 0) {
                line = scanner.nextLine();
                if (line.charAt(0) == 'Q') {
                    String[] nums = line.split(" ");
                    System.out.println(disjointSet.query(Integer.parseInt(nums[1])));
                } else if (line.charAt(0) == 'M') {
                    String[] nums = line.split(" ");
                    disjointSet.merge(Integer.parseInt(nums[1]), Integer.parseInt(nums[2]));
                }
                j--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    class DisjointSet {
        private List<Set<Integer>> nodes = new ArrayList<>();

        void merge(int a, int b) {
            Optional<Set<Integer>> aContainingSet = nodes.stream().filter(x -> x.contains(a)).findAny();
            Optional<Set<Integer>> bContainingSet = nodes.stream().filter(x -> x.contains(b)).findAny();
            if (aContainingSet.isPresent() && bContainingSet.isPresent()) {
                nodes.remove(aContainingSet.get());
                nodes.remove(bContainingSet.get());
                Set<Integer> numSet = new HashSet<>();
                numSet.addAll(aContainingSet.get());
                numSet.addAll(bContainingSet.get());
                nodes.add(numSet);
            } else if (aContainingSet.isPresent()) {
                aContainingSet.get().add(b);
            } else if (bContainingSet.isPresent()) {
                bContainingSet.get().add(a);
            } else {
                Set<Integer> numSet = new HashSet<>();
                numSet.add(a);
                nodes.add(numSet);

                Set<Integer> numSet2 = new HashSet<>();
                numSet.add(b);
                nodes.add(numSet2);
            }


        }

        int query(int a) {
            Optional<Set<Integer>> node1 = nodes.stream().filter(x -> x.contains(a)).findAny();
            if (node1.isPresent()) {
                return node1.get().size();
            }

            Set<Integer> numSet = new HashSet<>();
            numSet.add(a);
            nodes.add(numSet);
            return 1;
        }

        void addSet(Set<Integer> nums) {
            nodes.add(nums);
        }
    }


}
