package GameStates;
import java.util.Scanner;
public class EndState implements GameStateInterface{
    @Override
    public void enterState(CurrentGame currentGame) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is your last chance to win! Press 1 to hit the ball");
        //new!!
        int command = scanner.nextInt();
        if(command == 1){
            currentGame.calculateResult();
        }
    }

    @Override
    public void onInsertCoin(CurrentGame currentGame) {

    }

    @Override
    public void onStart(CurrentGame currentGame) {
        System.out.println("The game is already on! Watch the ball!");
    }

    @Override
    public void onGameOver(CurrentGame currentGame) {
        System.out.println("Game Over!");
        int credits = currentGame.getCredits();
        if(credits!=0){
            currentGame.setPinballGameState(new ReadyState());
            currentGame.getPinballGameState().enterState(currentGame);
        }else {
            currentGame.setPinballGameState(new NoCreditState());
            currentGame.getPinballGameState().enterState(currentGame);
        }
    }
}
