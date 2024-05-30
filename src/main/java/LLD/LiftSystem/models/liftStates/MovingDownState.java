package LLD.LiftSystem.models.liftStates;

import LLD.LiftSystem.models.Lift;

public class MovingDownState implements LiftState {
    public void handleRequest(Lift lift, int floor) {
        if (floor < lift.getCurrentFloor()) {
            System.out.println("Moving down to floor: " + floor);
            lift.setCurrentFloor(floor);
        }
        // Change state or stop based on requirements
    }
}
