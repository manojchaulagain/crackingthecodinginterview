package com.tutorial.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrieTestRunner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/words.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                trie.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        trie.getHead().children.size();
        System.out.println(trie.search("aaaaaa"));
        List<String> words = trie.searchWords("aa");
        System.out.println(Arrays.toString(words.toArray()));
        System.out.println(words.size());
    }
}
