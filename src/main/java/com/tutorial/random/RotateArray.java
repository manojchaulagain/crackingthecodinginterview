package com.tutorial.random;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] rotated = new int[arr.length];
        int rotate = 4;
        for(int i = 0; i < arr.length; i++) {
            int rotateIndex = i - rotate;
            if(rotateIndex < 0) {
                rotateIndex = rotateIndex + arr.length;
            }
            rotated[rotateIndex] = arr[i];
        }

        System.out.println(rotated);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}