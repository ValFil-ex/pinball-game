package GameStates;

public class PlayingState implements GameStateInterface {
    @Override
    public void enterState(CurrentGameState currentGameState) {
        System.out.println("The play begins!");
    }

    @Override
    public void onInsertCoin(CurrentGameState currentGameState) {
        int credits = currentGameState.getCredits();
        System.out.printf("Your credit is now %d. Watch the ball! The play is on! \n", credits);
    }

    @Override
    public void onStart(CurrentGameState currentGameState) {
        System.out.println("The play is already on! watch the ball!");
    }

    @Override
    public void onGameOver(CurrentGameState currentGameState) {
        int credits = currentGameState.getCredits();
        if(credits!=0){
            currentGameState.setPinballGameState(new ReadyState());
            currentGameState.getPinballGameState().enterState(currentGameState);
        }else{
            currentGameState.setPinballGameState(new NoCreditState());
            currentGameState.getPinballGameState().enterState(currentGameState);
        }
    }

}
