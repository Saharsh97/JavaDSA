package LLD.Splitwise.models.strategies;

import LLD.Splitwise.models.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    Map<User, Double> splitExpense(double totalAmount, List<User> participants);
}