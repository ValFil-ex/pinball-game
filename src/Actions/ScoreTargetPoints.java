package Actions;

import GameStates.CurrentGame;

public class ScoreTargetPoints implements Action{
    private CurrentGame currentGame;
    private int points = 500;

    public ScoreTargetPoints(CurrentGame currentGame){
        this.currentGame = currentGame;

    }

    @Override
    public void execute() {
        currentGame.score(points);
        System.out.printf("You've just scored %d points!\n", points);
    }
}
