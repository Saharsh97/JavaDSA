package LLD.LiftSystem.models.liftStates;

import LLD.LiftSystem.models.Lift;

public interface LiftState {
    void handleRequest(Lift lift, int floor);
}
