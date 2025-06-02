package com.example.cleancoder.function;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class PrintPrimesTest {
    private PrintStream out;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("lead")));
    }

    @AfterEach
    void tearDown() {
        System.setOut(out);
        new File("lead").delete();
    }

    @Test
    void makeSureMatchesGold() throws IOException {
        PrintPrimes.main(new String[0]);

        BufferedReader lead = new BufferedReader(new FileReader("lead"));
        BufferedReader gold = new BufferedReader(new FileReader("src/test/java/com/example/cleancoder/function/gold"));
        String line;

        while ((line = gold.readLine()) != null)
            assertThat(line).isEqualTo(lead.readLine());

        assertThat(lead.readLine()).isNull();
    }
}
