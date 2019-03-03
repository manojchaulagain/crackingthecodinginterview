package com.tutorial.datastructures;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-02-28
 * Time: 22:23
 */
public class BinaryTree {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private Node root;

    private int size;
   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public void add(int number) {
        size++;
        root = add(number, root);
    }

    private Node add(int number, Node node) {
        if (node == null) {
            node = new Node(null, null, number);
        } else {
            if (node.val > number) {
                node.left = add(number, node.left);
            } else if (node.val < number) {
                node.right = add(number, node.right);
            } else {
                return node;
            }
        }
        return node;
    }

    public int size() {
        return size;
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

    class Node {
        Node left;
        Node right;
        int val;

        Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
