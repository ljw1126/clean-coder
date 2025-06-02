package com.example.cleancoder.oop2;

public class ProceduralStopWatch {
    public long startTime;
    public long stopTime;

    public long getElapsedTime() {
        return stopTime - startTime;
    }
}
