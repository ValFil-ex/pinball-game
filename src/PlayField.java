import Elements.ScorableElement;

import java.util.ArrayList;
import java.util.List;

public class PlayField {

    private static PlayField instance;

    private List<ScorableElement> scorableElements;

    private PlayField(){

        this.scorableElements = new ArrayList<>();
    }

    public static PlayField initialisePlayfield(){
        if(instance == null){
            instance = new PlayField();
        }
        return instance;
    }

    public void add (ScorableElement e){
        scorableElements.add(e);
    }





}
