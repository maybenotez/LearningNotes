package com.dark.knight.learn.spring.test;

public class Lazy {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "my friend Lazy{" +
                "value=" + value +
                '}';
    }
}
