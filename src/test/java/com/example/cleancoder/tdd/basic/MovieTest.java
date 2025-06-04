package com.example.cleancoder.tdd.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class MovieTest {

    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie();
    }

    @Test
    void shouldReturn0WhenJustCreated() {
        assertThat(movie.averageRating()).isEqualTo(0);
    }

    @Test
    void shouldReturnOneWhenOneWasRated() {
        movie.rate(1);
        assertThat(movie.averageRating()).isEqualTo(1);
    }

    @Test
    void shouldReturn4When3And5WasRated() {
        movie.rate(3);
        movie.rate(5);
        assertThat(movie.averageRating()).isEqualTo(4);
    }

}
