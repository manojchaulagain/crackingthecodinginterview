package com.tutorial.algorithms;

import java.util.*;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-19
 * Time: 13:27
 */
public class HashTest {

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
        List<String> requestIds = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            requestIds.add(UUID.randomUUID().toString());
        }
        int n = 3;
        Map<String, Integer> map = new HashMap<>();
        for (String id : requestIds) {
            map.put(id, Math.abs(id.hashCode() % n));
        }

//        map.forEach((k, v) -> {
//            System.out.println("Req:" + k + " -> Server:" + v);
//        });

        HashMap<Integer, Integer> count = new HashMap<>();
        map.values().forEach(x -> {
            if (count.containsKey(x)) {
                int c = count.get(x);
                count.put(x, c + 1);
            } else {
                count.put(x, 1);
            }
        });

        count.forEach((x, y) -> System.out.println(x + " -> " + y));
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
