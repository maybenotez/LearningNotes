package com.dark.knight.learn.algorithms;

import java.util.*;

/**
 * @author sheng.yang
 * @date 2021/8/26 10:42
 * @description ArrayQueue
 **/
@SuppressWarnings("unchecked")
public class ArrayQueue<E> implements Queue<E> {

    private int low;

    private int high;

    private Object[] elements = {};

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        int index = low;
        while (index < high) {
            elements[index] = null;
            index++;
        }
        low = 0;
        high =0;
    }

    @Override
    public boolean offer(E e) {
        if (high >= elements.length) {
            resize();
        }
        elements[high++] = e;
        return true;
    }

    @Override
    public E remove() {
        if (low == high) {
            throw new NoSuchElementException("empty list");
        }
        return getFirst();
    }

    private void resize(){
        int size = high - low;
        int oldLength = elements.length;
        if (size < low) {
            relocate(elements, elements);
        }else{
            Object[] newElementArray = new Object[oldLength + (oldLength >> 1)];
            relocate(elements, newElementArray);
            elements = newElementArray;
        }
    }

    private void relocate(Object[] source, Object[] target) {
        int currentLow = low;
        int currentHigh = high;
        low = 0;
        high = 0;
        // 将low 和 high的指针 重新指向
        while (currentLow < currentHigh) {
            target[high++] = source[currentLow++];
        }
    }


    @Override
    public E poll() {
        if (low == high) {
            return null;
        }
        return getFirst();
    }


    private E getFirst() {
        E element = (E)elements[low];
        elements[low++] = null;
        return element;
    }

    @Override
    public E element() {
        if (low == high) {
            throw new NoSuchElementException("no elements");
        }

        return (E)elements[low];
    }

    @Override
    public E peek() {
        return (E)elements[low];
    }

    @Override
    public boolean isEmpty() {
        return high - low == 0;
    }

    @Override
    public boolean contains(Object o) {
        int index = low;
        while (index < high) {
            if (elements[index++] == o){
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>();
    }

    @Override
    public Object[] toArray() {

        return Arrays.copyOfRange(elements, low, high);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int size() {
        return high - low;
    }

    @Override
    public String toString() {
        return "low:" + low + ",high:" + high;
    }

    private class ArrayIterator<E> implements Iterator<E>{

        private int head = low;

        private int tail = high;

        @Override
        public boolean hasNext() {
            return head < tail;
        }

        @Override
        public E next() {
            return (E) elements[head++];
        }
    }
}
