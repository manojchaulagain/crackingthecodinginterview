package com.tutorial.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};

        List<List<Integer>> list = new ArrayList<>();
        permute(nums, 0, list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void permute(int[] nums, int k, List<List<Integer>> list) {
        if (nums.length == k) {
            List<Integer> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }
            list.add(numList);
        }
        for (int i = k; i < nums.length; i++) {
            if (shouldSwap(nums, i, k)) {
                swap(nums, i, k);
                permute(nums, k + 1, list);
                swap(nums, k, i);
            }
        }
    }

    public static boolean shouldSwap(int[] arr, int i, int j) {
        for (int k = i; k < j; k++) {
            if (arr[k] == arr[j]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
