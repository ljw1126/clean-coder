package com.example.cleancoder.oop2;

import java.time.Instant;

public class StopWatch {
    private long startTime;
    private long stopTime;

    public void start() {
        this.startTime = System.nanoTime();
    }

    public void stop() {
        this.stopTime = System.nanoTime();
    }

    public Time getElapsedTime() {
        return new Time(this.stopTime - this.startTime);
    }
}
