package LLD.Splitwise.models.commands;

import LLD.Splitwise.models.Expense;

public class AddExpenseCommand implements ExpenseCommand {
    private Expense expense;

    public AddExpenseCommand(Expense expense) {
        this.expense = expense;
    }

    public void execute() {
        // Execute add expense logic...
        expense.calculateShares();
    }
}
