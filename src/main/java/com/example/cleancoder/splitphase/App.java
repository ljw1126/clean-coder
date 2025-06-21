package com.example.cleancoder.splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println(run(args));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    record CommandLine(String fileName, boolean onlyCountReady) {}

    private static long run(String[] args) throws IOException {
        CommandLine commandLine = parseCommandLine(args);
        return countOrder(args, commandLine);
    }

    private static CommandLine parseCommandLine(String[] args) {
        if(args.length == 0) throw new RuntimeException("파일명을 입력하세요");

        String fileName = args[args.length - 1];
        boolean onlyCountReady = Stream.of(args).anyMatch(arg -> "-r".equals(arg));
        return new CommandLine(fileName, onlyCountReady);
    }

    private static long countOrder(String[] args, CommandLine commandLine) throws IOException {
        File input = Paths.get(commandLine.fileName).toFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);
        if(commandLine.onlyCountReady()) {
            return Stream.of(orders)
                    .filter(o -> "ready".equals(o.status()))
                    .count();
        } else {
            return orders.length;
        }
    }
}
