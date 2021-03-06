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
        String word = "mat";
        String finalWord = "nat";
        WordJumper wordJumper = new WordJumper();
        wordJumper.loadDictionary("src/main/resources/words_alpha.txt");
        System.out.println(wordJumper.routeBetweenTwoWords(word, finalWord));
    }

    public boolean routeBetweenTwoWords(String startString, String target) {
        return findAllOneLetterChanges(startString, target);
    }

    private boolean findAllOneLetterChanges(String origin, final String target) {
        final Stack<String> stack = new Stack<>();
        stack.push(origin);
        Set<String> stackWords = new HashSet<>();
        int count = 0;
        while (!stack.isEmpty()) {
            final String stackWord = stack.pop();
            count++;
            stackWords.add(stackWord);
            if (!stackWord.equalsIgnoreCase(target)) {
                System.out.print(stackWord + " -> ");
            } else {
                System.out.println(stackWord);
                System.out.println(count);
                return true;
            }
            for (int j = 0; j < stackWord.length(); j++) {
                for (char i = 'a'; i <= 'z'; i++) {
                    if (stackWord.charAt(j) != i) {
                        String newWord = swap(stackWord, j, i);
                        if (words.contains(newWord) && !stackWords.contains(newWord) && !newWord.equalsIgnoreCase(stackWord))
                            stack.push(newWord);

                    }
                }
            }
        }
        return false;
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
