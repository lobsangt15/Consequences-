import java.util.Scanner;

public class Purchase {
    private int numCars;
    private int numHouses;
    private int numMansions;
    private int numJets;
    private double assetValue;
    private final Scanner scan;
    private final Gambler user;

    public Purchase(Gambler user) {
        this.user = user;
        this.scan = new Scanner(System.in);
    }

    public void purchaseMenu() {
        System.out.println("What would you like to purchase?");
        System.out.println("(1) Car ($40,000)");
        System.out.println("(2) House ($600,000)");
        System.out.println("(3) Mansion ($2,000,000)");
        System.out.println("(4) Private Jet ($1,500,000)");
        System.out.println("Enter your choice: ");
        int choice = scan.nextInt();

        System.out.println("How many would you like to buy?");
        int amount = scan.nextInt();

        switch (choice) {
            case 1:
                purchaseCar(amount);
                break;
            case 2:
                purchaseHouse(amount);
                break;
            case 3:
                purchaseMansion(amount);
                break;
            case 4:
                purchaseJet(amount);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void purchaseCar(int amount) {
        double cost = amount * 40000;
        if (user.getBalance() >= cost) {
            numCars += amount;
            assetValue += cost * 0.8; // Assets retain 80% of their value
            user.setBalance(user.getBalance() - cost);
            user.adjustHappinessForPurchase();
            System.out.println("You purchased " + amount + " car(s). Total cars: " + numCars);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseHouse(int amount) {
        double cost = amount * 600000;
        if (user.getBalance() >= cost) {
            numHouses += amount;
            assetValue += cost * 0.8;
            user.setBalance(user.getBalance() - cost);
            user.adjustHappinessForPurchase();
            System.out.println("You purchased " + amount + " house(s). Total houses: " + numHouses);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseMansion(int amount) {
        double cost = amount * 2000000;
        if (user.getBalance() >= cost) {
            numMansions += amount;
            assetValue += cost * 0.8;
            user.setBalance(user.getBalance() - cost);
            user.adjustHappinessForPurchase();
            System.out.println("You purchased " + amount + " mansion(s). Total mansions: " + numMansions);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseJet(int amount) {
        double cost = amount * 1500000;
        if (user.getBalance() >= cost) {
            numJets += amount;
            assetValue += cost * 0.8;
            user.setBalance(user.getBalance() - cost);
            user.adjustHappinessForPurchase();
            System.out.println("You purchased " + amount + " private jet(s). Total jets: " + numJets);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    public int getNumCars() {
        return numCars;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public int getNumMansions() {
        return numMansions;
    }

    public int getNumJets() {
        return numJets;
    }

    public double getAssetValue() {
        return assetValue;
    }
}
