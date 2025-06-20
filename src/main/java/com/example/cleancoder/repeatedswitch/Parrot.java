package com.example.cleancoder.repeatedswitch;

public abstract class Parrot {
    protected final ParrotTypeEnum type;

    protected Parrot(ParrotTypeEnum type) {
        this.type = type;
    }

    public static Parrot of(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        return switch (type) {
            case EUROPEAN -> new EuropeanParrot();
            case AFRICAN -> new AfricanParrot(numberOfCoconuts);
            case NORWEGIAN_BLUE -> new NorwegianBlueParrot(voltage, isNailed);
        };
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

    public abstract double getSpeed();
    public abstract String getCry();
}
