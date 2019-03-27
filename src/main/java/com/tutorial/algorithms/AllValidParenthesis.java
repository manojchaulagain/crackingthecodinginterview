package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-16
 * Time: 00:00
 */
public class AllValidParenthesis {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

   static int count = 0;
   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public static void main(String[] args) {
        int n = 10;
        printAllValidParentheses("", n, 0);
        System.out.println(count);
    }

    private static void printAllValidParentheses(String val, int n, int open) {
        count++;
        if (open > n) {
            return;
        }
        if (n == 0 && open == 0) {
            System.out.println(val);
            return;
        }
        printAllValidParentheses(val + "(", n - 1, open + 1);
        if (open > 0) {
            printAllValidParentheses(val + ")", n - 1, open - 1);
        }
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
