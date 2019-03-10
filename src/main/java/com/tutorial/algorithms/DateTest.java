package com.tutorial.algorithms;

import java.util.Calendar;
import java.util.Date;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-06
 * Time: 23:33
 */
public class DateTest {

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
        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, 0, 19);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
