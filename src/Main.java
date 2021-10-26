//Pinball simulation
//

import Actions.GameController;
import Actions.HitBumper;
import Elements.Bumper;
import GameStates.CurrentGameState;

public class Main {
    public static void main(String[] args) {


        //singleton pattern used in Pinball class since only one instance of the pinball game can exist at a time
        //1 turn on pinball game
        CurrentGameState currentGame = CurrentGameState.startGame("Valeriya");

        //2 initialise playfield @TODO later to gamestateclass?
        PlayField playfield = PlayField.initialisePlayfield();
        Bumper bumper = new Bumper(currentGame);
        playfield.add(bumper);
        GameController controller = new GameController();

        //3insert coins to top up credits
        currentGame.insertCoin(3);

        //4 start the game pressed
        currentGame.startGame();

        //5 flipper hits the ball
        //@TODO some logic to simulate the random ball movement

        //6 some element hit by the ball - score in currentGame increased
        controller.executeCommand(new HitBumper(bumper));

        //5 flipper hits the ball
        //@TODO some logic to simulate the random ball movement

        //7 ball lost - game over
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
