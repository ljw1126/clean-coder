package com.example.cleancoder.functionstructure.stack;

public class Stack {
    private int size = 0;
    private int capacity;
    private int [] elements;

    public Stack(int capacity) {
        this.capacity = capacity;
        elements = new int [capacity];
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public Integer getSize() {
        return size;
    }

    public void push(int element) {
        if(size == capacity)
            throw new Overflow();
        this.elements[size++] = element;
    }

    public int pop() {
        if(size == 0)
            throw new Underflow();
        return elements[--size];
    }

    public static Stack make(int capacity) {
        if(capacity < 0)
            throw new IllegalCapacity();
        return new Stack(capacity);
    }

    public class Overflow extends RuntimeException {
    }

    public static class IllegalCapacity extends RuntimeException {
    }

    public class Underflow extends RuntimeException {
    }
}
