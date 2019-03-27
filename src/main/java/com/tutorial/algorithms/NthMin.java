package com.tutorial.algorithms;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-12
 * Time: 20:38
 */
public class NthMin {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    private static int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public static void main(String[] args) {
        int n = 11;
        int min = findNthMin(arr, n);
        System.out.println(min);

    }

    private static int findNthMin(int[] arr, int n) {
        Arrays.sort(arr);
        if (arr.length >= n && n > 0) {
            return arr[n - 1];
        }
        return -1;
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
