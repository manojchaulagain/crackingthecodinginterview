package com.tutorial.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortRetailItems {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/item.csv"));
        String header = scanner.nextLine();
        SortRetailItems sortRetailItems = new SortRetailItems();

        ItemTree itemTree = sortRetailItems.new ItemTree();
        while (scanner.hasNext()) {
            String[] itemInfos = scanner.nextLine().split(",");
            String category = itemInfos[2];
            itemTree.addItem(category);
        }

        itemTree.printItemsCount();
    }

    class Item {
        int count;
        String category;
        Map<String, Item> subCatMap;

        public Item(int count, String category) {
            this.count = count;
            this.category = category;
            subCatMap = new HashMap<>();
        }
    }

    class ItemTree {

        Item head;

        public ItemTree() {
            head = new Item(0, "");
        }

        public void addItem(String category) {
            Item curr = head;
            curr.count += 1;
            while (category.contains("/")) {
                String key = category.substring(0, category.indexOf("/"));
                if (curr.subCatMap.containsKey(key)) {
                    curr = curr.subCatMap.get(key);
                    curr.count += 1;
                } else {
                    curr.subCatMap.put(key, new Item(1, key));
                    curr = curr.subCatMap.get(key);
                }
                category = category.substring(category.indexOf("/") + 1);
            }
            if (curr.subCatMap.containsKey(category)) {
                curr = curr.subCatMap.get(category);
                curr.count += 1;
            } else {
                curr.subCatMap.put(category, new Item(1, category));
            }
        }

        public void printItemsCount() {
            Item curr = head;
            printNodeCount("", curr);
        }

        public void printNodeCount(String val, Item node) {
            System.out.println(val + " " + node.count);
            node.subCatMap.values().forEach(n -> printNodeCount(val + "/" + n.category, n));
        }


    }
}