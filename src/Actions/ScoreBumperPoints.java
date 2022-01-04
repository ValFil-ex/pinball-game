package Actions;

import Elements.Bumper;
import GameStates.CurrentGame;

import java.util.ArrayList;

public class ScoreBumperPoints implements Action{

    private Bumper bumper;

    public ScoreBumperPoints(Bumper bumper){
        this.bumper = bumper;
    }

    @Override
    public void execute() {
        int points = bumper.score();
        System.out.printf("You've just scored %d points!\n", points);
    }
}
