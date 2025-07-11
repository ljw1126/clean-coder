package com.example.cleancoder.functionstructure.movie;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    double determineAmount() {
        return movie.determineAmount(daysRented);
    }

    int determineFrequentRentalPoint() {
        return movie.determineFrequentRentalPoint(daysRented);
    }
}
