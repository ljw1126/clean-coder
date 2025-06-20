package com.example.cleancoder.repeatedswitch;

public class NorwegianBlueParrot extends Parrot {
    protected final double voltage;
    protected final boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        super(ParrotTypeEnum.NORWEGIAN_BLUE);
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }

    public String getCry() {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }
}
