package LLD.Splitwise.models.factories;

import LLD.Splitwise.models.Expense;
import LLD.Splitwise.models.UnequalExpense;
import LLD.Splitwise.models.User;

import java.util.List;

public class UnequalExpenseFactory implements ExpenseFactory {
    public Expense createExpense(double totalAmount, List<User> participants) {
        return new UnequalExpense(totalAmount, participants);
    }
}