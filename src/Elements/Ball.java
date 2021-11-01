package Elements;

import Actions.Action;

public class Ball {
    private Action action;


    public void executeCommand(Action action){
        action.execute();
    }


}
