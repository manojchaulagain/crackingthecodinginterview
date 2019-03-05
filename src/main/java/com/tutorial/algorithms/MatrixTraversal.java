package com.tutorial.algorithms;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-04
 * Time: 17:12
 */
public class MatrixTraversal {

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
        int n = 5, m = 5;
//        System.out.println(getNumberOfWays(m, n));

        int[][] maze = {
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        System.out.println(getPaths(maze));
    }

    private static int getPaths(int[][] maze) {
        if(maze[0][0] == 1) {
            return 0;
        }
        boolean foundObstacle = false;
        for (int row = 0; row < maze.length; row++) {
            if (maze[row][0] == 0 && !foundObstacle) {
                maze[row][0] = 1;
            } else {
                foundObstacle = true;
                maze[row][0] = 0;
            }
        }
        foundObstacle = false;
        for (int col = 1; col < maze[0].length; col++) {
            if (maze[0][col] == 0 && !foundObstacle) {
                maze[0][col] = 1;
            } else {
                foundObstacle = true;
                maze[0][col] = 0;
            }
        }

        for (int row = 1; row < maze.length; row++) {
            for (int col = 1; col < maze[row].length; col++) {
                if (maze[row][col] == 1) {
                    maze[row][col] = 0;
                } else {
                    maze[row][col] = maze[row - 1][col] + maze[row][col - 1];
                }
            }
        }
        return maze[maze.length - 1][maze[0].length - 1];
    }


    private static int getNumberOfWays(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return getNumberOfWays(m - 1, n) + getNumberOfWays(m, n - 1);
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
