package com.tutorial.algorithms.graph;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-25
 * Time: 00:32
 */
public class XX {

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


    static char[] arr = {'a', 'n', 'd', ' ', 'i', 's', ' ', 's', 'a', 'n', 'd'};

    public static void main(String[] args) {

        flipArr(arr, 0, arr.length - 1);
        int cacheIndex = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == ' ') {
                flipArr(arr, cacheIndex, i);
                cacheIndex = i + 1;
            }

        }
        flipArr(arr, cacheIndex, arr.length - 1);
        System.out.println(String.valueOf(arr));
    }

    private static void flipArr(char[] arr, int start, int right) {
        int l = start;
        int r = right;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }



   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
