package LLD.LiftSystem.models;

import LLD.LiftSystem.models.liftStates.LiftState;
import LLD.LiftSystem.models.liftStates.StoppedState;
import LLD.LiftSystem.models.observer.Observer;
import LLD.LiftSystem.models.strategies.DefaultMovementStrategy;
import LLD.LiftSystem.models.strategies.MovementStrategy;

public class Lift implements Observer {
    private LiftState currentState;
    private MovementStrategy movementStrategy;
    private int currentFloor;

    public Lift() {
        this.currentState = new StoppedState();
        this.movementStrategy = new DefaultMovementStrategy();
    }

    public void handleRequest(int floor) {
        currentState.handleRequest(this, floor);
        move();
    }

    public void move() {
        movementStrategy.move(this, currentFloor);
    }

    public void update(int floor) {
        // Observer pattern update logic
    }

    public void setState(LiftState state) {
        this.currentState = state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
