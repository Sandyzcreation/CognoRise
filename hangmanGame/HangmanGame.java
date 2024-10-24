package hangmanGame;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {
        "java", "hangman", "python", "Selenium", "sanjay", "ajay", "sandhiya"
    };
    private static final String HANGMAN[] = {
        "  ----  \n  |    |  \n       |  \n       |  \n       |  \n       |  \n=========",
        "  ----  \n  |    |  \n  O    |  \n       |  \n       |  \n       |  \n=========",
        "  ----  \n  |    |  \n  O    |  \n  |    |  \n       |  \n       |  \n=========",
        "  ----  \n  |    |  \n  O    |  \n /|    |  \n       |  \n       |  \n=========",
        "  ----  \n  |    |  \n  O    |  \n /|\\   |  \n       |  \n       |  \n=========",
        "  ----  \n  |    |  \n  O    |  \n /|\\   |  \n /      |  \n       |  \n=========",
        "  ----  \n  |    |  \n  O    |  \n /|\\   |  \n / \\   |  \n       |  \n========="
    };

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Select a random word
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        StringBuilder currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        
        int incorrectGuesses = 0;
        int maxIncorrectGuesses = HANGMAN.length - 1; // Maximum number of incorrect guesses allowed
        boolean[] guessedLetters = new boolean[26]; // Track guessed letters

        System.out.println("Welcome to Hangman!");
        
        while (incorrectGuesses < maxIncorrectGuesses) {
            System.out.println(HANGMAN[incorrectGuesses]);
            System.out.println("Word: " + currentGuess);
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);
            
            // Check if the letter has already been guessed
            if (guessedLetters[guess - 'a']) {
                System.out.println("You already guessed that letter! Try again.");
                continue;
            }
            
            guessedLetters[guess - 'a'] = true; // Mark this letter as guessed
            
            // Check if the guessed letter is in the word
            boolean foundLetter = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    currentGuess.setCharAt(i, guess); // Update the current guess display
                    foundLetter = true;
                }
            }

            if (!foundLetter) {
                incorrectGuesses++; // Increment incorrect guesses if the letter was not found
                System.out.println("Incorrect guess!");
            }

            // Check if the word has been fully guessed
            if (currentGuess.toString().equals(wordToGuess)) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                break;
            }
        }

        if (incorrectGuesses == maxIncorrectGuesses) {
            System.out.println(HANGMAN[incorrectGuesses]);
            System.out.println("Game Over! The correct word was: " + wordToGuess);
        }

        scanner.close();
    }
}