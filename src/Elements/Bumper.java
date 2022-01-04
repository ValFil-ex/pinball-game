package Elements;

import Actions.Action;
import GameStates.CurrentGame;

public class Bumper implements PlayfieldElement{

    private int score;
    private String name;
    private int points;

    public int getScore() {
        return score;
    }

    public Bumper(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public int score() {
        score += points;
        return points;
    }
}
