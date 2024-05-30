package LLD.LiftSystem.models.strategies;

import LLD.LiftSystem.models.Lift;

public interface MovementStrategy {
    void move(Lift lift, int floor);
}
