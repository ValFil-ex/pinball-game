package Elements;

public class Ramp extends PlayfieldElement{
    private boolean open = false;

    public Ramp(String name) {
        super(name);
    }


    public void changeState(){
        if(!open){
          open = true;
            System.out.println("Ramp is open now");
        }

    }
}
