package com.tutorial.random;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrieRunner {

    private static Logger logger = Logger.getLogger(TrieRunner.class);

    public static void main(String[] args) {
        CustomTrie trie = new CustomTrie();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/words.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                trie.add(line);
            }
            logger.info("Finished building trie.....");
        } catch (FileNotFoundException e) {
            logger.error("Could not load the words file", e);
        }
        System.out.println(trie.search("aaa"));
        List<String> words = trie.searchWords("understa");
        System.out.println(Arrays.toString(words.toArray()));
        System.out.println(words.size());
    }
}
