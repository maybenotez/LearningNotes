package com.dark.knight.learn.algorithms;

import java.util.Arrays;

/**
 * @author sheng.yang
 * @date 2021/9/2 10:17
 * @description ArrayStack
 **/

public class ArrayStack<E> implements Stack<E> {


    private Object[] elements;

    private int size;

    public ArrayStack(){
        elements = new Object[10];
    }

    @Override
    public void push(E e) {
        if (size >= elements.length) {
            resize();
        }
        elements[size++] = e;
    }

    private void resize(){
        int length = elements.length * 2;
        elements = Arrays.copyOf(elements, length);;
    }

    @Override
    public E pop() {
        if(size<=0){
            return null;
        }
        size = size - 1;
        return (E) elements[size];
    }

}
