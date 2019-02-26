package com.tutorial.datastructures;

import java.util.*;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Trie {

    private TrieNode head;

    public Trie() {
        head = new TrieNode("", false, new HashMap<>());
    }

    public void add(String val) {
        TrieNode curr = head;
        List<String> chunks = chunksList(val);
        for (String chunk : chunks) {
            TrieNode trieNode = curr.children.get(chunk);
            if (trieNode == null) {
                curr.children.put(chunk, new TrieNode(chunk, val.equalsIgnoreCase(chunk), new HashMap<>()));
                curr = curr.children.get(chunk);
            } else {
                curr = curr.children.get(chunk);
                if (curr.key.equalsIgnoreCase(val)) {
                    curr.isWord = true;
                }
            }
        }
    }

    public boolean search(String val) {
        boolean found = false;
        TrieNode curr = head;
        List<String> chunks = chunksList(val);
        for (String chunk : chunks) {
            if (curr != null && curr.children != null) {
                curr = curr.children.get(chunk);
                if (curr == null) {
                    break;
                } else {
                    if (curr.key.equalsIgnoreCase(val)) {
                        found = true;
                        break;
                    }
                }
            }
        }
        return found;
    }

    public List<String> searchWords(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode curr = head;
        boolean found = false;
        List<String> chunks = chunksList(prefix);
        for (String chunk : chunks) {
            if (curr != null && curr.children != null) {
                curr = curr.children.get(chunk);
                if (curr == null) {
                    break;
                } else {
                    if (curr.key.equalsIgnoreCase(prefix)) {
                        found = true;
                        break;
                    }
                }

            }
        }
        if (found) {
            searchWords(curr, words);
        }

        return words;
    }

    private void searchWords(TrieNode prefixTrieNode, List<String> words) {
        Stack<TrieNode> stack = new Stack<>();
        stack.push(prefixTrieNode);
        while (!stack.isEmpty()) {
            TrieNode curr = stack.pop();
            if(curr.isWord) {
                words.add(curr.key);
            }
            curr.children.values().forEach(stack::push);
        }
//        prefixTrieNode.children.values().forEach(childNode -> searchWords(childNode, words));
    }

    private List<String> chunksList(String val) {
        List<String> chunks = new ArrayList<>();
        IntStream.range(0, val.length()).forEach(i -> chunks.add(val.substring(0, i + 1).toLowerCase()));
        return chunks;
    }

    public class TrieNode {

        String key;
        boolean isWord;
        Map<String, TrieNode> children;

        TrieNode(final String key, final boolean isWord, Map<String, TrieNode> children) {
            this.key = key;
            this.isWord = isWord;
            this.children = children;
        }
    }

}
