package Actions;

import Elements.Bumper;
import GameStates.CurrentGame;

import java.util.ArrayList;

public class ScoreBumperPoints implements Action{

    CurrentGame currentGame;
    int points = 200;

    public ScoreBumperPoints(CurrentGame currentGame){
        this.currentGame = currentGame;

    }

    @Override
    public void execute() {
        currentGame.score(points);
        System.out.printf("You've just scored %d points!\n", points);
    }
}
