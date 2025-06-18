package com.example.cleancoder.solid.ocp;

public class ExpenseReportNamer implements ExpenseNamer {

    @Override
    public String getName(Expense expense) {
        String name = "TILT";
        if(expense instanceof DinnerExpense)
            name = "Dinner";
        else if(expense instanceof BreakfastExpense)
            name = "Breakfast";
        else if(expense instanceof CarRentalExpense)
            name = "Car Rental";

        return name;
    }
}
