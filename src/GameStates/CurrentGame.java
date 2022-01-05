package GameStates;

import Elements.Ball;
import Elements.PlayField;

import java.util.Scanner;

public class CurrentGame{
    //there is only one instance of the pinball game existing

    private static CurrentGame instance;
    private String username;
    Scanner scanner = new Scanner(System.in);

    private PlayField playfield;
    private Ball ball;

    private int credits = 0;
    private int timesLost = 0;

    private GameStateInterface pinballstate;

    private int flipperHitResult = -1;

    private CurrentGame(String username, PlayField playfield, Ball ball){
        this.username = username;
        this. playfield = playfield;
        this.ball = ball;
    }

    public static CurrentGame launchGame(String username, PlayField playfield, Ball ball){
        if(instance == null){
            instance = new CurrentGame(username, playfield, ball);
        }
        instance.turnOn();
        return instance;
    }

    // getters and setters
    protected void setPinballGameState(GameStateInterface pinballstate) {
        this.pinballstate = pinballstate;
    }

    protected GameStateInterface getPinballGameState() {
        return pinballstate;
    }

    protected int getCredits() {
        return credits;
    }

    protected int getTimesLost() {
        return timesLost;
    }

    //state changing operations delegated to state classes as per State pattern
    protected void turnOn(){
        System.out.println("Hello, " + this.username);
        this.pinballstate = new NoCreditState();
        this.pinballstate.enterState(this);
    }

    protected void insertCoin(int coins){
        this.credits+=coins;
        pinballstate.onInsertCoin(this);
    }

    protected void startGame(){
        this.credits--;
        timesLost=0;
        playfield.resetElements(); //e.g. to close the ramp but the score remains
        pinballstate.onStart(this);
    }

    protected void turnOff(){
        System.out.println("Good bye");
    }

    protected void hitFlipper() {
        flipperHitResult = (int) (Math.random() * (4));
        if(flipperHitResult == 0){
            timesLost +=1;
            pinballstate.onGameOver(this);
        }else{
            ball.execute(playfield.getAction(flipperHitResult-1));
            pinballstate.enterState(this);
        }
    }

    protected int getTotalScore() {
        return playfield.getElementsScore();
    }

    protected void onWinGame(){
        this.credits+=1;
        timesLost=0;
        playfield.resetElementsAndScore();
        //times lost set to 0
    }
}
