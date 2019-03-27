package com.tutorial.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-25
 * Time: 11:53
 */
public class GenerateListMap {

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
        int[] arr = {1, 2, 3, 4, 5};
        buildMap(arr, x -> x * x).forEach((x, k) -> System.out.println(x + " -> " + k));

    }

    public static Map<Integer, Integer> buildMap(int[] arr, TestInterface testInterface) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, testInterface.square(x));
        }
        return map;
    }

    interface TestInterface {
        int square(int x);
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
