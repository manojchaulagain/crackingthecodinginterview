package com.tutorial.random;

import java.util.Arrays;

public class TwoDArray {


    public static void main(String[] args) {
        int[][] arr = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, 2, -8, -6, -7}
        };
        hourglassSum(arr);
    }

    private static void hourglassSum(int[][] arr) {
        int[][] sumArr = new int[4][4];
        int sum = -Integer.MAX_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                int newSum =
                        arr[j - 1][i - 1] + arr[j - 1][i] + arr[j - 1][i + 1] + arr[j][i] + arr[j + 1][i - 1] + arr[j
                                + 1][i] + arr[j + 1][i + 1];
                sum = sum < newSum ? newSum : sum;
                sumArr[j - 1][i - 1] = newSum;
            }
        }
        System.out.println(Arrays.deepToString(sumArr));
    }
}
