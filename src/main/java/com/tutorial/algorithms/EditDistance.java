package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-05
 * Time: 09:36
 */
public class EditDistance {

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
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(distance(str1, str2, str1.length(), str2.length()));

    }

    private static int distance(String str1, String str2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (str1.charAt(m -1) == str2.charAt(n- 1)) {
            return distance(str1, str2, m - 1, n - 1);
        }

        return 1 + Math.min(distance(str1, str2, m - 1, n), Math.min(distance(str1, str2, m, n - 1), distance(str1, str2, m - 1, n - 1)));
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
