package com.tutorial.random;

public class StringPermutation {

    public static void main(String[] args) {
        String s1 = "helo";
        String s2 = "omeh";
        StringPermutation stringPermutation = new StringPermutation();
        System.out.println(stringPermutation.isPermutation(s1, s2));
    }

    private boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            int[] vals = new int[128];
            for (int i = 0; i < s2.length(); i++) {
                vals[s2.charAt(i)]++;
            }
            for (int i = 0; i < s1.length(); i++) {
                vals[s1.charAt(i)]--;
                if (vals[s1.charAt(i)] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
