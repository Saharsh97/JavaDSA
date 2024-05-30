package LLD.LiftSystem.models.liftStates;

import LLD.LiftSystem.models.Lift;

public class MovingUpState implements LiftState {
    public void handleRequest(Lift lift, int floor) {
        if (floor > lift.getCurrentFloor()) {
            System.out.println("Moving up to floor: " + floor);
            lift.setCurrentFloor(floor);
        }
        // Change state or stop based on requirements
    }
}