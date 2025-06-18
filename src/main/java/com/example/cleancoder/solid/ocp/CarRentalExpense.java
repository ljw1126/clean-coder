package com.example.cleancoder.solid.ocp;

public class CarRentalExpense extends Expense {
    public CarRentalExpense(int amount) {
        super(Type.CAR_RENTAL, amount);
    }

    public boolean isMeal() {
        return false;
    }

    public boolean isOverage() {
        return false;
    }
}
