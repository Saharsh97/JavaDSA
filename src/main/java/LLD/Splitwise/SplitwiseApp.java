package LLD.Splitwise;

import LLD.Splitwise.models.User;
import LLD.Splitwise.models.facades.SplitwiseFacade;
import LLD.Splitwise.models.observers.ExpenseObserver;

import java.util.Arrays;

public class SplitwiseApp {
    public static void main(String[] args) {
        SplitwiseFacade splitwise = new SplitwiseFacade();

        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");

        splitwise.addUser(user1);
        splitwise.addUser(user2);

        splitwise.addObserver(new ExpenseObserver());

        splitwise.addEqualExpense(100.0, Arrays.asList(user1, user2));

        // Additional operations...
    }
}
