package Actions;

import Elements.Bumper;

import java.util.ArrayList;
import java.util.List;

public class HitBumper implements Action {


    private List<Action> actions = new ArrayList<>();


    @Override
    public void execute() {
        actions.forEach(Action::execute);
    }

    public void addAction(Action action){
        actions.add(action);
    }
}
