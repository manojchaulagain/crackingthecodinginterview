package com.tutorial.algorithms;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-02
 * Time: 17:25
 */
public class BalancedBrackets {

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

    private static HashMap<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        int count = 0;
        String longestBal = "";
        String val = "(()";
        for (int i = 0; i < val.length(); i++) {
            for (int j = i; j < val.length(); j++) {
                String subString = val.substring(i, j + 1);
                if (isBalanced(subString)) {
                    longestBal = longestBal.length() < subString.length() ? subString : longestBal;
                    count = Math.max(count, subString.length());
                }
            }
        }
        System.out.println(longestBal);
        System.out.println(count);
        System.out.println(isBalanced("{(){[[(())]]}}"));
        System.out.println(isBalanced("(())"));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if ((map.containsKey(c) && pop != map.get(c))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
