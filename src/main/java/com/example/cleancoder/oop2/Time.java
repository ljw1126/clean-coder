package com.example.cleancoder.oop2;

public class Time {
    private long nanoseconds;

    public Time(long nanoseconds) {
        this.nanoseconds = nanoseconds;
    }

    public long getMilliTime() {
        return (long) (nanoseconds / Math.pow(10, 6));
    }

    public Long getNanoTime() {
        return nanoseconds;
    }
}
