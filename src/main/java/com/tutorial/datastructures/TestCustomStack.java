package com.tutorial.datastructures;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-16
 * Time: 18:59
 */
public class TestCustomStack {

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
        String val = "This is a stack test";
        String[] vals = val.split("\\s");
        CustomQueue<String> cs = new CustomQueue<>();
        for (String s : vals) {
            cs.add(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!cs.isEmpty()) {
            sb.append(cs.poll()).append(" ");
        }

        System.out.println(sb.toString());
        System.out.println(cs.isEmpty());
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
