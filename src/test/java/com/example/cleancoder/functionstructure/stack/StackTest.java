package com.example.cleancoder.functionstructure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class StackTest {
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack(10);
    }

    @Test
    public void newlyCreatedStack_shouldBeEmpty() {
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.getSize()).isZero();
    }

    @Test
    public void afterOnePush_StackSizeShouldBeOne() {
        stack.push(1);
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.getSize()).isOne();
    }

    @Test
    public void afterOnePushAndOnePop_shouldBeEmpty() {
        stack.push(1);
        stack.pop();
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void whenPushedOverCapacity_StackOverflows() {
        stack = Stack.make(1);
        stack.push(1);

        assertThatThrownBy(() -> stack.push(1))
                .isInstanceOf(Stack.Overflow.class);
    }

    @Test
    public void whenCreatingStackWithNegativeSize_shouldThrowIllegalCapacity() {
        assertThatThrownBy(() -> Stack.make(-1))
                .isInstanceOf(Stack.IllegalCapacity.class);
    }

    @Test
    public void whenEmptyStackIsPopped_StackUnderflows() {
        assertThatThrownBy(() -> stack.pop())
                .isInstanceOf(Stack.Underflow.class);
    }

    @Test
    public void whenOneIsPushed_OneIsPopped() {
        stack.push(1);

        assertThat(stack.pop()).isOne();
    }

    @Test
    public void whenOneAndTwoArePushed_TwoAndOneArePopped() {
        stack.push(1);
        stack.push(2);

        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isOne();
    }
}
