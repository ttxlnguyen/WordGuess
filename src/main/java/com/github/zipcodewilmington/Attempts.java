package com.github.zipcodewilmington;

public class Attempts {
    private int tries = 5;

    public int tries() {
        return tries;
    }

    public void deductAttempts() {
        tries--;
    }

    public boolean noMoreAttempts() {
        return tries == 0;
    }
}
