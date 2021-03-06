package Elements;

import Visitors.Visitor;

public class Ramp implements PlayfieldElement{
    private String name;
    private int points;
    private boolean isOpen;
    private int timesHit;


    public Ramp(String name, boolean isOpen, int points) {
        this.name = name;
        this.isOpen = isOpen;
        this.points = points;
    }

    public void resetCount(){
        this.timesHit = 0;
    }

    public int getPoints() {
        return points;
    }

    public int getTimesHit() {
        return timesHit;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void resetElement() {
        this.isOpen = false;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    @Override
    public int score() {
        int assignedPoints;
        if(isOpen){
            assignedPoints = points;
        }else{
            isOpen = true;
            assignedPoints = 0;
        }
        timesHit+=1;
        return assignedPoints;
    }
}
