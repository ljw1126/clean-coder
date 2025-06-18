package com.example.cleancoder.solid.ocp;

public abstract class Expense {
    public enum Type {DINNER, BREAKFAST, CAR_RENTAL};
    public Type type;
    public int amount;

    public Expense(Type type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract boolean isOverage();
    abstract boolean isMeal();
}
