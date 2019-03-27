package com.tutorial.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneKeyPad {

    private Map<String, String> phone = new HashMap<>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    private List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);

        }
        return output;
    }

    public void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = digits.substring(0, 1);

            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                backtrack(combination + letters.charAt(i), digits.substring(1));
            }
        }

    }
}