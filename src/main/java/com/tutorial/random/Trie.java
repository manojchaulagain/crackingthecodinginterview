package com.tutorial.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Trie {

    private Node head;

    public Trie() {
        head = new Node("", false, new HashMap<>());
    }

    public void add(String val) {
        Node curr = head;
        List<String> chunks = chunksList(val);
        for (String chunk : chunks) {

            Node node = curr.children.get(chunk);
            if (node == null) {
                curr.children.put(chunk, new Node(chunk, val.equalsIgnoreCase(chunk), new HashMap<>()));
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
        Node curr = head;
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

    public Node getHead() {
        return head;
    }

    private List<String> chunksList(String val) {
        List<String> chunks = new ArrayList<>();
        IntStream.range(0, val.length()).forEach(i -> chunks.add(val.substring(0, i + 1).toLowerCase()));
        return chunks;
    }

    public class Node {

        String key;
        boolean isWord;
        Map<String, Node> children;

        Node(final String key, final boolean isWord, Map<String, Node> children) {
            this.key = key;
            this.isWord = isWord;
            this.children = children;
        }
    }

}
