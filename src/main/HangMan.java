package main;

import dictionary.Dictionary;
import model.Letter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

    private static int attempts = 10;
    private static boolean wordIsGuessed;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        String[] words = selectRandomList(dictionary.getListOfWords());
        String word = selectRandomWord(words);
        char[] chars = generateWord(word);
        Letter[] letters = new Letter[chars.length];
        for (int i = 0; i < chars.length; i++) {
            letters[i] = new Letter(chars[i], false);
        }
        intro(chars);
        printLetters(letters);
        System.out.println();
        System.out.println("----------------------------------");

        do {
            System.out.println();
            System.out.println("You got " + attempts + " attempts left...");
            char answer = askUserInput();
            attempts = evaluateLetter(letters, answer, attempts);
            printLetters(letters);
            int guessedLetters = 0;
            for (Letter letter : letters) {
               if(letter.isGuessed()) {
                   guessedLetters++;
               }
            }
            if(guessedLetters >= letters.length) {
                wordIsGuessed = true;
            }
            System.out.println();
            System.out.println("---------------------------------");
        } while (!wordIsGuessed && attempts > 0);

        System.out.println();
        if (wordIsGuessed) {
            System.out.println("Congratulations you find the word in " + (11 - attempts) + " attempts!");
        }
        if (attempts <= 0) {
            System.out.println("Sorry, you used all your attempts, the word to find was: ");
            System.out.println();
            for (char c : chars) {
                System.out.print( " " + c );
            }
            System.out.println();
        }


    }

    private static int evaluateLetter(Letter[] letters, char input, int tries) {
        int guessedLetters = 0;
        for (Letter letter : letters) {
            if(input == letter.getLetter()) {
                letter.setGuessed(true);
                guessedLetters++;
            }
        }
        if(guessedLetters == 0) {
            tries--;
        }
        return tries;
    }

    private static char askUserInput() {
        System.out.println();
        System.out.println("Please type a letter: ");
        return input.next().charAt(0);
    }

    private static void printLetters(Letter[] letters) {
        for (Letter letter : letters) {
            System.out.print(letter);
        }
        System.out.println();
    }

    private static char[] generateWord(String word) {
        return word.toCharArray();
    }

    private static String selectRandomWord(String[] words) {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private static String[] selectRandomList(ArrayList<String[]> dictionary) {
        Random random = new Random();
        return dictionary.get(random.nextInt(dictionary.size()));
    }

    private static void intro(char[] chars) {
        System.out.println();
        System.out.println("Welcome to HANGMAN!");
        System.out.println();
        System.out.println("You know the rules.");
        System.out.println("You got 10 attempts to find the word.");
        System.out.println("Try to guess this word of " + chars.length + " letters: ");
        System.out.println();
    }

}
