package com.tutorial.random;

public class HashMap {

    public static void main(String[] args) {
        System.out.println(getHashValue("c"));
    }

    public static int getHashValue(String val) {
        int hash = 7;
        for (int i = 0; i < val.length(); i++) {
            hash = hash * 31 + val.charAt(i);
        }
        return hash;
    }

}
