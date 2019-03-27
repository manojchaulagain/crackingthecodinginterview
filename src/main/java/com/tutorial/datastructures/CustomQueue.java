package com.tutorial.datastructures;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-16
 * Time: 19:12
 */
public class CustomQueue<T> {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private LinkedList<T> list;
    private int size;

   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    public CustomQueue() {
        this.list = new LinkedList<>();
        this.size = 0;
    }

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public void add(T val) {
        size++;
        list.add(val);
    }

    public T peek() {
        T val;
        if (list.isEmpty()) {
            throw new EmptyStackException();
        } else {
            val = list.get(0);
        }
        return val;
    }

    public T poll() {
        T val = peek();
        if (val != null) {
            list.remove(val);
        }
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

   /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

   /*--------------------------------------------
    |   A C C E S S O R S / M O D I F I E R S   |
    ============================================*/

}
