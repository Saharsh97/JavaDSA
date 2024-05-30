package LLD.LiftSystem.models.liftStates;

import LLD.LiftSystem.models.Lift;

public class StoppedState implements LiftState {
    public void handleRequest(Lift lift, int floor) {
        System.out.println("Lift is stopped at floor: " + floor);
        lift.setCurrentFloor(floor);
        // Change state or stop based on requirements
    }
}