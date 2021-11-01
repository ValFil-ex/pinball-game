package GameStates;

public class PlayingState implements GameStateInterface {
    @Override
    public void enterState(CurrentGame currentGame) {
        System.out.println("The play begins!");
    }

    @Override
    public void onInsertCoin(CurrentGame currentGame) {
        int credits = currentGame.getCredits();
        System.out.printf("Your current credit is now %d. Watch the ball! The play is on! \n", credits);
    }

    @Override
    public void onStart(CurrentGame currentGame) {
        System.out.println("The play is already on! watch the ball!");
    }

    @Override
    public void onGameOver(CurrentGame currentGame) {
        System.out.println("Oh no, you have lost this ball!");
        int credits = currentGame.getCredits();
        int timesLost = currentGame.getTimesLost();

        //Ist eine Kugel 3-mal verloren gegangen, so wechseln sie in den End-State,
        // bei welchem sie ein Spiel gewinnen können. Danach wechselt der Automat,
        // je nach Kredit, in den No-Credit- bzw. Ready-Zustand
        if(timesLost>=3){
            currentGame.setPinballGameState(new EndState());
            currentGame.getPinballGameState().enterState(currentGame);
        }else{
            if(credits!=0){
                currentGame.setPinballGameState(new PlayingState());
                currentGame.getPinballGameState().enterState(currentGame);
            }else {
                currentGame.setPinballGameState(new NoCreditState());
                currentGame.getPinballGameState().enterState(currentGame);
            }
        }


    }

}
