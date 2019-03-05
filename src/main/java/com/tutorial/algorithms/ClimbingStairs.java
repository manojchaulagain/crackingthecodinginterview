package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-04
 * Time: 16:06
 */
public class ClimbingStairs {

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
        int[] memo = new int[n + 1];
        System.out.println(climbingWays(n, memo));
        System.out.println(climbingWaysDP(n));
    }

    private static int climbingWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if(memo[n] > 0) {
            return memo[n];
        }
        memo[n] = climbingWays(n - 1, memo) + climbingWays(n - 2, memo) + climbingWays(n - 3, memo);
        return memo[n];
    }

    private static int climbingWaysDP(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int[] paths = new int[n + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= n; i++) {
            paths[i] = paths[i -1] + paths[i -2] + paths[i -3];
        }
        return paths[n];
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
