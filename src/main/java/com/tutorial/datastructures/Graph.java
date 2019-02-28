package com.tutorial.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-02-27
 * Time: 11:53
 */
public class Graph {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private Map<String, Vertex> vertices;
   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    public Graph() {
        vertices = new HashMap<>();
    }

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public void addVertex(String vertexLabel) {
        vertices.putIfAbsent(vertexLabel, new Vertex(vertexLabel));
    }

    public void removeVertices(String vertexLabel) {
        Vertex v = new Vertex(vertexLabel);
        vertices.remove(vertexLabel);
    }

    public void addEdge(String label1, String label2) {
        Vertex v = vertices.get(label1);
        v.edges.add(new Edge(label1, label2));
    }

    public String findPathBetween(String from, String to) {
        String path = "";
        return path;
    }
    public int size() {
        return vertices.size();
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

    class Vertex {
        String label;
        List<Edge> edges;

        Vertex(String label) {
            this.label = label;
            this.edges = new ArrayList<>();
        }
    }

    class Edge {
        String from;
        String to;

        public Edge(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }
}
