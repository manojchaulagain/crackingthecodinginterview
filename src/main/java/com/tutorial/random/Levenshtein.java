package com.tutorial.random;

public class Levenshtein {

    public static void main(String[] args) {
        String value1 = "Honda";
        String value2 = "Hyundai";
        int[][] distance = new int[value1.length()][value2.length()];
        System.out.println(calculateDistance(value1, value2, distance));
    }

    private static int calculateDistance(String value1, String value2, int[][] distance) {
        for (int i = 0; i < value1.length(); i++) {
            for (int j = 0; j < value2.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else {
                    int costOfSubstitution = value1.charAt(i) == value2.charAt(j) ? 0 : 1;
                    distance[i][j] =
                            Math.min(Math.min(distance[i - 1][j - 1] + costOfSubstitution, distance[i - 1][j] + 1),
                                    distance[i][j - 1] + 1);
                }
            }
        }
        return distance[value1.length() - 1][value2.length() - 1];
    }
}
