package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-13
 * Time: 08:15
 */
public class ExistsWord {

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
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (word.charAt(0) == board[row][col]) {
                    return exist(board, word, row, col, 1);
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word, int r, int c, int index) {
        //Up
        int rowUp = r - 1;
        if (checkBounds(board, rowUp, c)) {
            if (board[rowUp][c] == word.charAt(index)) {
                if (index == word.length() - 1) {
                    return true;
                }
                return exist(board, word, rowUp, c, index + 1);
            }
        }
        //Left
        int colLeft = c - 1;
        if (checkBounds(board, r, colLeft)) {
            if (board[r][colLeft] == word.charAt(index)) {
                if (index == word.length() - 1) {
                    return true;
                }
                return exist(board, word, r, colLeft, index + 1);
            }
        }

        //Down
        int rowDown = r + 1;
        if (checkBounds(board, rowDown, c)) {
            if (board[rowDown][c] == word.charAt(index)) {
                if (index == word.length() - 1) {
                    return true;
                }
                return exist(board, word, rowDown, c, index + 1);
            }
        }

        //Right
        int colRight = c + 1;
        if (checkBounds(board, r, colRight)) {
            if (board[r][colRight] == word.charAt(index)) {
                if (index == word.length() - 1) {
                    return true;
                }
                return exist(board, word, r, colRight, index + 1);
            }
        }
        return false;
    }


    private static boolean checkBounds(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }


   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
