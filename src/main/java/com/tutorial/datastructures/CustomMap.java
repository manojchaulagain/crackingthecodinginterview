package com.tutorial.datastructures;

public interface CustomMap<K, V> {

    void add(K key, V value);

    V remove(K key);

    V get(K key);

    int size();

    boolean containsKey(K key);

    boolean isEmpty();
}
