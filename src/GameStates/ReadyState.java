package GameStates;

public class ReadyState implements GameStateInterface {


    @Override
    public void enterState(CurrentGame currentGame) {
        int credits = currentGame.getCredits();
        System.out.printf("Your current credit is %d. Press start to begin the play \n", credits);
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
