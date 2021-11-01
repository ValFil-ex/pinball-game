package Elements;

import Actions.Action;

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
