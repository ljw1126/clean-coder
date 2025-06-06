package com.example.cleancoder.tdd.bowling;

public class Game {
    private int[] rolls;
    private int currentRoll;

    public Game() {
        this.rolls = new int[21];
        this.currentRoll = 0;
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int firstRollInFrame = 0;
        for(int frame = 0; frame < 10; frame++) {
            if(isSpare(firstRollInFrame)) {
                score += (10 + nextBallForSpare(firstRollInFrame));
                firstRollInFrame += 2;
            } else if(isStrike(firstRollInFrame)) {
                score += (10 + nextBallForStrike(firstRollInFrame));
                firstRollInFrame += 1;
            } else {
                score += nextBallForFrame(firstRollInFrame);
                firstRollInFrame += 2;
            }
        }

        return score;
    }

    private int nextBallForSpare(int firstRollInFrame) {
        return rolls[firstRollInFrame + 2];
    }

    private int nextBallForStrike(int firstRollInFrame) {
        return rolls[firstRollInFrame + 1] + rolls[firstRollInFrame + 2];
    }

    private int nextBallForFrame(int firstRollInFrame) {
        return rolls[firstRollInFrame] + rolls[firstRollInFrame + 1];
    }

    private boolean isSpare(int firstRollInFrame) {
        return rolls[firstRollInFrame] + rolls[firstRollInFrame + 1] == 10;
    }

    private boolean isStrike(int firstRollInFrame) {
        return rolls[firstRollInFrame] == 10;
    }
}
