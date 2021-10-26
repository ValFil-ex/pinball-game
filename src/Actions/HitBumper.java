package Actions;

import Elements.Bumper;

public class HitBumper implements Command{
    Bumper bumper;

    public HitBumper(Bumper bumper){
        this.bumper = bumper;
    }

    @Override
    public void execute() {
        bumper.score();
    }
}
