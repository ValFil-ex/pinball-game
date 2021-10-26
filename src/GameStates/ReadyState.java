package GameStates;

public class ReadyState implements GameStateInterface {


    @Override
    public void enterState(CurrentGameState currentGameState) {
        int credits = currentGameState.getCredits();
        System.out.printf("Your credit is %d. Press start to begin the play \n", credits);
    }

    @Override
    public void onInsertCoin(CurrentGameState currentGameState) {
        currentGameState.setPinballGameState(new ReadyState());
        enterState(currentGameState);
    }

    @Override
    public void onStart(CurrentGameState currentGameState) {
        currentGameState.setPinballGameState(new PlayingState());
        currentGameState.getPinballGameState().enterState(currentGameState);
    }

    @Override
    public void onGameOver(CurrentGameState currentGameState) {

    }

}
