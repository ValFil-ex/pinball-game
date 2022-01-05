package Actions;

import Elements.Ramp;

public class OpenRamp implements Action{
    private Ramp ramp;

    public OpenRamp(Ramp ramp){
        this.ramp = ramp;
    }

    @Override
    public void execute() {
        if(!ramp.isOpen()){
            System.out.printf("You have opened the ramp! Send the ball there to collect more points!\n");
            ramp.setOpen(true);
        }
        //int points = ramp.score();
    }
}
