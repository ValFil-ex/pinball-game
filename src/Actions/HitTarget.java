package Actions;

import java.util.ArrayList;
import java.util.List;

public class HitTarget implements Action{

    private List<Action> actions = new ArrayList<>();


    @Override
    public void execute() {
        actions.forEach(Action::execute);
        System.out.println("target was hit!");
    }

    public void addAction(Action action){
        actions.add(action);
    }
}
