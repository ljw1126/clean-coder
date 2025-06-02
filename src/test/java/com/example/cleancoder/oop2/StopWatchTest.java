package com.example.cleancoder.oop2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StopWatchTest {
    private long expectedElapsedTime = 100l;

    @Test
    void shouldReturnElapsedMilliSeconds() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        doSomething();

        stopWatch.stop();

        Time elapsedTime = stopWatch.getElapsedTime();

        assertThat(elapsedTime.getMilliTime()).isGreaterThanOrEqualTo(expectedElapsedTime);
    }

    @Test
    void shouldReturnElapsedNanoSeconds() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        doSomething();

        stopWatch.stop();

        Time elapsedTime = stopWatch.getElapsedTime();

        assertThat(elapsedTime.getNanoTime()).isGreaterThanOrEqualTo(expectedElapsedTime);
    }

    private void doSomething() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
