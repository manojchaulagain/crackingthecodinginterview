package com.tutorial.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringNoRepeat {

//    public static void main(String[] args) {
//        String val = "pwwkew";
//        int max = 0;
//        for (String temp : getSubstrings(val)) {
//            max = max < temp.length() ? temp.length() : max;
//        }
//        System.out.println(max);
//    }

    public static void main(String[] args) {
        String val = "pwwkew";
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < val.length(); i++) {
            if (map.containsKey(val.charAt(i))) {
                j = Math.max(map.get(val.charAt(i)), j);
            }
            max = Math.max(max, i - j + 1);
            map.put(val.charAt(i), i + 1);
        }
        System.out.println(max);
    }

    private static List<String> getSubstrings(String val) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < val.length(); i++) {
            for (int j = i; j < val.length(); j++) {
                String subVal = val.substring(i, j + 1);
                if (hasAllUniqueStrings(subVal)) {
                    substrings.add(subVal);
                }
            }
        }
        return substrings;
    }

    private static boolean hasAllUniqueStrings(String val) {
        Map<Character, Integer> map = new HashMap<>();
        for (char charVal : val.toCharArray()) {
            if (map.containsKey(charVal)) {
                return false;
            } else {
                map.put(charVal, 1);
            }
        }
        return true;
    }
}
