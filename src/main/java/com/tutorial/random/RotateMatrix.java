package com.tutorial.random;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
//                int temp =
                matrix[row][col] = matrix[matrix[row].length - col -1][row];
            }
        }
//        matrix = rotatedMatrix;

    }
}
