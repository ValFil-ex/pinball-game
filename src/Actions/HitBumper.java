package Actions;

import java.util.ArrayList;
import java.util.List;

public class HitBumper implements Action {


    private List<Action> actions = new ArrayList<>();


    public HitBumper() {

    }

    @Override
    public void execute() {
        actions.forEach(Action::execute);
    }

    public void addAction(Action action){
        actions.add(action);
    }
}
