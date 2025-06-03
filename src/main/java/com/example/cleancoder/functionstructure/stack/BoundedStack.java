package com.example.cleancoder.functionstructure.stack;

public class BoundedStack implements Stack {
    private int size = 0;
    private int capacity;
    private int [] elements;

    public BoundedStack(int capacity) {
        this.capacity = capacity;
        elements = new int [capacity];
    }

    public static Stack make(int capacity) {
        if(capacity == 0)
            return new ZeroCapacityStack();
        if(capacity < 0)
            throw new BoundedStack.IllegalCapacity();

        return new BoundedStack(capacity);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public void push(int element) {
        if(size == capacity)
            throw new Overflow();
        this.elements[size++] = element;
    }

    @Override
    public int pop() {
        if(size == 0)
            throw new Underflow();
        return elements[--size];
    }

    @Override
    public Integer top() {
        if(isEmpty())
            throw new Empty();

        return elements[size - 1];
    }

    @Override
    public Integer find(int element) {
        for(int i = size -  1; i >= 0; i--) {
            if(elements[i] == element) return size - 1 - i;
        }

        return null;
    }

    public static class Overflow extends RuntimeException {
    }

    public static class IllegalCapacity extends RuntimeException {
    }

    public static class Underflow extends RuntimeException {
    }
}
