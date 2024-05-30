package LLD.Game2048.models.commands;

import LLD.Game2048.models.Direction;
import LLD.Game2048.service.GameManager;

public class MoveDownCommand implements MoveCommand {
    public void execute() {
        GameManager.getInstance().move(Direction.DOWN);
    }
}