package com.tutorial.datastructures;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-02-28
 * Time: 22:55
 */
public class BinaryTreeRunner {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    public static void main(String[] args) {
        int[] vals = {1, 5, 4, 3, 4, 5, 7};
        BinaryTree tree = new BinaryTree();
        for (int val : vals) {
            tree.add(val);
        }
        System.out.println(tree.size());
    }

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
