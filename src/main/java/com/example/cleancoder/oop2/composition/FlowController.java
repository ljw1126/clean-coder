package com.example.cleancoder.oop2.composition;

import java.util.Iterator;

public class FlowController {

    private final LogCollector collector;
    private final LogWriter writer;

    public FlowController(LogCollector collector, LogWriter writer) {
        this.collector = collector;
        this.writer = writer;
    }

    public void process() {
        LogSet logSet = collector.collect();

        Iterator<String> iterator = logSet.iterate();

        while(iterator.hasNext()) {
            String line = iterator.next();
            // String parsedLine = parser.parse(line);
            writer.write(line);
        }
    }
}
