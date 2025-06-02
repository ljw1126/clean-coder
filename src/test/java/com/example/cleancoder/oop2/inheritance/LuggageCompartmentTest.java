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

        lc.remove(luggage); // restSpace 공간이 추가되야 하는데 상속 남용으로 잘못 사용해 비즈니스 로직을 거치지 못함
        assertThat(lc.canContain(luggage)).isTrue();
    }
}
