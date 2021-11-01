package Actions;

import Elements.Ramp;

public class OpenRamp implements Action{

    Ramp ramp;

    public OpenRamp(Ramp ramp) {
        this.ramp = ramp;
    }

    @Override
    public void execute() {
        ramp.changeState();
    }
}
