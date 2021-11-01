package Elements;

import Actions.Action;
import GameStates.CurrentGame;

public class Bumper extends PlayfieldElement{

    private Action action;

    public Bumper(String name){
        super(name);
    }

    //not necessary - method declared in parent class
   /* public void executeCommand(Action action){ action.execute(); }*/


}
