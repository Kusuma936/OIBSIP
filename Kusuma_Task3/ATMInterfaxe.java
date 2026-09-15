import java.util.Scanner;

public class ATMInterface {

    static double balance = 10000.00;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        System.out.println("===== ATM INTERFACE =====");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }

    static void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    static void deposit() {
        System.out.print("Enter deposit amount: ₹");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
            System.out.println("New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    static void withdraw() {
        System.out.print("Enter withdrawal amount: ₹");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Please collect your cash.");
            System.out.println("Remaining Balance: ₹" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
}
