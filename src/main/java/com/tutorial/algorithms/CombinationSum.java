package com.tutorial.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-12
 * Time: 12:08
 */
public class CombinationSum {

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
        int[] candidates = {10, 1, 2, 7,8, 6, 5, 1};
        int target = 8;
        System.out.println(Arrays.toString(combinationSum(candidates, target).toArray()));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSum(candidates, target, currentList, combinations, 0);
        return combinations;
    }

    private static void combinationSum(int[] candidates, int target, List<Integer> cur, List<List<Integer>> cb, int i) {
        int curSum = 0;
        for (int num : cur) {
            curSum += num;
        }

        if (curSum == target) {
            cb.add(cur);
        } else if (curSum < target) {
            for (int x = i + 1; x < candidates.length; x++) {
                List<Integer> list = new ArrayList<>(cur);
                if (!list.contains(candidates[x])) {
                    list.add(candidates[x]);
                    combinationSum(candidates, target, list, cb, x);
                }
            }
        }
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
