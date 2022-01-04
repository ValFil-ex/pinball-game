package Actions;

import Elements.PlayfieldElement;

public class ScorePoints implements Action{
    public PlayfieldElement el;

    public ScorePoints(PlayfieldElement el){
        this.el = el;
    }

    @Override
    public void execute() {
        int points = el.score();
        System.out.printf("You've just scored %d points!\n", points);
    }
}
