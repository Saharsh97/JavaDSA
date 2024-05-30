package LLD.LiftSystem.models.strategies;

import LLD.LiftSystem.models.Lift;
import LLD.LiftSystem.models.liftStates.StoppedState;

public class DefaultMovementStrategy implements MovementStrategy {
    // this needs more logic.
    public void move(Lift lift, int floor) {
        lift.setState(new StoppedState());
        System.out.println("Lift is stopped at floor: " + floor);
        lift.setCurrentFloor(floor);
    }
}
