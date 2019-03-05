package com.tutorial.algorithms;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-05
 * Time: 13:30
 */
public class CustomTreeMapComparator {

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
        String[] list = {"Chase", "Bank of America", "Well Fargo"};
        Map<String, Map<String, Integer>> countMap = new HashMap<>();
        int x = 1;
        for (String s : list) {
            Map<String, Integer> map = new HashMap<>();
            map.put("Bean" + x, 20);
            map.put("Crops" + x, 90);
            map.put("Soy" + x, 40);
            map.put("Paddy" + x, 60);
            map.put("Rice" + x, 50);
            x++;
            countMap.put(s, map);
        }
        AtomicInteger i = new AtomicInteger(1);
        countMap.forEach((key, value) -> {
            entriesSortedByValue(value).stream().limit(i.get()).forEach(System.out::println);
            i.getAndIncrement();
            System.out.println();
        });
    }
    
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

    private static <K extends Comparable<? super K>, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValue(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(Comparator.comparing(Map.Entry::getKey));
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/
}
