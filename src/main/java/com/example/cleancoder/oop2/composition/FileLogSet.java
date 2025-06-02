package com.example.cleancoder.oop2.composition;

import java.util.Iterator;
import java.util.Set;

public class FileLogSet implements LogSet {
    private final static Set<String> dummy = Set.of("a", "b", "c", "d");

    public Iterator<String> iterate() {
        return dummy.iterator();
    }
}
