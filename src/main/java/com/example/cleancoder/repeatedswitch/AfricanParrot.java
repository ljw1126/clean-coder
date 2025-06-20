package com.example.cleancoder.repeatedswitch;

public class AfricanParrot extends Parrot {
    protected final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        super(ParrotTypeEnum.AFRICAN);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

    public String getCry() {
        return "Sqaark!";
    }
}
