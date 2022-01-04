package Elements;

import Actions.Action;

public class Ball {
    private Action action;

    public void execute(Action action){
        action.execute();
    };
}
