package GameStates;

public class EndState implements GameStateInterface{
    @Override
    public void enterState(CurrentGame currentGame) {
        System.out.println("This is your last chance to win!");
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
