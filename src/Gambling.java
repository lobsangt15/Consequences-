import java.util.Scanner;

public class Gambling {
    private Gambler user;
    private double bet;
    private double winnings;
    private double losses;
    private int outcome;
    private int numGamble = 0;
    Scanner scan = new Scanner(System.in);

    public Gambling(Gambler user) {
        this.user = user;
    }

    private void rigged() {
        if (winnings > 500000) { //user always wins first few bets inorder to make them crave to gamble and win more
            outcome = (int)(Math.random() * 10 + 1);
        } else {
            outcome = (int)(Math.random() * 1 + 1);
        }
    }

    public void gamble() {
        System.out.print("Enter your bet: ");
        bet = scan.nextDouble();

        if (bet > user.getBalance()) {
            System.out.println("You don't have enough money to bet!");
            return;
        }

        rigged();

        if (outcome == 1) {
            winnings += bet;
            user.setBalance(user.getBalance() + bet);
            user.changeHappiness(10);
            System.out.println("You won! Your new balance is: $" + user.getBalance());
        } else {
            losses += bet;
            user.setBalance(user.getBalance() - bet);
            user.changeHappiness(-10);
            System.out.println("You lost! Your new balance is: $" + user.getBalance());
        }
        numGamble++;

        // Print updated stats
        System.out.println("Total winnings: $" + winnings);
        System.out.println("Total losses: $" + losses);
        System.out.println("Happiness: " + user.getHappiness());
        System.out.println();
    }

    public double getWinnings() {
        return winnings;
    }

    public double getLosses() {
        return losses;
    }

    public int getNumGamble() {
        return numGamble;
    }
}
