package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-12
 * Time: 14:27
 */
public class ReverseWords {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private static char[] arr = {
            'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
            'm', 'a', 'k', 'e', 's', ' ',
            'p', 'r', 'a', 'c', 't', 'i', 's', 'e'
    };

    private static char[] arr2 = {
            'g', 'o', 'l', 'd', ' ',
            'i', 's', ' ',
            'o', 'l', 'd'
    };

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public static void main(String[] args) {
        System.out.println(String.valueOf(arr));
        reverseWholeWord(arr);
        reverseWords(arr);
        System.out.println(String.valueOf(arr));

        System.out.println(String.valueOf(arr2));
        reverseWholeWord(arr2);
        reverseWords(arr2);
        System.out.println(String.valueOf(arr2));
    }

    private static void reverseWords(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int from = 0;
        while (left < right) {
            if (arr[left] == ' ') {
                reverseWholeWord(arr, from, left - 1);
                left++;
                from = left;
            } else {
                left++;
            }
        }
        reverseWholeWord(arr, from, right);
    }

    private static void reverseWholeWord(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        reverseWholeWord(arr, left, right);
    }

    private static void reverseWholeWord(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private static void swap(char[] arr, int left, int right) {
        char c = arr[left];
        arr[left] = arr[right];
        arr[right] = c;
    }


   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
