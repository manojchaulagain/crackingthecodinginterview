package com.tutorial.random;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class WordJumper {

    private static Logger logger = Logger.getLogger(WordJumper.class);

    private static Set<String> words = new HashSet<>();

    public static void main(String[] args) {
        String word = "am";
        String finalWord = "it";
        WordJumper wordJumper = new WordJumper();
        wordJumper.loadDictionary("src/main/resources/words_alpha.txt");
        System.out.println(wordJumper.routeBetweenTwoWords(word, finalWord));
    }

    public boolean routeBetweenTwoWords(String startString, String target) {
        Set<String> foundWords = new HashSet<>();
        findAllOneLetterChanges(startString, foundWords, target);
        boolean foundRoute = foundWords.contains(startString) && foundWords.contains(target);
        System.out.println(foundWords.size());
        System.out.println(foundRoute);
        return foundRoute;
    }

    private void findAllOneLetterChanges(String word, final Set<String> foundWords, final String target) {
        final Stack<String> stack = new Stack<>();
        stack.push(word);
        boolean found = false;
        while (!stack.empty()) {
            final String stackWord = stack.pop();
            if (stackWord.equalsIgnoreCase(target)) {
                found = true;
            }
            if (!found) {
                System.out.print(stackWord + " -> ");
            }
            for (int j = 0; j < stackWord.length(); j++) {
                for (char i = 'a'; i <= 'z'; i++) {
                    String newWord = swap(stackWord, j, i);
                    if (words.contains(newWord)) {
                        if (!newWord.equalsIgnoreCase(stackWord) && !foundWords.contains(newWord)) {
                            stack.push(newWord);
                        }
                        foundWords.add(newWord);
                    }
                }
            }
        }
    }

    public void loadDictionary(String fileName) {
        final File file = new File(fileName);
        try {
            final Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            logger.error("The file with " + fileName + " was not found.", e);
        }
    }

    private String swap(String val, int l, char c) {
        char[] charArray = val.toCharArray();
        charArray[l] = c;
        return String.valueOf(charArray);
    }

}
