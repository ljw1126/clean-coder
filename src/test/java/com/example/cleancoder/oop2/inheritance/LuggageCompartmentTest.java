package com.example.cleancoder.oop2.inheritance;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LuggageCompartmentTest {
    private LuggageCompartment lc;

    @BeforeEach
    void setUp() {
        lc = new LuggageCompartment(11);
    }

    @Test
    void shouldUpdateRestSpace() {
        Luggage luggage = new Luggage(1L, 10);

        if(lc.canContain(luggage)) {
            lc.add(luggage);
            assertThat(lc.canContain(luggage)).isFalse();
        }

        lc.extract(luggage);
        assertThat(lc.canContain(luggage)).isTrue();
    }
}
