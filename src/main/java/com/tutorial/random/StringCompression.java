package com.tutorial.random;

public class StringCompression {

    public static void main(String[] args) {
        String val = "daaabcccccaaac";
        StringCompression sc = new StringCompression();
        System.out.println(sc.compressString(val));
    }

    public String compressString(String val) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int j = 0, i = 0; i < val.length(); i++) {
            if (val.charAt(i) == val.charAt(j)) {
                count++;
            } else {
                sb.append(val.charAt(j)).append(count);
                count = 1;
                j = i;
            }
            if (i == val.length() - 1) {
                sb.append(val.charAt(j)).append(count);
            }
        }
        return sb.toString();
    }
}
