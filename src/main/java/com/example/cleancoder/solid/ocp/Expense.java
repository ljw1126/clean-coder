package com.example.cleancoder.solid.ocp;

import static com.example.cleancoder.solid.ocp.Expense.Type.*;

public class Expense {
    public enum Type {DINNER, BREAKFAST, CAR_RENTAL};
    public Type type;
    public int amount;

    public Expense(Type type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public boolean isMeal() {
        return type == BREAKFAST || type == DINNER;
    }

    public boolean isOverage() {
        return (type == DINNER && amount > 5000)
                || (type == BREAKFAST && amount > 1000);
    }
}
