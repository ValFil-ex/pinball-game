import Elements.PlayfieldElement;

import java.util.ArrayList;
import java.util.List;

public class PlayField {

    private static PlayField instance;

    private List<PlayfieldElement> playfieldElements;

    private PlayField(){

        this.playfieldElements = new ArrayList<>();
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





}
