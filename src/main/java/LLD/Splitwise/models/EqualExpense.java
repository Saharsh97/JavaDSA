package LLD.Splitwise.models;

import LLD.Splitwise.models.strategies.EqualSplitStrategy;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(double totalAmount, List<User> participants) {
        super(totalAmount, participants, new EqualSplitStrategy());
    }

    public void calculateShares() {
        shares = splitStrategy.splitExpense(totalAmount, participants);
    }
}


