package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-16
 * Time: 01:39
 */
public class InterleavingStrings {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public static void main(String[] args) {
        String x = "AB";
        String y = "CD";
        String s = "ACBDE";

        System.out.println(isInterleavedStrings(x, y, s));
    }

    private static boolean isInterleavedStrings(String x, String y, String s) {
        if (x.length() == 0 && y.length() == 0 && s.length() == 0) {
            return true;
        }
        if(s.length() == 0) {
            return false;
        }
        if (x.length() != 0 && x.charAt(0) == s.charAt(0)) {
            return isInterleavedStrings(x.substring(1), y, s.substring(1));
        }

        if (y.length() != 0 && y.charAt(0) == s.charAt(0)) {
            return isInterleavedStrings(x, y.substring(1), s.substring(1));
        }
        return false;
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
