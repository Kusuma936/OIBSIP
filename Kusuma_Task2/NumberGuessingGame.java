import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner scanner = new Scanner(System.in);
    static int bestScore = 0;

    public static void main(String[] args) {

        boolean playAgain = true;

        System.out.println("======================================");
        System.out.println("       NUMBER GUESSING CHALLENGE");
        System.out.println("======================================");

        while (playAgain) {

            int maxNumber;
            int maxAttempts;
            String level;

            while (true) {
                System.out.println("\nSelect Difficulty:");
                System.out.println("1. Easy   (1-50, 10 attempts)");
                System.out.println("2. Medium (1-100, 7 attempts)");
                System.out.println("3. Hard   (1-200, 5 attempts)");

                System.out.print("Enter your choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter 1, 2 or 3.");
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();

                if (choice == 1) {
                    level = "Easy";
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;
                } 
                else if (choice == 2) {
                    level = "Medium";
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;
                } 
                else if (choice == 3) {
                    level = "Hard";
                    maxNumber = 200;
                    maxAttempts = 5;
                    break;
                } 
                else {
                    System.out.println("Invalid choice.");
                }
            }

            Random random = new Random();
            int secretNumber = random.nextInt(maxNumber) + 1;

            int attempts = 0;
            boolean won = false;

            System.out.println("\nYou selected: " + level);
            System.out.println("Guess a number between 1 and " + maxNumber);
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > maxNumber) {
                    System.out.println(
                        "Enter a number between 1 and " + maxNumber
                    );
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {

                    won = true;

                    int score = (maxAttempts - attempts + 1) * 10;

                    System.out.println("\nCongratulations!");
                    System.out.println("You found the number in "
                            + attempts + " attempts.");
                    System.out.println("Score: " + score);

                    if (score > bestScore) {
                        bestScore = score;
                        System.out.println("New Best Score!");
                    } 
                    else {
                        System.out.println("Best Score: " + bestScore);
                    }

                    break;

                } 
                else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } 
                else {
                    System.out.println("Too High!");
                }

                if (attempts % 2 == 0) {

                    if (secretNumber % 2 == 0) {
                        System.out.println("Hint: The number is EVEN.");
                    } 
                    else {
                        System.out.println("Hint: The number is ODD.");
                    }
                }

                System.out.println(
                    "Attempts remaining: " + (maxAttempts - attempts)
                );
            }

            if (!won) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.print("\nPlay again? (yes/no): ");
            String answer = scanner.next();

            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("\n======================================");
        System.out.println("        Thanks for playing!");
        System.out.println("Your Best Score: " + bestScore);
        System.out.println("======================================");

        scanner.close();
    }
}
