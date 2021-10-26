package Actions;

import Elements.Target;

public class HitTarget implements Command{

    Target target;

    public HitTarget(Target target){
        this.target = target;
    }

    @Override
    public void execute() {
        target.score();
    }
}
