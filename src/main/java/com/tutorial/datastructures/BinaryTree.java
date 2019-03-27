package com.tutorial.datastructures;

import java.util.*;

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

    public Node root;

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

    public void convertToMirror() {
        convertToMirror(root);
    }

    public void printInOrder() {
        printInOrderString(root);
    }

    private Node printInOrderString(Node root) {
        if (root == null) {
            return null;
        }
        Node left = printInOrderString(root.left);
        if (left != null) {
            System.out.println(left.val);
        }
        System.out.println(root.val);
        Node right = printInOrderString(root.right);
        if (right != null) {
            System.out.println(right.val);
        }
        return root;
    }

    public void inOrderTraversal() {
        List<Integer> list = new ArrayList<>();
        System.out.println(printInOrder(root, list));
    }

    private List<Integer> printInOrder(Node root, List<Integer> list) {
        if (root.left != null) {
            printInOrder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            printInOrder(root.right, list);
        }
        return list;
    }


    private void convertToMirror(Node node) {
        if (node != null) {
            convertToMirror(node.left);
            convertToMirror(node.right);
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }


    public void convertToSumTree() {
        convertToSumTree(root);
    }

    private int convertToSumTree(Node node) {
        if (node == null) {
            return 0;
        }
        int old = node.val;
        int l = convertToSumTree(node.left);
        int r = convertToSumTree(node.right);
        node.val = l + r;
        return node.val + old;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }


    public int getHeightIterative() {
        return getHeightIterative(root);
    }

    private int getHeightIterative(Node node) {
        int height = 0;
        if (node == null) {
            return height;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                while (levelSize > 0) {
                    Node poll = queue.poll();
                    if (poll != null) {
                        if (poll.left != null) {
                            queue.add(poll.left);
                        }
                        if (poll.right != null) {
                            queue.add(poll.right);
                        }
                    }
                    levelSize--;
                }
                height++;
            }
        }
        return height;
    }

    public void reverseLevelOrderTraversal() {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            stack.push(node);
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        System.out.print("Reverse Level Traversal:   ");
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("Level Traversal:           ");
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }


    public void addBottomUpIterative() {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            stack.add(poll);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        List<Node> leafNodes = new ArrayList<>();
        int prev = 0;
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            int sum = prev;
            if (pop.left != null) {
                sum += pop.left.val;
            }
            if (pop.right != null) {
                sum += pop.right.val;
            }
            if (pop.left == null && pop.right == null) {
                leafNodes.add(pop);
            }
            prev = pop.val;
            pop.val = sum;
        }
        leafNodes.forEach(node -> node.val = 0);
    }

    public int add(Node node) {
        int sum = 0;
        if (node != null) {
            if (node.left != null) {
                sum += node.left.val;
            }
            if (node.right != null) {
                sum += node.right.val;
            }
            node.val = sum;
            return node.val;
        } else {
            return 0;
        }
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

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
