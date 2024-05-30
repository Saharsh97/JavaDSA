package LLD.LiftSystem;

import LLD.LiftSystem.controller.LiftController;
import LLD.LiftSystem.models.Lift;

import java.util.List;

public class LiftApp {
    public static void main(String[] args) {
        Lift lift1 = new Lift();
        LiftController liftController = new LiftController(List.of(lift1));

        liftController.requestLift(3);
        liftController.requestLift(5);
        liftController.requestLift(2);
    }
}
