package Elements;

public class Ramp implements PlayfieldElement{
    private int score;
    private String name;
    private int points;
    private boolean isOpen;

    public int getScore() {
        return score;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Ramp(String name, boolean isOpen, int points) {
        this.name = name;
        this.isOpen = isOpen;
        this.points = points;
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
        score += assignedPoints;
        return assignedPoints;
    }
}
