package LLD.Splitwise.models.facades;

import LLD.Splitwise.models.Expense;
import LLD.Splitwise.models.User;
import LLD.Splitwise.models.factories.EqualExpenseFactory;
import LLD.Splitwise.models.factories.ExpenseFactory;
import LLD.Splitwise.models.observers.Observer;
import LLD.Splitwise.services.UserManager;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseFacade {
    private UserManager userManager;
    private List<Expense> expenses;
    private List<Observer> observers;

    public SplitwiseFacade() {
        userManager = UserManager.getInstance();
        expenses = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addUser(User user) {
        userManager.addUser(user);
    }

    public void addEqualExpense(double totalAmount, List<User> participants) {
        ExpenseFactory factory = new EqualExpenseFactory();
        Expense expense = factory.createExpense(totalAmount, participants);
        expenses.add(expense);

        notifyObservers();
    }

    // Other facade methods...

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}