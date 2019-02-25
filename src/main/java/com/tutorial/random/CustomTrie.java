package com.tutorial.random;

import java.util.HashMap;
import java.util.*;

public class CustomTrie {

    private TrieNode head;

    public CustomTrie() {
        head = new TrieNode("", false, new HashMap<>());
    }

    public void add(String val) {
        TrieNode curr = head;
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode(val.substring(0, i + 1), i == val.length() - 1, new HashMap<>()));

            }
            curr = curr.children.get(c);
        }
    }

    public boolean search(String val) {
        TrieNode curr = head;
        for (char c : val.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) {
                break;
            }
        }
        return curr != null && curr.isWord;
    }

    public List<String> searchWords(String prefix) {
        TrieNode curr = head;
        List<String> words = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) {
                break;
            }
        }
        if (curr != null) {
            searchWords(curr, words);
        }
        return words;
    }

    private void searchWords(TrieNode prefixTrieNode, List<String> words) {
        Stack<TrieNode> stack = new Stack<>();
        stack.push(prefixTrieNode);
        while (!stack.isEmpty()) {
            TrieNode curr = stack.pop();
            if (curr.isWord) {
                words.add(curr.content);
            }
            curr.children.values().forEach(stack::push);
        }
//        prefixTrieNode.children.values().forEach(childNode -> searchWords(childNode, words));
    }

    public class TrieNode {

        String content;
        boolean isWord;
        Map<Character, TrieNode> children;

        TrieNode(final String content, final boolean isWord, Map<Character, TrieNode> children) {
            this.content = content;
            this.isWord = isWord;
            this.children = children;
        }
    }

}
