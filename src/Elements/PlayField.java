package Elements;

import Actions.Action;
import Visitors.ResetVisitor;
import Visitors.ScoreVisitor;

import java.util.ArrayList;
import java.util.List;

public class PlayField {

    private static PlayField instance;
    private int totalScore;
    private ScoreVisitor scoreVisitor;

    private List<PlayfieldElement>playfieldElements = new ArrayList<>();
    private List<Action>actions = new ArrayList<>();

    private PlayField(ScoreVisitor scoreVisitor){
this.scoreVisitor = scoreVisitor;
    }

    public static PlayField initialisePlayfield(ScoreVisitor scoreVisitor){
        if(instance == null){
            instance = new PlayField(scoreVisitor);
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
            playfieldElement.resetScore();
        }
    }

    public void resetElements(ResetVisitor resetVisitor){
        for (PlayfieldElement playfieldElement : playfieldElements){
            playfieldElement.accept(resetVisitor);
        }
    }


}
