package com.example.cleancoder.tdd.wordwrap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WrapperTest {

    @Test
    void shouldWrap() {
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
        assertWraps("xx", 1, "x\nx");
        assertWraps("xxx", 1, "x\nx\nx");
        assertWraps("x x", 1, "x\nx");
        assertWraps("x xx", 3, "x\nxx");
        assertWraps("four score and seven years ago our fathers brought forth upon this continent",
                7,
                "four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt");
    }

    private static void assertWraps(String s, int width, String expected) {
        assertThat(wrap(s, width)).isEqualTo(expected);
    }

    private static String wrap(String s, int width) {
        if(s == null)
            return "";

        if(s.length() <= width)
            return s;

        int breakPoint = s.lastIndexOf(" ", width);
        if(breakPoint == -1) {
            breakPoint = width;
        }

        return s.substring(0, breakPoint) + "\n" + wrap(s.substring(breakPoint).trim(), width);
    }
}
