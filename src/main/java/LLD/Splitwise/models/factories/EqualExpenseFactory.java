package LLD.Splitwise.models.factories;

import LLD.Splitwise.models.EqualExpense;
import LLD.Splitwise.models.Expense;
import LLD.Splitwise.models.User;

import java.util.List;

public class EqualExpenseFactory implements ExpenseFactory {
    public Expense createExpense(double totalAmount, List<User> participants) {
        return new EqualExpense(totalAmount, participants);
    }
}