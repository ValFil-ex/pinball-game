package Actions;

import Elements.Ramp;
import GameStates.CurrentGame;

public class OpenRamp implements Action{
    CurrentGame currentGame;

    public OpenRamp(CurrentGame currentGame) {
        this.currentGame = currentGame;
    }

    @Override
    public void execute() {

    }
}
