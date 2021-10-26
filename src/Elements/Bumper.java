package Elements;

import GameStates.CurrentGameState;

public class Bumper extends ScorableElement {

    private int points  = 200;
    CurrentGameState currentGameState;

    public Bumper(CurrentGameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public void score() {
        this.currentGameState.changeScore(points);
    }
}
