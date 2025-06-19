package com.example.cleancoder.solid.ocp;

public class DinnerExpense extends Expense {
    public DinnerExpense(int amount) {
        super(Type.DINNER, amount);
    }

    public boolean isMeal() {
        return true;
    }

    public boolean isOverage() {
        return amount > 5000;
    }
}
