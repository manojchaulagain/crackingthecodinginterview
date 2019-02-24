package com.tutorial.random;

public class StringAllUniqueChars {

    public static void main(String[] args) {
        String val = "z";
        System.out.println(hasAllUniquesChars(val));
        System.out.println(hasAllUniquesCharsOnTime(val));
    }

    private static boolean hasAllUniquesChars(String val) {
        for (int i = 0; i < val.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (val.charAt(i) == val.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasAllUniquesCharsOnTime(String val) {
        boolean[] charsSet = new boolean[128];
        for (int i = 0; i < val.length(); i++) {
            if (charsSet[val.charAt(i)]) {
                return false;
            }
            charsSet[val.charAt(i)] = true;
        }
        return true;
    }

}
