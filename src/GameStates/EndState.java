package GameStates;
import java.util.Scanner;
public class EndState implements GameStateInterface{
    @Override
    public void enterState(CurrentGame currentGame) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = currentGame.getTotalScore();

        if(totalScore>10000){
            this.onGameOver(currentGame);
        }else{
            System.out.println("This is your last chance to win! Press 1 to hit the ball");
            System.out.printf("Your current score is %d points! You need 10000 points to win the game!\n", totalScore);
            //new!!
            int command = scanner.nextInt();
            if(command == 1){
                currentGame.hitFlipper();
            }
        }
    }

    @Override
    public void onInsertCoin(CurrentGame currentGame) {

    }

    @Override
    public void onStart(CurrentGame currentGame) {
        System.out.println("The game is already on! Watch the ball!");
    }

    @Override
    public void onGameOver(CurrentGame currentGame) {
        System.out.println(" Oh no, you've lost the ball!\n");
        int credits = currentGame.getCredits();
        int totalScore = currentGame.getTotalScore();
        if(credits!=0 && totalScore<10000){
            System.out.println(" This game is over:(");
            currentGame.setPinballGameState(new ReadyState());
            currentGame.getPinballGameState().enterState(currentGame);
        }else if (credits!=0 && totalScore>10000){
            System.out.println("You have won the game! Welcome to the next level!");
            currentGame.onWinGame();
            currentGame.setPinballGameState(new ReadyState());
            currentGame.getPinballGameState().enterState(currentGame);
        }else if(credits==0 && totalScore>10000){
            System.out.println("You have won the game! Welcome to the next level!");
            currentGame.onWinGame();
            currentGame.setPinballGameState(new ReadyState());
            currentGame.getPinballGameState().enterState(currentGame);
        }else{
            System.out.println("This game is over:(");
            currentGame.setPinballGameState(new NoCreditState());
            currentGame.getPinballGameState().enterState(currentGame);
        }
    }
}
