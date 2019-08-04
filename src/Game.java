public class Game {

    private String word;
    private int wrongGuesses = 0;
    private int filledSlots = 0;
    private String[] slots;
    private boolean gameInSession = true;
    private boolean isWon = false;
    private boolean isLost = false;

    public Game() {
        this.word = Words.randomWord();
        slots = new String[word.length()];
        fillSlots();
    }

    // player has 6 attempts before the hangman is complete and they lose
    public void printHangman() {
        switch(wrongGuesses) {
            case 0:
                System.out.println("   _________");
                System.out.println("   |         |");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                break;
            case 1:
                System.out.println("   _________");
                System.out.println("   |         |");
                System.out.println("   |         0");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                break;
            case 2:
                System.out.println("   _________");
                System.out.println("   |         |");
                System.out.println("   |         0");
                System.out.println("   |        /");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                break;
            case 3:
                System.out.println("   _________");
                System.out.println("   |         |");
                System.out.println("   |         0");
                System.out.println("   |        /|");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                break;
            case 4:
                System.out.println("   _________");
                System.out.println("   |         |");
                System.out.println("   |         0");
                System.out.println("   |        /|\\");
                System.out.println("   | ");
                System.out.println("   | ");
                System.out.println("   | ");
                break;
            case 5:
                System.out.println("   _________");
                System.out.println("   |         |");
                System.out.println("   |         0");
                System.out.println("   |        /|\\");
                System.out.println("   |        /");
                System.out.println("   | ");
                System.out.println("   | ");
                break;
            case 6:
                System.out.println("   _________");
                System.out.println("   |         |");
                System.out.println("   |         0");
                System.out.println("   |        /|\\");
                System.out.println("   |        / \\");
                System.out.println("   | ");
                System.out.println("   | ");
                break;
            default:
                System.out.println("Somehow couldn't print the hangman... (if you see this, you're screwed!)");
        }
    }

    private void fillSlots() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = "_";
        }
    }

    private void fillAllSlots() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = word.substring(i, i + 1);
        }
    }

    public void getInput(String input) {
        int foundLetters = 0;
        input = input.toLowerCase();
        if (input.length() == 1 && !(isLetterAlreadyIn(input))) {
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals(input)) {
                    slots[i] = input;
                    foundLetters++;
                    filledSlots++;
                }
            }
            if (foundLetters == 0) {
                System.out.println("Ouch, there's no results for " + input + "!");
                wrongGuesses++;
                if (wrongGuesses == 6) {
                    isLost = true;
                }
            } else {
                System.out.println("Found " + foundLetters + " slots for " + input + ".");
            }
        }
        else if (input.length() == 1 && isLetterAlreadyIn(input)) {
            System.out.println("You have already entered this letter!");
        }
        else if (input.length() > 1 && input.contains("-g") && input.substring(0, 2).equals("-g")) {
            if (input.substring(3).equals(word)) {
                fillAllSlots();
                isWon = true;
            } else {
                System.out.println("Ouch, you didn't guess the correct word.");
                wrongGuesses++;
                if (wrongGuesses == 6) {
                    isLost = true;
                }
            }
        }
        else {
            System.out.println("Invalid input. Try again.");
        }
        checkForEnd();
    }

    private boolean isLetterAlreadyIn(String letter) {
         for (int i = 0; i < slots.length; i++) {
             //System.out.println(slots[i] + "==" + letter);
             if (slots[i].equals(letter)) {
                 return true;
             }
         }
         return false;
    }

    private void checkForEnd() {
        if (isWon || filledSlots == word.length()) {
            gameInSession = false;
            printHangman();
            System.out.println("");
            printSlots();
            System.out.println("\nYou won! The word was " + word + ".");
        } else if (isLost) {
            gameInSession = false;
            printHangman();
            System.out.println("");
            printSlots();
            System.out.println("\nYou lost! The word was " + word + ". Better luck next time.");
        }
    }

    public void printSlots() {
        for (String i : slots) {
            System.out.print(i + " ");
        }
    }

    public boolean isGameInSession() {
        return gameInSession;
    }

}
