package com.example.cleancoder.subclassoverride;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Directory {
    public static String[] getFiles(String directoryName) {
        throw new IllegalStateException("Directory#getFiles is not implemented yet");
    }
}

class Sorted {
    public final int index;
    public final String path;

    Sorted(int index, String path) {
        this.index = index;
        this.path = path;
    }
}

class File {
    public static void writeAllText(String newFile, String newRecord) {
        throw new IllegalStateException("File#writeAllText is not implemented yet");
    }

    public static String [] readAllLines(String currentFilePath) {
        throw new IllegalStateException("File#readAllLines is not implemented yet");
    }
}

class Path {
    public static String combine(String directoryName, String fileName) {
        return directoryName + java.io.File.pathSeparator + fileName;
    }
}

public class AuditManager {
    private final int maxEntriesPerFile;
    private final String directoryName;

    public AuditManager(int maxEntriesPerFile, String directoryName) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
    }

    public void addRecord(String visitorName, LocalDateTime timeOfVisit) {
        String[] filePaths = getFiles();
        Sorted[] sorted = sortByIndex(filePaths);

        String newRecord = visitorName + ';' + timeOfVisit;

        if (sorted.length == 0) {
            String newFile = Path.combine(directoryName, "audit_1.txt");
            writeAllText(newFile, newRecord);
            return;
        }

        int currentFileIndex = sorted[sorted.length - 1].index;
        String currentFilePath = sorted[sorted.length - 1].path;
        List<String> lines = new ArrayList<>(Arrays.asList(readAllLines(currentFilePath)));

        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            String newContent = String.join("\n", lines);
            writeAllText(currentFilePath, newContent);
        } else {
            int newIndex = currentFileIndex + 1;
            String newName = "audit_" + newIndex + ".txt";
            String newFile = Path.combine(directoryName, newName);
            writeAllText(newFile, newRecord);
        }
    }

    protected String[] readAllLines(String currentFilePath) {
        return File.readAllLines(currentFilePath);
    }

    protected String[] getFiles() {
        String[] filePaths = Directory.getFiles(directoryName);
        return filePaths;
    }

    protected void writeAllText(String newFile, String newRecord) {
        File.writeAllText(newFile, newRecord);
    }

    private Sorted[] sortByIndex(String[] filePaths) {
        final Integer[] idx = {0};
        return Arrays.stream(filePaths)
                .map(s -> new Sorted(idx[0]++, s))
                .toArray(Sorted[]::new);
    }
}
