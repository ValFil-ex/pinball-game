package GameStates;

public interface GameStateInterface {

    void enterState(CurrentGameState currentGameState);

    void onInsertCoin(CurrentGameState currentGameState);
    void onStart(CurrentGameState currentGameState);
    void onGameOver(CurrentGameState currentGameState);


}
