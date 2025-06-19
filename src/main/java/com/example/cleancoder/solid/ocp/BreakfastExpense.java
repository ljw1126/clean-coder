package com.example.cleancoder.solid.ocp;

public class BreakfastExpense extends Expense {
    public BreakfastExpense(int amount) {
        super(Type.BREAKFAST, amount);
    }

    public boolean isMeal() {
        return true;
    }

    public boolean isOverage() {
        return amount > 1000;
    }
}
