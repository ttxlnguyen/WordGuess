package com.github.zipcodewilmington;

//Timothy Nguyen

import java.util.Scanner;
import java.util.Random;

public class GameLogic {

        private String[] words = {
                "cat", "dog", "bog", "cut"
        };

        private Scanner scanner = new Scanner(System.in);
        private String currentWord;
        private String realWord;
        private Attempts attempts;

        public void startGame(){
            while(true) {
                callWord();

                do {
                    char letter = input();
                    scanner.nextLine();
                    matchLetter(letter);
                }
                while (!wordGuessed() || !attempts.noMoreAttempts());

                if(wordGuessed()) {
                    winner();
                }
                if(attempts.noMoreAttempts()){
                    gameover();
                    break;
                }
            }
        }

        private void matchLetter(char letter) {
            int wordLength = currentWord.length();
            StringBuilder builder = new StringBuilder(realWord);
            boolean realLetter = false;

            for (int i = 0; i <wordLength; i++) {
                if(currentWord.charAt(i) == letter) {
                    builder.replace(i, i + 1, Character.toString(letter));
                    realWord = builder.toString();
                    realLetter = true;
                }
            }
            if(!realLetter) {
                minusAttempts();
            }
        }

        private void callWord() {
            callCurrentWord();
            callRealWord();
        }

        private void callCurrentWord() {
            Random rand = new Random();
            int wordList = words.length;
            currentWord = words[rand.nextInt(wordList)];
        }

        private void callRealWord() {
            int wordLength = currentWord.length();
            realWord = "";
            for (int i = 0; i < wordLength; i++) {
                realWord += "_";
            }
        }

        private boolean wordGuessed(){
            return realWord.equals(currentWord);
        }

        private void winner() {
            System.out.println("Winner! You guessed the word.");
        }

        private void gameover() {
            System.out.println("You lost, the word is: " + realWord);
        }

        private void minusAttempts() {
            attempts.deductAttempts();
        }

        private char input() {
            System.out.println(realWord);
//            System.out.println("You have " + attempts.getTries() + " left.");
            System.out.println("Input a letter: ");

            return scanner.next().charAt(0);
        }
}
