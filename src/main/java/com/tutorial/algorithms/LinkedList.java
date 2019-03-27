package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-18
 * Time: 18:22
 */
public class LinkedList {

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
    private Node root;

    public void add(int val) {
        Node node = new Node(val);
        Node cur = root;
        if (cur == null) {
            root = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void reverse() {
        root = reverse(root);
    }

    public void reverseRecursive() {
        root = reverseRecursive(root);
    }

    public Node clone() {
        Node old = root;
        Node newList = null;
        Node newRoot = null;
        while (old != null) {
            if (newList == null) {
                newList = new Node(old.val);
                newRoot = newList;
            } else {
                newList.next = new Node(old.val);
                newList = newList.next;
            }
            old = old.next;
        }
        return newRoot;
    }

    public void rotateLinkedList() {
        Node cur = root;
        Node begin = cur;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = begin;
        root = begin.next;
        begin.next = null;
    }


    private Node reverse(Node root) {
        Node cur = root;
        Node prev = null;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


    public Node reverseRecursive(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node node = reverseRecursive(root.next);
        root.next.next = root;
        root.next = null;
        return node;
    }

    public void print() {
        print(root);
    }

    public void print(Node root) {
        StringBuilder sb = new StringBuilder();
        Node cur = root;
        while (cur.next != null) {
            sb.append(cur.val).append("->");
            cur = cur.next;
        }
        sb.append(cur.val);
        System.out.println(sb.toString());
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
