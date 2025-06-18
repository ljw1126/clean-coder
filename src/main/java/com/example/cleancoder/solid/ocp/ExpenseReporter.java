package com.example.cleancoder.solid.ocp;

import static com.example.cleancoder.solid.ocp.Expense.Type.BREAKFAST;
import static com.example.cleancoder.solid.ocp.Expense.Type.DINNER;

public class ExpenseReporter {
    private final ExpenseReport expenseReport = new ExpenseReport();
    private ReportPrinter printer;

    public ExpenseReporter() {
    }

    public void printReport(ReportPrinter printer) {
        this.printer = printer;
        totalUpExpenses();
        printExpensesAndTotals();
    }

    private void printExpensesAndTotals() {
        printHeader();

        printExpenses();

        printTotals();
    }

    private void totalUpExpenses() {
        expenseReport.totalUpExpenses();
    }

    public void addExpense(Expense expense) {
        expenseReport.addExpense(expense);
    }

    private void printExpenses() {
        for(Expense expense : expenseReport.expenses)
            printExpense(expense);
    }

    private void printExpense(Expense expense) {
        printer.print(String.format("%s\t%s\t$%.02f\n",
                isOverage(expense) ? "X" : " ",
                getName(expense), penniesToDollars(expense.amount)));
    }

    private boolean isOverage(Expense expense) {
        return (expense.type == DINNER && expense.amount > 5000)
                || (expense.type == BREAKFAST && expense.amount > 1000);
    }

    private static String getName(Expense expense) {
        String name = "TILT";
        switch (expense.type) {
            case DINNER: name = "Dinner"; break;
            case BREAKFAST: name = "Breakfast"; break;
            case CAR_RENTAL: name = "Car Rental"; break;
        }
        return name;
    }

    private void printHeader() {
        printer.print("Expenses " + getDate() + "\n");
    }

    private void printTotals() {
        printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(expenseReport.mealExpenses)));
        printer.print(String.format("\nTotal $%.02f", penniesToDollars(expenseReport.total)));
    }

    private double penniesToDollars(int amount) {
        return amount / 100.0;
    }

    private String getDate() {
        return "9/12/2002";
    }
}
