package Visitors;

import Elements.PlayfieldElement;

public class ScoreVisitor implements Visitor{
    int score;

    public ScoreVisitor() {
        this.score = 0;
    }

    @Override
    public void visit(PlayfieldElement element) {
        int timesHit = element.getTimesHit();
        int points = element.getPoints();
        score+=(timesHit*points);
    }

    public int getScore() {
        return score;
    }

    public void resetScoreCount(){
        this.score = 0;
    }
}
