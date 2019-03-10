package com.tutorial.algorithms;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-08
 * Time: 16:46
 */
public class CountWays {

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
        int n = 3;
        System.out.println(countWays(n));
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n, ways));
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public static int countWays(int n, int[] ways) {

        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (ways[n] > -1) {
            return ways[n];
        } else {
            ways[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
            return ways[n];
        }
    }

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
