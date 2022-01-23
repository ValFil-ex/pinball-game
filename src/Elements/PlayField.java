package Elements;

import Actions.Action;
import Visitors.ResetVisitor;

import java.util.ArrayList;
import java.util.List;

public class PlayField {

    private static PlayField instance;
    private int totalScore;

    private List<PlayfieldElement>playfieldElements = new ArrayList<>();
    private List<Action>actions = new ArrayList<>();

    private PlayField(){

    }

    public static PlayField initialisePlayfield(){
        if(instance == null){
            instance = new PlayField();
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
        totalScore = 0;
        for (PlayfieldElement playfieldElement : playfieldElements){
            totalScore += playfieldElement.getScore();
        }
        return totalScore;
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
