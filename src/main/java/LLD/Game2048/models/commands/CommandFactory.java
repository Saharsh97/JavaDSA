package LLD.Game2048.models.commands;

import LLD.Game2048.models.Direction;

public class CommandFactory {
    public MoveCommand createCommand(Direction direction) {
        switch (direction) {
            case LEFT:
                return new MoveLeftCommand();
            case RIGHT:
                return new MoveRightCommand();
            case UP:
                return new MoveUpCommand();
            case DOWN:
                return new MoveDownCommand();
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}