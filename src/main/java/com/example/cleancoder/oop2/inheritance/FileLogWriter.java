package com.example.cleancoder.oop2.inheritance;

public class FileLogWriter {
    private final StringBuilder stringBuilder;

    public FileLogWriter() {
        this(new StringBuilder());
    }

    public FileLogWriter(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void write(String data) {
        stringBuilder.append(data);
    }
}
