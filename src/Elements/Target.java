package Elements;

import Actions.Action;
import Visitors.Visitor;

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

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
