package com.example.cleancoder.tdd.basic;

public class Movie {
    private int sumOfRate;
    private int countOfRate;

    public Movie() {
        this(0, 0);
    }

    public Movie(int sumOfRate, int countOfRate) {
        this.sumOfRate = sumOfRate;
        this.countOfRate = countOfRate;
    }

    public void rate(int rate) {
        this.sumOfRate += rate;
        this.countOfRate += 1;
    }

    public int averageRating() {
        return this.countOfRate == 0 ? 0 : this.sumOfRate / countOfRate;
    }
}
