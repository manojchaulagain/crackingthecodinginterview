package com.tutorial.graph;

import java.util.List;

public class Link {
    public Integer distance;
    public int index;
    public List<Integer> coord;

    public Link(Integer distance, int index, List<Integer> coord) {
        this.distance = distance;
        this.index = index;
        this.coord = coord;
    }
}
