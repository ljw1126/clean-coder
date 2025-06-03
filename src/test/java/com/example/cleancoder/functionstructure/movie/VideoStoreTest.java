package com.example.cleancoder.functionstructure.movie;

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VideoStoreTest {
    private Statement statement;
    private final double DELTA = .001;
    private Movie newReleaseMovie1;
    private Movie newReleaseMovie2;
    private Movie childrensMovie;
    private Movie regular1;
    private Movie regular2;
    private Movie regular3;

    @Before
    public void setUp() {
        statement = new Statement("Customer");
        newReleaseMovie1 = new NewReleaseMovie("New Release 1");
        newReleaseMovie2 = new NewReleaseMovie("New Release 2");
        childrensMovie = new ChildrensMovie("Childrens");
        regular1 = new RegularMovie("Regular 1");
        regular2 = new RegularMovie("Regular 2");
        regular3 = new RegularMovie("Regular 3");
    }

    @Test
    public void testSingleNewReleaseStatementTotals() {
        statement.addRental(new Rental(newReleaseMovie1, 3));
        statement.generate();

        assertThat(statement.getTotal()).isEqualTo(9.0d, Offset.offset(DELTA));
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(2);
    }

    @Test
    public void testDualNewReleaseStatementTotals() {
        statement.addRental(new Rental(newReleaseMovie1, 3));
        statement.addRental(new Rental(newReleaseMovie2, 3));
        statement.generate();

        assertThat(statement.getTotal()).isEqualTo(18.0, Offset.offset(DELTA));
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(4);
    }

    @Test
    public void testSingleChildrenStatementTotals() {
        statement.addRental(new Rental(childrensMovie, 3));
        statement.generate();

        assertThat(statement.getTotal()).isEqualTo(1.5, Offset.offset(DELTA));
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(1);
    }

    @Test
    public void testMultipleRegularStatementTotals() {
        statement.addRental(new Rental(regular1, 1));
        statement.addRental(new Rental(regular2, 2));
        statement.addRental(new Rental(regular3, 3));
        statement.generate();

        assertThat(statement.getTotal()).isEqualTo(7.5, Offset.offset(DELTA));
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(3);
    }

    @Test
    public void testMultipleRegularStatementFormat() {
        statement.addRental(new Rental(regular1, 1));
        statement.addRental(new Rental(regular2, 2));
        statement.addRental(new Rental(regular3, 3));

        String expected = "Rental Record for Customer\n" +
                "\tRegular 1\t2.0\n" +
                "\tRegular 2\t2.0\n" +
                "\tRegular 3\t3.5\n" +
                "Amount owed is 7.5\n" +
                "You earned 3 frequent renter points";

        assertThat(statement.generate()).isEqualTo(expected);
    }

}
