package com.example.cleancoder.oop2.inheritance;

import java.util.Iterator;

public class FlowController {

    public void process() {
        FileLogCollector collector = new FileLogCollector();

        FileLogSet logSet = collector.collect();

        Iterator<String> iterator = logSet.iterate();

        FileLogWriter writer = new FileLogWriter();

        for(String line = iterator.next(); line != null;) {
            // String parsedLine = parser.parse(line);
            writer.write(line);
        }
    }
}
