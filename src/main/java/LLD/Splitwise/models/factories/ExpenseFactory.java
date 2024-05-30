package LLD.Splitwise.models.factories;

import LLD.Splitwise.models.Expense;
import LLD.Splitwise.models.User;

import java.util.List;

public interface ExpenseFactory {
    Expense createExpense(double totalAmount, List<User> participants);
}
