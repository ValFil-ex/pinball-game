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

        int hitResult = 0;

        Scanner scanner = new Scanner(System.in);
        //1initialise playfield
        PlayField field = PlayField.initialisePlayfield();

        //2 add playfield elements and ball
        Ball ball = new Ball();
        Bumper bumper1 = new Bumper("Bumper 1", 200);
        Target target1 = new Target("Target 1", 400);
        Ramp bigRamp = new Ramp("BigRamp", false, 150);
        field.add(bumper1);
        field.add(target1);
        field.add(bigRamp);

        //3 initialise possible actions
        HitBumper hitBumperAction = new HitBumper();
        hitBumperAction.addAction(new ScorePoints(bumper1));

        HitTarget hitTarget = new HitTarget();
        hitTarget.addAction(new ScorePoints(target1));
        hitTarget.addAction(new OpenRamp(bigRamp));

        RunRamp runRamp = new RunRamp(bigRamp);


        //start the game
        System.out.println("Please enter your name: \n");
        username = scanner.nextLine();
        CurrentGame currentGame = CurrentGame.launchGame(username);


        //3 insert coins


        //4 start game


        //5 calculate flip result



        switch(hitResult){
            case 1: ball.execute(hitBumperAction);
            case 2: ball.execute(runRamp);
            case 3: ball.execute(hitTarget);
            default: break;
        }












        //3insert coins to top up credits


        //currentGame.insertCoin(0);



        //4 start the game pressed
        //currentGame.startGame();

        //5 game process




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
