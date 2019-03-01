package com.tutorial.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-02-28
 * Time: 14:52
 */
public class SortRetailItemsMapImpl {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

    /*--------------------------------------------
     |    I N S T A N C E   V A R I A B L E S    |
     ============================================*/
    private static HashMap<String, Integer> itemCountMap = new HashMap<>();

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    /*--------------------------------------------
     |   P U B L I C    A P I    M E T H O D S   |
     ============================================*/
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/item.csv"));
        String header = scanner.nextLine();
        while (scanner.hasNext()) {
            String[] itemInfos = scanner.nextLine().split(",");
            String key = itemInfos[2];
            String[] keyItems = key.split("/");
            StringBuilder sb = new StringBuilder();
            for (String keyItem : keyItems) {
                sb.append("/").append(keyItem);
                String categoryKey = sb.toString();
                if (itemCountMap.containsKey(categoryKey)) {
                    int count = itemCountMap.get(categoryKey);
                    itemCountMap.put(categoryKey, count + 1);
                } else {
                    itemCountMap.put(categoryKey, 1);
                }
            }
        }
        itemCountMap.keySet().stream().sorted().forEach(key -> System.out.println(key+ " " + itemCountMap.get(key)));
    }


   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
