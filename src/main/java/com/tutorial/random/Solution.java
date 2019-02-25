package com.tutorial.random;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        size = new int[n];
        Arrays.fill(size, 1);

        while (q-- != 0) {
            String type = sc.next();
            if (type.equals("Q")) {
                System.out.println(size[findSet(sc.nextInt() - 1)]);
            } else {
                union(sc.nextInt() - 1, sc.nextInt() - 1);
            }
        }

    }

    static int findSet(int x) {
        return parent[x] == x ? x : (parent[x] = findSet(parent[x]));
    }

    static void union(int x, int y) {
        if (findSet(x) != findSet(y)) {
            size[findSet(x)] = size[findSet(y)] = size[findSet(x)] + size[findSet(y)];
        }
        parent[findSet(x)] = findSet(y);
    }
}

