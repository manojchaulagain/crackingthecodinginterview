package com.tutorial.datastructures;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<K, V> implements CustomMap<K, V> {

    private List<HashNode<K, V>> nodes;
    private int numOfBuckets;
    private int size;

    public CustomHashMap() {
        numOfBuckets = 10;
        size = 0;
        nodes = new ArrayList<>();
        for (int i = 0; i < numOfBuckets; i++)
            nodes.add(null);
    }

    @Override
    public void add(K key, V val) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = nodes.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = val;
                return;
            }
            head = head.next;
        }
        size++;
        head = nodes.get(bucketIndex);
        HashNode<K, V> node = new HashNode<>(key, val, null);
        node.next = head;
        nodes.set(bucketIndex, node);

        if (size * 1.0 / numOfBuckets > 0.7) {
            List<HashNode<K, V>> temp = nodes;
            nodes = new ArrayList<>();
            numOfBuckets *= 2;
            size = 0;
            for (int i = 0; i < numOfBuckets; i++) {
                nodes.add(null);
            }
            for (HashNode<K, V> oldNode : temp) {
                while (oldNode != null) {
                    add(oldNode.key, oldNode.value);
                    oldNode = oldNode.next;
                }
            }
        }
    }

    @Override
    public V remove(K key) {
        if (containsKey(key)) {
            int index = getBucketIndex(key);
            HashNode<K, V> node = nodes.get(index);
            HashNode<K, V> prev = null;
            while (node != null) {
                if (node.key.equals(key)) {
                    break;
                }
                prev = node;
                node = node.next;
            }
            if (node == null) {
                return null;
            }
            size--;
            if (prev != null) {
                prev.next = node.next;
            } else {
                nodes.set(index, node.next);
            }
            return node.value;
        }
        return null;
    }


    @Override
    public V get(K key) {
        if (containsKey(key)) {
            int index = getBucketIndex(key);
            HashNode<K, V> node = nodes.get(index);
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        return nodes.get(index) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int i = hashCode % numOfBuckets;
        return i;
    }

    class HashNode<Key, Val> {
        Key key;
        Val value;
        HashNode<Key, Val> next;

        HashNode(Key key, Val value, HashNode<Key, Val> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
