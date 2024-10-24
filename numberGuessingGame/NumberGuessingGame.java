package numberGuessingGame;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        final int MAX_ATTEMPTS = 10; // Set a limit for the number of attempts
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the Number between 1 and 100.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

        // Loop until the user guesses correctly or runs out of attempts
        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again!");
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high. Try again!");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number correctly in " + attempts + " attempts.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
