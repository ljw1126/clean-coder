package com.example.cleancoder.functionstructure.movie;

public class NewReleaseMovie extends Movie {
  public NewReleaseMovie(String title) {
    super(title, Movie.NEW_RELEASE);
  }

  @Override
  double determineAmount(int daysRented) {
    return daysRented * (double)3;
  }

  @Override
  int determineFrequentRentalPoint(int daysRented) {
    return daysRented > 1 ? 2 : 1;
  }
}
