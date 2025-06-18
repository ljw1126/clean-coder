package com.example.cleancoder.solid.ocp;

import java.util.ArrayList;
import java.util.List;

import static com.example.cleancoder.solid.ocp.Expense.Type.BREAKFAST;
import static com.example.cleancoder.solid.ocp.Expense.Type.DINNER;

public class ExpenseReport {
    protected List<Expense> expenses = new ArrayList<>();
    protected int total;
    protected int mealExpenses;

    public ExpenseReport() {
        this.total = 0;
        this.mealExpenses = 0;
    }

    protected void totalUpExpenses() {
        for (Expense expense : expenses)
            addTotals(expense);
    }

    private void addTotals(Expense expense) {
        if (expense.isMeal())
            mealExpenses += expense.amount;

        total += expense.amount;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
