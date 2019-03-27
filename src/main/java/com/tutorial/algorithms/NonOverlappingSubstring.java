package com.tutorial.algorithms;

import java.util.ArrayList;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-16
 * Time: 00:58
 */
public class NonOverlappingSubstring {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    public static void main(String[] args) {
        String s = "ABCDE";
        int x = 3;
        int y = 5;
        System.out.println("x " + x + ", y " + y);
        x = x ^ y;
        System.out.println("x " + x + ", y " + y);

        y = x ^ y;
        System.out.println("x " + x + ", y " + y);

        x = x ^ y;
        System.out.println("x " + x + ", y " + y);


//        printAllNonOverlappingSubstrings(s, new ArrayList<>());
    }

    private static void printAllNonOverlappingSubstrings(String s, ArrayList<String> out) {
        if (s.length() == 0) {
            System.out.println(out);
        }
        for (int i = 0; i < s.length(); i++) {
            out.add(s.substring(0, i + 1));
            printAllNonOverlappingSubstrings(s.substring(i + 1), out);
            out.remove(out.size() - 1);
        }
    }



   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
