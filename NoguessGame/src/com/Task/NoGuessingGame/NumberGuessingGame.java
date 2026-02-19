package com.Task.NoGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("===== Welcome to Number Guessing Game =====");

        while (playAgain) {

            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("You have " + maxAttempts + " attempts to guess the number (1-100)");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } 
                else if (userGuess > numberToGuess) {
                    System.out.println("Too High! Try again.");
                } 
                else {
                    System.out.println("Too Low! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You lost! The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n===== Game Over =====");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Your Score: " + (roundsWon * 10));

        sc.close();
    }
}

