package com.tutorial.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

        Item(int count, String category) {
            this.count = count;
            this.category = category;
            subCatMap = new HashMap<>();
        }
    }

    class ItemTree {

        Item head;

        ItemTree() {
            head = new Item(0, "");
        }

        void addItem(String category) {
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

        void printItemsCount() {
            Item curr = head;
            System.out.println("-----------------------------------");
            printNodeCount("", curr);
            System.out.println("-----------------------------------");
            printItemsCountDFS();
            System.out.println("-----------------------------------");
            printItemsCountBFS();
        }

        void printItemsCountDFS() {
            Item curr = head;
            Stack<Item> stack = new Stack<>();
            stack.add(curr);
            while (!stack.isEmpty()) {
                curr = stack.pop();
                stack.addAll(curr.subCatMap.values());
                System.out.println(curr.category + " " + curr.count);
            }
        }

        void printItemsCountBFS() {
            Item curr = head;
            Queue<Item> stack = new LinkedList<>();
            stack.add(curr);
            while (!stack.isEmpty()) {
                Item pop = stack.poll();
                System.out.println(pop.category + " " + pop.count);
                stack.addAll(pop.subCatMap.values());
            }
            String s = "10";
            System.out.println(s.charAt(0) == '1');
            System.out.println(s.charAt(1) == '0');
            System.out.println((char) 966);
        }

        void printNodeCount(String val, Item node) {
            System.out.println(val + " " + node.count);
            node.subCatMap.values().forEach(n -> printNodeCount(val + "/" + n.category, n));
        }


    }
}