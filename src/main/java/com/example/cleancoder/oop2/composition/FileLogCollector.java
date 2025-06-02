package com.example.cleancoder.oop2.composition;

public class FileLogCollector implements LogCollector {

    public LogSet collect() {
        return new FileLogSet();
    }
}
