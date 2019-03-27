package com.tutorial.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-19
 * Time: 19:14
 */
public class Graph {

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

    public Node build() {
        Node g = new Node("G", 6, null, null);
        Node d = new Node("D", 7, g, null);
        Node e = new Node("E", 33, null, null);
        Node b = new Node("B", 2, d, e);
        Node f = new Node("F", 16, null, null);
        Node c = new Node("C", 4, null, f);
        Node a = new Node("A", 0, b, c);
        return a;
    }

    public NodeWrapper getMinDistanceLeafNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return new NodeWrapper(node, 0);
        }

        NodeWrapper left = getMinDistanceLeafNode(node.left);
        NodeWrapper right = getMinDistanceLeafNode(node.right);

        if (left != null && right != null) {
            right.distance += node.leftDistance;
            left.distance += node.leftDistance;

            if (left.distance >= right.distance) {
                System.out.println(right.node.val + " -> " + right.distance);
                return right;
            } else {
                System.out.println(left.node.val + " -> " + left.distance);
                return left;
            }
        } else if (left != null) {
            left.distance += node.leftDistance;
            System.out.println(left.node.val + " -> " + left.distance);
            return left;
        } else {
            right.distance += node.leftDistance;
            System.out.println(right.node.val + " -> " + right.distance);
            return right;
        }
    }

    public void getMinDistNode(Node node, List<Node> path, List<List<Node>> paths) {
        if (node == null) {
            return;
        }
        path.add(node);
        if (node.left == null && node.right == null) {
            paths.add(path);
        }
        getMinDistNode(node.left, new ArrayList<>(path), paths);
        getMinDistNode(node.right, new ArrayList<>(path), paths);
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/


   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

    class NodeWrapper {
        Node node;
        int distance;

        public NodeWrapper(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    class Node {
        String val;
        int leftDistance;
        Node left;
        Node right;

        public Node(String val, int leftDistance, Node left, Node right) {
            this.val = val;
            this.leftDistance = leftDistance;
            this.left = left;
            this.right = right;
        }
    }
}
