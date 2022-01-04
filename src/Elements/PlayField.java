package Elements;

import java.util.ArrayList;
import java.util.List;

public class PlayField {

    private static PlayField instance;
    public int totalScore;

    private List<PlayfieldElement>playfieldElements = new ArrayList<>();

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


    public int getElementsScore() {
        for (PlayfieldElement playfieldElement : playfieldElements){
            totalScore += playfieldElement.getScore();
        }
        return totalScore;
    }
}
