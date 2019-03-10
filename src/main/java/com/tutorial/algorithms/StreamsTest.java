package com.tutorial.algorithms;

import java.util.ArrayList;


/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-05
 * Time: 22:19
 */
public class StreamsTest {

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
        ArrayList<Node> arrayList = new ArrayList<>();
        arrayList.add(new Node<>(2, "node1"));
        arrayList.add(new Node<>(5, "node2"));
        arrayList.add(new Node<>(3, "node3"));
        arrayList.add(new Node<>(21, "node4"));
        arrayList.add(new Node<>(12, "node5"));
        arrayList.add(new Node<>(211, "node6"));
        arrayList.add(new Node<>(2, "node7"));
        arrayList.add(new Node<>(1, "node8"));
        arrayList.add(new Node<>(5, "node9"));
        arrayList.stream().sorted().forEach(node -> System.out.println(node.name + " -> " + node.x));
    }


   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/


}
