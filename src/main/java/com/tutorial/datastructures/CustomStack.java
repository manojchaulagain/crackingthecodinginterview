package com.tutorial.datastructures;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created using IntelliJ IDEA
 * User: Manoj Chaulagain
 * Date: 2019-03-16
 * Time: 18:51
 */
public class CustomStack<T> {

   /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

   /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private int size;
    private ArrayList<T> list;
   /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    public CustomStack() {
        this.list = new ArrayList<>();
        size = 0;
    }

   /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

    public void push(T val) {
        size++;
        list.add(val);
    }

    public T pop() {
        T val;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            size--;
            val = list.get(size);
            list.remove(val);
        }
        return val;
    }

    public T peek() {
        T val;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            val = list.get(size - 1);
        }
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
