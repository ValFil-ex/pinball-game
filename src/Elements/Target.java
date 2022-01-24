package Elements;

import Actions.Action;
import Visitors.Visitor;

public class Target implements PlayfieldElement{

    private String name;
    private int points;
    private int timesHit;

    public int getPoints() {
        return points;
    }

    public int getTimesHit() {
        return timesHit;
    }

    public void resetCount(){
        this.timesHit = 0;
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
        timesHit+=1;
        return points;
    }
}
