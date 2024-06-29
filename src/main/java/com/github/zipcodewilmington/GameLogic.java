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
            While(true){
                callWord();

                do {
                    char letter = input;
                    scanner.nextLine();
                    matchLetter(letter);
                }
                while (!attempts.noMoreAttempts() && !wordGuessed());

            }
        }

        private void callWord() {
            callCurrentWord();
            callRealWorld();
        }

        private void callCurrentWord() {
            Random rand = new Random();
            int wordList = words.length;
            realWord = words[rand.nextInt(wordList)];
        }

        private void callRealWorld() {
            int wordLength = currentWord.length();
            realWord = "";
            for (int i = 0; i < wordLength; i++) {
                realWord += "_";
            }
        }

        private

}
