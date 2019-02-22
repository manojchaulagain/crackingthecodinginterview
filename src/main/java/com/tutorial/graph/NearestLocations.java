package com.tutorial.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NearestLocations {

    public static void main(String[] args) {
        final List<List<Integer>> coordinates = new ArrayList<>();
        coordinates.add(toList(new int[]{1, 2}));
        coordinates.add(toList(new int[]{2, 1}));
        coordinates.add(toList(new int[]{3, 7}));
        coordinates.add(toList(new int[]{5, 2}));
        coordinates.add(toList(new int[]{6, 1}));
        coordinates.add(toList(new int[]{5, 4}));
        coordinates.add(toList(new int[]{7, 2}));

        coordinates.stream().sorted(Comparator.comparingInt(o -> o.get(0) * o.get(0) + o.get(1) * o.get(1))).forEach(o -> {
            int dist = o.get(0) * o.get(0) + o.get(1) * o.get(1);
            System.out.println(Arrays.toString(o.toArray()) + " -> " + dist);
        });
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        for (int i : arr) {
            nums.add(i);
        }
        return nums;
    }

}

