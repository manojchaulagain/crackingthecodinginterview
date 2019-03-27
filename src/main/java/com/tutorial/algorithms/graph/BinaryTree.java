package com.tutorial.algorithms.graph;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-19
 * Time: 19:14
 */
public class BinaryTree {

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
        Node a = new Node(6);
        Node b = new Node(1);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(5);
        Node f = new Node(7);
        Node g = new Node(9);
        Node h = new Node(10);
        Node i = new Node(12);

        a.left = b;
        a.right = c;
        b.left = d;
        d.left = e;
        d.right = f;
        c.right = g;
        g.left = h;
        h.right = i;
        return a;
    }

    public int sumTree(Node node) {
        if(node == null) {
            return 0;
        }
        int old = node.val;

        int left = sumTree(node.left);
        int right = sumTree(node.right);
        node.val = left + right;
        return left + right + old;
    }



   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/


   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
}
