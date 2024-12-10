import java.util.Scanner;

public class Sell {
    private boolean irsRaid;
    private double loans;
    private final Gambler user;
    private final Purchase assets;
    private final Scanner scan;

    public Sell(Gambler user, Purchase assets) {
        this.user = user;
        this.assets = assets;
        this.scan = new Scanner(System.in);
        this.irsRaid = false;
    }

    public void payLoans(double amount) {
        loans = user.getLoans();
        if (user.getBalance() >= amount) {
            user.setLoans(loans - amount);
            user.setBalance(user.getBalance() - amount);
            System.out.println("You paid $" + amount + " towards your loan. Remaining loan: $" + user.getLoans());
        } else {
            System.out.println("You don't have enough money to pay this amount! Sell assets if needed.");
        }
    }

    public void payLoans() {
        loans = user.getLoans();
        if (user.getBalance() >= loans) {
            user.setBalance(user.getBalance() - loans);
            user.setLoans(0);
            System.out.println("You paid off your entire loan! Balance: $" + user.getBalance());
        } else {
            System.out.println("You don't have enough money to pay off your loan. Sell assets to cover the loan.");
        }
    }

    public void sellAssets() {
        System.out.println("What would you like to sell?");
        System.out.println("(1) Car ($32,000 each)");
        System.out.println("(2) House ($480,000 each)");
        System.out.println("(3) Mansion ($1,600,000 each)");
        System.out.println("(4) Private Jet ($1,200,000 each)");

        int choice = scan.nextInt();
        System.out.println("How many would you like to sell?");
        int amount = scan.nextInt();

        switch (choice) {
            case 1:
                sellCar(amount);
            case 2:
                sellHouse(amount);
            case 3:
                sellMansion(amount);
            case 4:
                sellJet(amount);
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    private void sellCar(int amount) {
        if (assets.getNumCars() >= amount) {
            double saleValue = amount * 32000;
            user.setBalance(user.getBalance() + saleValue);
            System.out.println("Sold " + amount + " car(s). Gained: $" + saleValue);
        } else {
            System.out.println("You don't have enough cars to sell!");
        }
    }

    private void sellHouse(int amount) {
        if (assets.getNumHouses() >= amount) {
            double saleValue = amount * 480000;
            user.setBalance(user.getBalance() + saleValue);
            System.out.println("Sold " + amount + " house(s). Gained: $" + saleValue);
        } else {
            System.out.println("You don't have enough houses to sell!");
        }
    }

    private void sellMansion(int amount) {
        if (assets.getNumMansions() >= amount) {
            double saleValue = amount * 1600000;
            user.setBalance(user.getBalance() + saleValue);
            System.out.println("Sold " + amount + " mansion(s). Gained: $" + saleValue);
        } else {
            System.out.println("You don't have enough mansions to sell!");
        }
    }

    private void sellJet(int amount) {
        if (assets.getNumJets() >= amount) {
            double saleValue = amount * 1200000;
            user.setBalance(user.getBalance() + saleValue);
            System.out.println("Sold " + amount + " jet(s). Gained: $" + saleValue);
        } else {
            System.out.println("You don't have enough jets to sell!");
        }
    }

    private void checkForIrsRaid() {
        if (user.getBalance() > 1000000) {
            int chance = (int) (Math.random() * 20);
            if (chance == 0) { // 50% chance of IRS raid
                irsRaid = true;
                System.out.println("You were raided by the IRS for having over $1,000,000 in your balance! You lose everything!");
            }
        }
    }

    public void fileBankruptcy() {
        if (user.getNumLoans() > 0) {
            if (user.getBalance() + assets.getAssetValue() < user.getLoans()) {
                int i = (int) (Math.random() * 4 + 1);
                if (i == 2) {
                    System.out.println("You have successfully filed bankruptcy! No need to worry about paying back your loans");
                } else {
                    System.out.println("Your claim for bankruptcy has failed! \nYou have been sentenced to 10 years in prison for failure to pay back loans!");
                }
            }
        }
    }

    public boolean gameOver() {
        if (irsRaid == true) {
            return true;
        }
        return false;
    }
}
