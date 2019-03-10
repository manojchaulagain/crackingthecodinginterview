package com.tutorial.algorithms;

import java.util.Comparator;

public class Node<K extends Comparable<? super K>, V extends Comparable<? super V>> implements Comparable<Node<K, V>> {
    K x;
    V name;

    Node(K x, V name) {
        this.x = x;
        this.name = name;
    }

    public static Comparator<Node> getNameComparatorDescending() {
        return Comparator.comparing(o -> o.name);
    }

    public static Comparator<Node> getNameComparatorAscending() {
        return (o1, o2) -> o2.name.compareTo(o1.name);
    }

    public static Comparator<Node> getValueComaratorDescending() {
        return Comparator.comparing(o -> o.x);
    }

    public static Comparator<Node> getValueComaratorAscending() {
        return (o1, o2) -> o2.x.compareTo(o1.x);
    }

    @Override
    public  int compareTo(Node<K, V> o) {
        return this.x.compareTo(o.x);
    }
}
