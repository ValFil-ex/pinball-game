/*Pinball simulation
* Singlton - to initialise CurrentGameState
* Singlton - to initialise Playfield
* state pattern - to change states in CurrentGameState
* Command pattern - to assign commands (by game controller) when a ball hits some element; element takes gamestate as argument to make changes
* */


import Elements.Ball;
import Actions.HitBumper;
import Elements.Bumper;
import GameStates.CurrentGame;

public class Main {
    public static void main(String[] args) {


        //singleton pattern used in CurrentGameState class since only one instance of the pinball game can exist at a time
        //1 turn on pinball game
        CurrentGame currentGame = CurrentGame.startGame("Valeriya");

        //singleton pattern used in Playfield class since only one instance of the playfield can exist at a time
        //2 initialise playfield @TODO later to gamestateclass?
        PlayField playfield = PlayField.initialisePlayfield();
        Bumper bumper = new Bumper(currentGame);
        playfield.add(bumper);
        Ball ball = new Ball();

        //3insert coins to top up credits
        currentGame.insertCoin(3);

        //4 start the game pressed
        currentGame.startGame();

        //5 flipper hits the ball
        //@TODO some logic to simulate the random ball movement

        //6 some element hit by the ball - score in currentGame increased
        ball.executeCommand(new HitBumper(bumper));


        //5 flipper hits the ball
        //@TODO some logic to simulate the random ball movement

        //7 ball lost - game over
        //Ist eine Kugel 3-mal verloren gegangen, so wechseln sie in den End-State,
        // bei welchem sie ein Spiel gewinnen können. Danach wechselt der Automat,
        // je nach Kredit, in den No-Credit- bzw. Ready-Zustand
        currentGame.gameOver();
        currentGame.gameOver();
        currentGame.gameOver();
        currentGame.gameOver();






       /*
        Elements.Target target = new Elements.Target();
        int score = controller.executeCommand(new Actions.HitTarget(target));
        pinballGame.setScore(score);*/

        /*
        Elements.Target target = new Elements.Target();
        target.executeCommand(new Actions.HitTarget(currentGame));
        */

    }
}
