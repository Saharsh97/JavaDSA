package LLD.Splitwise.models.strategies;

import LLD.Splitwise.models.User;

import java.util.List;
import java.util.Map;

public class UnequalSplitStrategy implements SplitStrategy {
    public Map<User, Double> splitExpense(double totalAmount, List<User> participants) {
        // Custom splitting logic based on user preferences, weights, etc.
        // For simplicity, we'll use equal splitting for demonstration purposes.
        return new EqualSplitStrategy().splitExpense(totalAmount, participants);
    }
}