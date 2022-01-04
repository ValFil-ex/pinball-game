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
import GameStates.CurrentGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String username;

        Scanner scanner = new Scanner(System.in);
        //singleton pattern used in Playfield class since only one instance of the playfield can exist at a time
        PlayField field = PlayField.initialisePlayfield();

        //singleton pattern used in CurrentGameState class since only one instance of the pinball game can exist at a time
        //1 turn on pinball game
        System.out.println("Please enter your name: \n");
        username = scanner.nextLine();
        CurrentGame currentGame = CurrentGame.startGame(username);


        //2 initialise playfield
        Ball ball = new Ball();
        Bumper bumper1 = new Bumper("Bumper 1", 200);
        Target target1 = new Target("Target 1", 400);
        Ramp bigRamp = new Ramp("BigRamp", false, 150);
        field.add(bumper1);
        field.add(target1);
        field.add(bigRamp);

        HitBumper hitBumperAction = new HitBumper();
        hitBumperAction.addAction(new ScorePoints(bumper1));

        HitTarget hitTarget = new HitTarget();
        hitTarget.addAction(new ScorePoints(target1));
        hitTarget.addAction(new OpenRamp(bigRamp));

        RunRamp runRamp = new RunRamp(bigRamp);

        //3insert coins to top up credits


        currentGame.insertCoin(0);



        //4 start the game pressed
        //currentGame.startGame();

        //5 game process



        ball.execute(hitBumperAction);
        ball.execute(hitBumperAction);
        ball.execute(runRamp);
        ball.execute(hitTarget);
        ball.execute(runRamp);


        System.out.println("your current score is " + field.getElementsScore());




        //HitBumper hitBumperAndScore = new HitBumper();




        //HitTarget hitTarget = new HitTarget();





        //OpenRamp openRamp = new OpenRamp(currentGame);





        //5 flipper hits the ball
        //@TODO some logic to simulate the random ball movement,  like Math.random()


        //6 some element hit by the ball - score in currentGame increased
        //hitBumperAndScore.addAction(new ScoreBumperPoints(currentGame));
        //bumper1.executeCommand(hitBumperAndScore);
        //bumper2.executeCommand(hitBumper);
        //hitTarget.addAction(new ScoreTargetPoints(currentGame));
        //target1.executeCommand(hitTarget); //hitTarget launches increases score + opens ramp-> composite + command pattern


        //5 flipper hits the ball
        //@TODO some logic to simulate the random ball movement, like Math.random()

        //7 ball lost - game over
        //Ist eine Kugel 3-mal verloren gegangen, so wechseln sie in den End-State,
        // bei welchem sie ein Spiel gewinnen können. Danach wechselt der Automat,
        // je nach Kredit, in den No-Credit- bzw. Ready-Zustand
        currentGame.gameOver();
        currentGame.gameOver();
        currentGame.gameOver();
        currentGame.gameOver();



    }
}
