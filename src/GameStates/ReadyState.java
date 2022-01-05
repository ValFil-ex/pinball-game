package GameStates;

import java.util.Scanner;

public class ReadyState implements GameStateInterface {

    Scanner scanner = new Scanner(System.in);
    @Override
    public void enterState(CurrentGame currentGame) {
        int credits = currentGame.getCredits();
        int command;
        System.out.printf("Your current credit is %d. Press 1 to begin the play or any other number to exit \n", credits);
        command = scanner.nextInt();
        if(command == 1){
            currentGame.startGame();
        }else{
            currentGame.turnOff();
        }

    }

    @Override
    public void onInsertCoin(CurrentGame currentGame) {
        currentGame.setPinballGameState(new ReadyState());
        enterState(currentGame);
    }

    @Override
    public void onStart(CurrentGame currentGame) {
        currentGame.setPinballGameState(new PlayingState());
        currentGame.getPinballGameState().enterState(currentGame);
    }

    @Override
    public void onGameOver(CurrentGame currentGame) {

    }

}
