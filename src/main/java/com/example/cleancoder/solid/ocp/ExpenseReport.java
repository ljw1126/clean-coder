package com.example.cleancoder.solid.ocp;

import java.util.ArrayList;
import java.util.List;

import static com.example.cleancoder.solid.ocp.Expense.Type.BREAKFAST;
import static com.example.cleancoder.solid.ocp.Expense.Type.DINNER;

public class ExpenseReport {
    private List<Expense> expenses = new ArrayList<Expense>();

    public void printReport(ReportPrinter printer) {
        int total = 0;
        int mealExpenses = 0;

        printer.print("Expenses " + getDate() + "\n");

        for (Expense expense : expenses) {
            if (expense.type == BREAKFAST || expense.type == DINNER)
                mealExpenses += expense.amount;

            String name = "TILT";
            switch (expense.type) {
                case DINNER: name = "Dinner"; break;
                case BREAKFAST: name = "Breakfast"; break;
                case CAR_RENTAL: name = "Car Rental"; break;
            }

            printer.print(String.format("%s\t%s\t$%.02f\n",
                    (  (expense.type == DINNER && expense.amount > 5000)
                            || (expense.type == BREAKFAST && expense.amount > 1000)) ? "X" : " ",
                    name, penniesToDollars(expense.amount)));

            total += expense.amount;
        }

        printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(mealExpenses)));
        printer.print(String.format("\nTotal $%.02f", penniesToDollars(total)));
    }

    private double penniesToDollars(int amount) {
        return amount / 100.0;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    private String getDate() {
        return "9/12/2002";
    }
}
