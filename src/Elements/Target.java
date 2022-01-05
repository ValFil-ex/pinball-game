package Elements;

import Actions.Action;

public class Target implements PlayfieldElement{

    private int score;
    private String name;
    private int points;

    public int getScore() {
        return score;
    }

    public void resetScore(){
        this.score = 0;
    }

    @Override
    public void resetElement() {

    }

    public Target(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public int score() {
        score += points;
        return points;
    }
}
