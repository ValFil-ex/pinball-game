package Elements;

import Actions.Action;
import Visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public interface PlayfieldElement {


    int score();

    int getScore();

    void resetScore(); //when transition to next level

    void resetElement(); //when game is over but playing session continues

    public void accept( Visitor visitor);




}
