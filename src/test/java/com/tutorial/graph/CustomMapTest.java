package com.tutorial.graph;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomMapTest {

    static CustomMap<String, Integer> map;

    @BeforeClass
    public static void init() {
        map = new CustomHashMap<>();
    }

    @Test
    public void testAdd() {
        map.add("This", 2);
        Assert.assertEquals(2, (int) map.get("This"));
        map.add("This", 3);
        Assert.assertEquals(3, (int) map.get("This"));
        map.add("That", 4);
        Assert.assertEquals(2, map.size());
    }
}
