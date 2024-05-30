package LLD.Splitwise.models;

import LLD.Splitwise.models.strategies.UnequalSplitStrategy;

import java.util.List;

public class UnequalExpense extends Expense {
    public UnequalExpense(double totalAmount, List<User> participants) {
        super(totalAmount, participants, new UnequalSplitStrategy());
    }

    public void calculateShares() {
        shares = splitStrategy.splitExpense(totalAmount, participants);
    }
}