package GameStates;

import Elements.ScorableElement;

public class CurrentGame{
    //there is only one instance of the pinball game existing
    private static CurrentGame instance;
    private String username;

    private int credits = 0;
    private GameStateInterface pinballstate;

    private int score = 0;
    private int timesLost = 0;


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

    public GameStateInterface getPinballGameState() {
        return pinballstate;
    }

    public int getCredits() {
        return credits;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public int getTimesLost() {
        return timesLost;
    }

    //state changing operations delegated to state classes as per State pattern
    public void turnOn(){
        System.out.println("Hello, " + this.username);
        this.pinballstate = new NoCreditState();
        this.pinballstate.enterState(this);
    }

    public void insertCoin(int a){
        this.credits+=a;
        pinballstate.onInsertCoin(this);
    }

    public void startGame(){
        this.credits--;
        pinballstate.onStart(this);
    }

    public void gameOver(){
        timesLost +=1;
            pinballstate.onGameOver(this);
    }


    public void changeScore(int points) {
        this.score += points;
    }

}