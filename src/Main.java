/*Pinball simulation
* Singlton - to initialise CurrentGame
* Singlton - to initialise Playfield
* state pattern - to change states in CurrentGame (Gamestates package)
* Command pattern - to assign commands  when a ball hits some element; Aufrufer: target (e.g. Bumper) -> KonkreterBefehl: action object (e.g.
*   HitBumper) -> Empfänger: operation() (e.g. currentGame.score()
* Composite patters - to build more complex command (together with command patter). E.g. HitBumper launched OpenRamp and ScoreBumperPoints
*
* */

import Actions.*;
import Elements.Ball;
import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;
import GameStates.CurrentGame;

public class Main {
    public static void main(String[] args) {

        //singleton pattern used in CurrentGameState class since only one instance of the pinball game can exist at a time
        //1 turn on pinball game
        CurrentGame currentGame = CurrentGame.startGame("Valeriya");

        //singleton pattern used in Playfield class since only one instance of the playfield can exist at a time

        //2 initialise playfield @TODO : to wrap up in some initializer method? playfield.initialize()
        PlayField playfield = PlayField.initialisePlayfield();
        Bumper bumper1 = new Bumper("Bumper 1");
        Bumper bumper2 = new Bumper("Bumper 2");
        playfield.add(bumper1);
        playfield.add(bumper2);
        HitBumper hitBumper = new HitBumper();
        ScoreBumperPoints scoreBumper = new ScoreBumperPoints(currentGame);
        hitBumper.addAction(scoreBumper);

        Target target = new Target("Target 1");
        playfield.add(target);
        ScoreTargetPoints scoreTarget = new ScoreTargetPoints(currentGame);
        HitTarget hitTarget = new HitTarget();


        Ramp ramp = new Ramp("Ramp 1");
        playfield.add(ramp);
        OpenRamp openRamp = new OpenRamp(ramp);

        hitTarget.addAction(scoreTarget);
        hitTarget.addAction(openRamp);


        //3insert coins to top up credits
        currentGame.insertCoin(3);

        //4 start the game pressed
        currentGame.startGame();

        //5 flipper hits the ball
        //@TODO some logic to simulate the random ball movement,  like Math.random()


        //6 some element hit by the ball - score in currentGame increased
        bumper1.executeCommand(hitBumper);
        bumper2.executeCommand(hitBumper);
        target.executeCommand(hitTarget); //hitTarget launches increases score + opens ramp-> composite + command pattern


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

        System.out.println(currentGame.getScore());






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
