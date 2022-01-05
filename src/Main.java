/*Pinball simulation
 * Singlton - to initialise CurrentGame
 * Singlton - to initialise Playfield
 * state pattern - to change states in CurrentGame (Gamestates package)
 * Command pattern - to assign commands  when a ball hits some element; invoker: ball -> concrete command: action object (e.g.
 *   HitBumper) -> receiver: playfield element (e.g. bumper)
 * Composite patters - to build more complex command (together with command pattern). E.g. HitBumper launched OpenRamp and ScoreBumperPoints
 *
 * */

import Actions.*;
import Elements.*;
import GameStates.GameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String username;
        Scanner scanner = new Scanner(System.in);

        //1 initialise playfield
        PlayField field = PlayField.initialisePlayfield();


        //2 initialise playfield elements and ball; add to playfield
        Ball ball = new Ball();
        Bumper bumper1 = new Bumper("Bumper 1", 200);
        Target target1 = new Target("Target 1", 400);
        Ramp bigRamp = new Ramp("BigRamp", false, 150);
        field.add(bumper1);
        field.add(target1);
        field.add(bigRamp);

        //3 initialise possible element actions; add to playfield
        /* Actions:
         * - hit bumper: points
         * - hit target 1st time: 400 points and open ramp
         * - hit ramp: if closed - 0 points; if open (by hitting the target) - 150 points. Once open, remains open until game over (4 balls)
         * */

        HitBumper hitBumper1 = new HitBumper();
        hitBumper1.addAction(new ScorePoints(bumper1));

        HitTarget hitTarget1 = new HitTarget();
        hitTarget1.addAction(new ScorePoints(target1));//composite action
        hitTarget1.addAction(new OpenRamp(bigRamp));//composite action

        RunRamp runRamp = new RunRamp(bigRamp);

        field.setActions(hitBumper1);
        field.setActions(hitTarget1);
        field.setActions(runRamp);


        //4 initialise game controller currentGame;
        System.out.println("Please enter your name: \n");
        username = scanner.nextLine();
        GameController currentGame = GameController.launchGame(username, field, ball);//initialises curentGame and sets it to NoCreditstate

        /*5 insert coins -> in currentGame; noCreditState requests user input (inser coins)
         * - if provided changes currentGame to ReadyState
         * - else: exit.
         */


        /*6 start game -> in currentGame; ReadyState requests user input (press start)
         * - if provided - > currentGame changes state to PlayingState;
         * - else: exit.
         */


        /*7 flip -> in currentGame; PlayingState requests user input (flip)
         * - if provided: currentGame generates random action index, finds matching action in playfield.elementsActions and passes to the ball to
         *   execute
         *- else: exit.*/


        //8 game process ->in currentGame (changing states, execute actions, register score and times lost). Actions:


        /*9 ball lost three times : enter Super Game (EndState) -> currentGame
         * - if score>10.000 achieved - the game is won; score is reset, player gets one extra credit in return and can play level2 game (not
         *   implemented)
         * - if score<10.000 and ball is lost - game over (current score persists); player can add a credit (coin) to proceed and try to win the
         *   game and go to next level
         * */


    }
}
