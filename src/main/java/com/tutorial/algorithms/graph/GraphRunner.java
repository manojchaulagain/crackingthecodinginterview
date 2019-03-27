package com.tutorial.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-19
 * Time: 23:20
 */
public class GraphRunner {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public static void main(String[] args) {
        Graph g = new Graph();
        Graph.Node n = g.build();
        List<List<Graph.Node>> paths = new ArrayList<>();
        g.getMinDistNode(n, new ArrayList<>(), paths);

        Graph.NodeWrapper nw = new Graph().new NodeWrapper(null, 0);
        for (List<Graph.Node> path : paths) {
            int distance = 0;
            for(Graph.Node pNode: path) {
                distance += pNode.leftDistance;
            }
            System.out.println(path.get(path.size() -1).val + " -> " + distance);
            if(nw.node == null) {
                nw.node = path.get(path.size() -1);
                nw.distance = distance;
            } else {
                if(distance < nw.distance) {
                    nw.distance = distance;
                    nw.node = path.get(path.size() -1);
                }
            }
        }
//        Graph.NodeWrapper nw = g.getMinDistanceLeafNode(n);
        System.out.println(nw.node.val + " -> " + nw.distance);
    }


   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
