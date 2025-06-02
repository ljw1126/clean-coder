package com.example.cleancoder.oop2.inheritance;

import java.util.Iterator;
import java.util.Set;

public class FileLogSet {
    private final static Set<String> dummy = Set.of("a", "b", "c", "d");

    public Iterator<String> iterate() {
        return dummy.iterator();
    }
}
