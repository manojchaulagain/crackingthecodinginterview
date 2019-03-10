package com.tutorial.algorithms;

class Solution {

    public static int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length(), word2.length());
    }

    private static int minDistance(String word1, String word2, int m, int n) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return minDistance(word1, word2, m - 1, n - 1);
        }

        return 1 + Math.min(Math.min(minDistance(word1, word2, m, n - 1), minDistance(word1, word2, m - 1, n)), minDistance(word1, word2, m - 1, n - 1));
    }
}