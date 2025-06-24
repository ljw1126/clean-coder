package com.example.cleancoder.repeatedswitch;

public class EuropeanParrot extends Parrot {

    public EuropeanParrot() {
        super(ParrotTypeEnum.EUROPEAN);
    }

    public double getSpeed() {
        return getBaseSpeed();
    }

    public String getCry() {
        return "Sqoork!";
    }
}
