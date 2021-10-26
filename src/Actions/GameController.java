package Actions;

public class GameController {
    private Command command;


    public void executeCommand(Command command){
        command.execute();
    }


}
