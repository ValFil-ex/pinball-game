package Actions;

import Elements.Bumper;

public class HitBumper implements Action {
    Bumper bumper;

    public HitBumper(Bumper bumper){
        this.bumper = bumper;
    }

    @Override
    public void execute() {
        bumper.score();
    }
}
