import java.util.Scanner;

public class CasinoGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Gambler gambler = new Gambler();
        Gambling gambling = new Gambling(gambler);
        Purchase purchase = new Purchase(gambler);
        Sell sell = new Sell(gambler, purchase);

        System.out.println("Welcome to Consequences of Gambling!");
        while (!sell.gameOver()) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Gamble");
            System.out.println("2. Purchase");
            System.out.println("3. Sell Assets");
            System.out.println("4. Take Loan");
            System.out.println("5. Pay Loan");
            System.out.println("6. Check Stats");
            System.out.println("7. File for bankruptcy");
            System.out.println("8. Quit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();


            switch (choice) {
                case 1 -> {
                    boolean continueGambling = true;
                    while (continueGambling) { // Nested iteration for gambling
                        gambling.gamble();
                        System.out.print("Do you want to gamble again? (y/n): ");
                        String Choice = scan.nextLine();
                        if (Choice.equals("n")) {
                            continueGambling = false;
                        }
                    }
                }
                case 2 -> {
                    boolean continuePurchasing = true;
                    while (continuePurchasing) { // Nested iteration for purchases
                        purchase.purchaseMenu();
                        System.out.print("Do you want to make another purchase? (y/n): ");
                        String Choice = scan.nextLine();
                        if (Choice.equals("n")) {
                            continuePurchasing = false;
                        }
                    }
                }
                case 3 -> {
                    boolean continueSelling = true;
                    while (continueSelling) { // Nested iteration for purchases
                        sell.sellAssets();
                        System.out.print("Do you want to sell another thing? (y/n): ");
                        String Choice = scan.nextLine();
                        if (Choice.equals("n")) {
                            continueSelling = false;
                        }
                    }
                }
                case 4 -> gambler.takeLoan();
                case 5 -> {
                    System.out.print("Would you like to pay the loan in full(1) or parts of it(2)? (1/2) ");
                    int Choice = scan.nextInt();
                    if (Choice == 1) {
                        gambler.payLoan();
                    }
                    if (Choice == 2) {
                        System.out.print("How much do you want to pay back? ");
                        int amount = scan.nextInt();
                        gambler.payLoan(amount);
                    }
                }
                case 6 -> gambler.checkStats();
                case 7 -> {
                    System.out.println("Are you unable to pay your loans?");
                    System.out.println("Would you like to quit by filing for bankruptcy (y/n) ");
                    String answer = scan.nextLine();
                    if (answer.equals("y")) {
                        if (gambler.getNumLoans() == 0) {
                            System.out.println("You have no loans!");
                        } else if (gambler.getBalance() + purchase.getAssetValue() > gambler.getLoans()) {
                            System.out.println("You have enough assets and money to pay back your loans!");
                        } else {
                            sell.fileBankruptcy();
                            return;
                        }
                    }
                }
                case 8 -> {
                    if (gambler.getLoans() > 0) {
                        System.out.println("You cannot quit with outstanding loans. Pay off your loans first!");
                    } else {
                        System.out.println("Thanks for playing!");
                        return; // Exit the program
                    }
                }
                default ->
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

            System.out.println();
        }
        System.out.println("Game over! Better luck next time.");
    }
}

