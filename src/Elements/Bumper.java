package Elements;

import GameStates.CurrentGame;

public class Bumper extends ScorableElement{

    private int points  = 200;
    CurrentGame currentGame;

    public Bumper(CurrentGame currentGame) {
        this.currentGame = currentGame;
    }

    public void score() {
        this.currentGame.changeScore(points);
        System.out.printf("You've just scored %d points!\n", points);
    }
}
