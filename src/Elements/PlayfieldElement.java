package Elements;

import Visitors.Visitor;

public interface PlayfieldElement {


    int score(); //times hit count ++

    void resetCount(); //when transition to next level, i.e. times hit count = 0

    void resetElement(); //when game is over but playing session continues, i.e. times hit count persists

    void accept( Visitor visitor);

    int getTimesHit();

    int getPoints();
}
