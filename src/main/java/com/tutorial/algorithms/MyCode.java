package com.tutorial.algorithms;

import java.util.HashMap;
import java.util.Map;

class MyCode {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        buildMap(arr, x -> 2 * x + 1).forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static Map<Integer, Integer> buildMap(int[] arr, FunctionInterface<Integer, Integer> stn) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, stn.process(a));
        }
        return map;
    }


    interface FunctionInterface<T, X> {
        X process(T x);
    }
}
