package Elements;

import Actions.Action;

import java.util.ArrayList;
import java.util.List;

public class PlayfieldElement {

    protected final String name;
    public Action action;

    public PlayfieldElement(String name){
        this.name = name;
    };

    public void executeCommand(Action action){
        action.execute();

    };

}
