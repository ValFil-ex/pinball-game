package GameStates;

public interface GameStateInterface {

    void enterState(CurrentGame currentGame);

    void onInsertCoin(CurrentGame currentGame);
    void onStart(CurrentGame currentGame);
    void onGameOver(CurrentGame currentGame);



}
