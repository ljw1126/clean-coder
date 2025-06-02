package com.example.cleancoder.function;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.assertj.core.api.Assertions.*;

public class FileContentComparator {
    // PrintPrime Test Guide
    public void compare() {
        try {
            BufferedReader lead = new BufferedReader(new FileReader("lead"));
            BufferedReader gold = new BufferedReader(new FileReader("src/test/java/function/gold"));
            String line;
            while ((line = gold.readLine()) != null)
                assertThat(line).isEqualTo(lead.readLine());

            assertThat(lead.readLine()).isNull();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
