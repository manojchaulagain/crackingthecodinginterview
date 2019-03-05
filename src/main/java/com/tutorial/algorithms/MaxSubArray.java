package com.tutorial.algorithms;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-02
 * Time: 21:51
 */
public class MaxSubArray {

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
        int[] nums = {2, 2, 1, 3, 1, 1, 1};
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(max, cur);
        }
        System.out.println(max);
        int num = 0;
        for (int a : nums) {
            num ^= a;
        }

        num = 2 ^ 3;
        num = num ^ 3;

        System.out.println(num);

        int n = 30;
        boolean[] bulbs = new boolean[n];
        int k = 1;
        int index = 0;
        while (index < n) {
            index = k * k - 1;
            if (index < n) {
                bulbs[index] = true;
            }
            k++;
        }

//        for (int i = 1; i <= n; i++) {
//            int j = i - 1;
//            while (j < n) {
//                bulbs[j] = !bulbs[j];
//                j += i;
//            }
//        }
//        int count = 0;
//        for (boolean bulb : bulbs)
//            if (bulb) {
//                count++;
//            }
//        System.out.println(count);
        System.out.println(Arrays.toString(bulbs));
        System.out.println(3 | 2);
        System.out.println(3 & 2);
        System.out.println(5 ^ 2);
        System.out.println(6 >> 1);
        System.out.println(4 << 1);
        System.out.println(~5);
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
