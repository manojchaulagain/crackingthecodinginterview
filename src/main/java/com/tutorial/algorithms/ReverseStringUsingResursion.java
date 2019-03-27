package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-16
 * Time: 02:49
 */
public class ReverseStringUsingResursion {

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
        String val = "This is a string reversal using recursion.";
        StringBuilder sb = new StringBuilder();
        System.out.println(recurseUsingRecursion(val, sb));

    }

    private static String recurseUsingRecursion(String val, StringBuilder sb) {
        if (val.length() == 0) {
            return sb.toString();
        }
        sb.insert(0, val.charAt(0));
        return recurseUsingRecursion(val.substring(1), sb);
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
