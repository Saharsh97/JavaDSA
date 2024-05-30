package LLD.LiftSystem.commands;

import LLD.LiftSystem.models.Lift;

public class RequestCommand implements LiftCommand {
    private Lift lift;
    private int floor;

    public RequestCommand(Lift lift, int floor) {
        this.lift = lift;
        this.floor = floor;
    }

    public void execute() {
        lift.handleRequest(floor);
    }
}