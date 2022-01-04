package GameStates;

import java.util.Scanner;

public class CurrentGame{
    //there is only one instance of the pinball game existing
    private static CurrentGame instance;
    private String username;
    Scanner scanner = new Scanner(System.in);

    private int credits = 0;
    private int timesLost = 0;

    private GameStateInterface pinballstate;

    private CurrentGame(String username){
        this.username = username;
    }

    public static CurrentGame startGame(String username){
        if(instance == null){
            instance = new CurrentGame(username);
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
    public void turnOn(){
        System.out.println("Hello, " + this.username);
        this.pinballstate = new NoCreditState();
        this.pinballstate.enterState(this);
    }

    public void insertCoin(int a){

        int coins = scanner.nextInt();
        if(coins>0){
            this.credits+=coins;
            pinballstate.onInsertCoin(this);
        }else{
            pinballstate.enterState(this);
        }
    }

    public void startGame(){
        this.credits--;
        pinballstate.onStart(this);
    }

    public void gameOver(){
        timesLost +=1;
        pinballstate.onGameOver(this);
    }
}
