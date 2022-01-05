package Actions;

import Elements.Ramp;

public class RunRamp implements Action{
    private Ramp ramp;

    public RunRamp(Ramp ramp){
        this.ramp = ramp;
    }

    @Override
    public void execute() {
        if(!ramp.isOpen()){
            System.out.printf("The ball bounced back - ramp is closed! Hit the target to open the ramp\n");
        }else{
            int points = ramp.score();
            System.out.printf("You've just run the ramp and scored %d points!\n", points);
        }
    }
}
