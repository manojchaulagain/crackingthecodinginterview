package com.tutorial.algorithms;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-05
 * Time: 23:43
 */
public class RotateMatrix {

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
        // Test Case 1
//        int a[][] = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };

        // Tese Case 2
        int a[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrix(a.length, a[0].length, a);

    }

    private static void rotateMatrix(int r, int c, int[][] a) {
        int n = a.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = a[first][i];
                a[first][i] = a[last - offset][first];
                a[last - offset][first] = a[last][last - offset];
                a[last][last - offset] = a[i][last];
                a[i][last] = top;
            }
        }

        System.out.println(Arrays.toString(a));
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
