package LLD.LiftSystem.controller;

import LLD.LiftSystem.models.Lift;

import java.util.List;

public class LiftController {
    private List<Lift> lifts;

    public LiftController(List<Lift> lifts) {
        this.lifts = lifts;
    }

    // this logic could have been moved to service.
    // kept it simple here.
    // similar methods in Lift Model can be moved to service.
    public void requestLift(int floor) {
        // Logic to assign a lift based on the request
        if (!lifts.isEmpty()) {
            // can be made more complex.
            lifts.get(0).handleRequest(floor);
        } else {
            System.out.println("No lifts available");
        }
    }
}