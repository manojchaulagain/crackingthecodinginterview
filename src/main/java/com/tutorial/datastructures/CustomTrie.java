package com.tutorial.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * An implementation of the Trie
 */
public class CustomTrie {

    private TrieNode head;

    /**
     * Constructs the trie with head initialized with empty string
     */
    public CustomTrie() {
        head = new TrieNode("");
    }

    /**
     * Adds the word to the trie
     *
     * @param word A word to be added to the trie
     */
    public void add(String word) {
        TrieNode curr = head;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode(curr.content + c));
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    /**
     * Checks if the given word exists in the trie
     *
     * @param word A word to be searched
     * @return Returns boolean value if the given word exists in the trie
     */
    public boolean contains(String word) {
        TrieNode curr = searchTrieNode(word);
        return curr != null && curr.isWord;
    }

    /**
     * Searches all the words starting with the given prefix
     *
     * @param prefix The prefix for which the words to be searched
     * @return The list of words starting with the given prefix
     */
    public List<String> searchWords(String prefix) {
        TrieNode curr = searchTrieNode(prefix);
        List<String> words = new ArrayList<>();
        if (curr != null) {
            Stack<TrieNode> stack = new Stack<>();
            stack.push(curr);
            while (!stack.isEmpty()) {
                curr = stack.pop();
                if (curr.isWord) {
                    words.add(curr.content);
                }
                curr.children.values().forEach(stack::push);
            }
        }
        return words;
    }

    /**
     * Searches the node in the trie with the prefix
     *
     * @param prefix The prefix to be searched
     * @return The node associated with the prefix
     */
    private TrieNode searchTrieNode(String prefix) {
        TrieNode curr = head;
        for (char c : prefix.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) {
                break;
            }
        }
        return curr;
    }

    /**
     * A node that represents the node of a trie
     */
    class TrieNode {
        /**
         * Value associated with the node
         */
        String content;
        /**
         * A boolean value representing if the node represents a word
         */
        boolean isWord;
        /**
         * A map representing the children of the node
         */
        HashMap<Character, TrieNode> children;

        /**
         * Constructs a Trie node
         *
         * @param content The word associated with the node
         */
        TrieNode(final String content) {
            this.content = content;
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

}
