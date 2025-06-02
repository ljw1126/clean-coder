package com.example.cleancoder.oop2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProceduralStopWatchTest {
    private long expectedElapsedTime = 100l;

    @Test
    void shouldReturnElapsedMilliSeconds() {
        ProceduralStopWatch stopWatch = new ProceduralStopWatch();

        stopWatch.startTime = System.currentTimeMillis();

        doSomething();

        stopWatch.stopTime = System.currentTimeMillis();

        long elapsedTime = stopWatch.getElapsedTime();

        assertThat(elapsedTime).isGreaterThanOrEqualTo(expectedElapsedTime);
    }

    private void doSomething() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
