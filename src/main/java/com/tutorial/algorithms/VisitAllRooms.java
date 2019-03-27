package com.tutorial.algorithms;

import java.util.*;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-09
 * Time: 23:09
 */
public class VisitAllRooms {

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
        List<List<Integer>> values = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        values.add(nums);
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(3);
        values.add(nums1);
        List<Integer> nums2 = new ArrayList<>();
        nums2.add(2);
        values.add(nums2);
        List<Integer> nums3 = new ArrayList<>();
        values.add(nums3);
        System.out.println(canVisitAllRooms(values));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        visitedRooms.add(0);
        Stack<Integer> stack = new Stack<>();
        stack.addAll(rooms.get(0));
        while (!stack.isEmpty()) {
            int val = stack.pop();
            visitedRooms.add(val);
            for (int room: rooms.get(val)) {
                if(!visitedRooms.contains(room)) {
                    stack.add(room);
                }
            }
        }
        for(int i = 0; i <rooms.size(); i++) {
            if(!visitedRooms.contains(i)) {
                return false;
            }
        }
        return true;
    }
   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
