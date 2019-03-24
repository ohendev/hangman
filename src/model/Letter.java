package model;

public class Letter {

    private char letter;
    private boolean guessed;

    public Letter(char letter, boolean guessed) {
        this.letter = letter;
        this.guessed = guessed;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    @Override
    public String toString() {
        String toString = " ";
        if(isGuessed()) {
            toString += this.letter;
        } else {
            toString += "_";
        }
        return toString;
    }
}
