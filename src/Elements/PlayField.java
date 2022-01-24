package Elements;

import Actions.Action;
import Visitors.CountResetVisitor;
import Visitors.ElementResetVisitor;
import Visitors.ScoreVisitor;

import java.util.ArrayList;
import java.util.List;

public class PlayField {

    private static PlayField instance;
    private int totalScore;
    private ScoreVisitor scoreVisitor;
    private ElementResetVisitor elementResetVisitor;
    private CountResetVisitor countResetVisitor;

    private List<PlayfieldElement>playfieldElements = new ArrayList<>();
    private List<Action>actions = new ArrayList<>();

    private PlayField(ScoreVisitor scoreVisitor, ElementResetVisitor elementResetVisitor, CountResetVisitor countResetVisitor){
        this.scoreVisitor = scoreVisitor;
        this.elementResetVisitor = elementResetVisitor;
        this.countResetVisitor = countResetVisitor;
    }

    public static PlayField initialisePlayfield(ScoreVisitor scoreVisitor, ElementResetVisitor elementResetVisitor, CountResetVisitor countResetVisitor){
        if(instance == null){
            instance = new PlayField(scoreVisitor, elementResetVisitor, countResetVisitor);
        }
        return instance;
    }

    public void add (PlayfieldElement e){
        playfieldElements.add(e);
    }

    public void setActions(Action action) {
        actions.add(action);
    }

    public Action getAction(int index) {
        return actions.get(index);
    }


    public int getElementsScore() {
        scoreVisitor.resetScoreCount();
        for (PlayfieldElement playfieldElement : playfieldElements){
            playfieldElement.accept(scoreVisitor);
        }
        return scoreVisitor.getScore();
    }

    public void resetElementsAndScore(){
        for (PlayfieldElement playfieldElement : playfieldElements){
            playfieldElement.accept(elementResetVisitor);
            playfieldElement.accept(countResetVisitor);
        }
    }

    public void resetElements(){
        for (PlayfieldElement playfieldElement : playfieldElements){
            playfieldElement.accept(elementResetVisitor);
        }
    }


}
