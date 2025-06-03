package com.example.cleancoder.functionstructure.stack;


public class ZeroCapacityStack implements Stack {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Integer getSize() {
        return 0;
    }

    @Override
    public void push(int element) {
        throw new BoundedStack.Overflow();
    }

    @Override
    public int pop() {
        throw new BoundedStack.Underflow();
    }

    @Override
    public Integer top() {
        return null;
    }

    @Override
    public Integer find(int element) {
        return null;
    }
}
