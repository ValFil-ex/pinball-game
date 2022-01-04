package Elements;

import Actions.Action;

public class Ball {
    private Action action;

    public void hit(Action action){
        action.execute();
    };
}
