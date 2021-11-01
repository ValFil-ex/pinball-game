package GameStates;

public class NoCreditState implements GameStateInterface {


    @Override
    public void enterState(CurrentGame currentGame) {
        System.out.println("Your current credit is 0. Please insert a coin");
    }

    @Override
    public void onInsertCoin(CurrentGame currentGame) {
        currentGame.setPinballGameState(new ReadyState());
        currentGame.getPinballGameState().enterState(currentGame);
    }

    @Override
    public void onStart(CurrentGame currentGame) {
        System.out.println("No credit. Please insert a coin");
    }

    @Override
    public void onGameOver(CurrentGame currentGame) {

    }


}
