package GameStates;

import java.util.Scanner;

public class NoCreditState implements GameStateInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void enterState(GameController currentGame) {
        System.out.println("Your current credit is 0. Please insert a coin or press 0 to exit");
        int coins = scanner.nextInt();

        if(coins>0){
            currentGame.insertCoin(coins);
        }else if(coins == 0){
            currentGame.turnOff();
        }else{
            currentGame.turnOn();
        }

    }

    @Override
    public void onInsertCoin(GameController currentGame) {
        currentGame.setPinballGameState(new ReadyState());
        currentGame.getPinballGameState().enterState(currentGame);
    }

    @Override
    public void onStart(GameController currentGame) {
        System.out.println("No credit. Please insert a coin");
    }

    @Override
    public void onGameOver(GameController currentGame) {

    }


}
