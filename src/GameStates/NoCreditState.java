package GameStates;

public class NoCreditState implements GameStateInterface {


    @Override
    public void enterState(CurrentGameState currentGameState) {
        System.out.println("Your credit is 0. Please insert a coin");
    }

    @Override
    public void onInsertCoin(CurrentGameState currentGameState) {
        currentGameState.setPinballGameState(new ReadyState());
        currentGameState.getPinballGameState().enterState(currentGameState);
    }

    @Override
    public void onStart(CurrentGameState currentGameState) {
        System.out.println("No credit. Please insert a coin");
    }

    @Override
    public void onGameOver(CurrentGameState currentGameState) {

    }


}
