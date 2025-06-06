package com.example.cleancoder.tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void canRoll() {
        game.roll(0);
    }

    @Test
    void gutterGame() {
        rollMany(0, 20);

        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    void allOnes() {
        rollMany(1, 20);

        assertThat(game.getScore()).isEqualTo(20);
    }

    @Test
    void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        assertThat(game.getScore()).isEqualTo(16);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    void oneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);

        assertThat(game.getScore()).isEqualTo(26);
    }

    @Test
    void perfectGame() {
        rollMany(12, 10);
        assertThat(game.getScore()).isEqualTo(300);
    }

    @Test
    void twoStrikeOneFrame() {
        rollStrike(); // 10 + 10 + 3 = 23
        rollStrike(); // 10 + 3 + 6 = 19
        game.roll(3); // 3 + 6 = 9
        game.roll(6);
        rollMany(14, 0);

        assertThat(game.getScore()).isEqualTo(51);
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollMany(int pins, int frame) {
        for(int i = 0; i < frame; i++) {
            game.roll(pins);
        }
    }
}
