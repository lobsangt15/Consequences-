import java.util.Scanner;

public class Gambler {
    private double balance;
    private double loans;
    private int happiness;
    private boolean hasLoan;
    private int numLoans;

    Scanner scan = new Scanner(System.in);

    public Gambler(double amount) {
        this.balance = amount;
        this.loans = 0;
        this.happiness = 100;
    }

    public Gambler() {
        this.balance = 1000;
        this.loans = 0;
        this.happiness = 100;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoans() {
        return loans;
    }

    public void setLoans(double loans) {
        this.loans = loans;
    }

    public int getHappiness() {
        return happiness;
    }

    public void changeHappiness(int amount) {
        this.happiness += amount;
    }

    public void adjustHappinessForPurchase(){
        happiness+= 15;
    }

    public void takeLoan() {
        if (numLoans < 3) {
            System.out.println("Enter loan amount:");
            double amount = scan.nextDouble();
            if (amount > 0) {
                setBalance(balance + amount);
                loans += amount * 1.1; //10% interest rate for loans
                numLoans++;
                hasLoan = true;
                happiness -= 15;
                System.out.println("Loan approved! Current balance: $" + balance);
            } else {
                System.out.println("Invalid amount.");
            }
        } else {
            System.out.println("Maximum loans reached!");
        }
    }

    public void payLoan() {
        if (hasLoan) {
            if (balance >= loans) {
                balance -= loans;
                loans = 0;
                hasLoan = false;
                happiness += 10;
                System.out.println("Loan paid off!");
            } else {
                System.out.println("Insufficient balance to pay loans.");
            }
        } else {
            System.out.println("You Have No Loans!");
        }
    }

    public void payLoan(int amount) {
        if (hasLoan) {
            if (balance >= amount) {
                balance -= amount;
                loans -= amount;
                happiness += 5;
                System.out.println("You still owe $" + loans);
            } else {
                System.out.println("You don't have that much money!");
            }
        }
    }

    public void checkStats() {
        System.out.println("Balance: $" + balance);
        System.out.println("Loans: $" + loans);
        System.out.println("Happiness: " + happiness);
    }

    public int getNumLoans() {
        return numLoans;
    }

}

