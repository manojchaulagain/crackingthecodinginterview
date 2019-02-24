package com.tutorial.random;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static void main(String[] args) {
        String val = "Tact Coa";
        PalindromePermutation isPalindromePermutation = new PalindromePermutation();
        System.out.println(isPalindromePermutation.isPalindromePermutation(val));
    }

    public boolean isPalindromePermutation(String val) {
        val = val.toLowerCase();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            if (countMap.containsKey(c)) {
                int count = countMap.get(c);
                countMap.put(c, count + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        int oddCount = 0;
        for (int count : countMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
