package GameStates;

public interface GameStateInterface {

    void enterState(GameController currentGame);

    void onInsertCoin(GameController currentGame);
    void onStart(GameController currentGame);
    void onGameOver(GameController currentGame);



}
