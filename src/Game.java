public class Game {

    private String word;
    private int wrongGuesses = 0;
    private int filledSlots = 0;
    private String[] slots;
    private static boolean isWon = false;
    private static boolean isLost = false;

    public Game() {
        this.word = Words.randomWord();
        slots = new String[word.length()];
        fillSlots(word.length());
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

    private void fillSlots(int wordLength) {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = "_";
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
            } else {
                System.out.println("Found " + foundLetters + " slots for " + input + ".");
            }
        }
        else if (input.length() == 1 && isLetterAlreadyIn(input)) {
            System.out.println("You have already entered this letter!");
        }
        else if (input.length() > 1 && input.contains("-g") && input.substring(0, 2).equals("-g")) {
            if (input.substring(3).equals(word)) {
                isWon = true;
            }
        }
        checkForWin();
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

    private void checkForWin() {
        if (isWon || filledSlots == word.length()) {
            isWon = true;
            System.out.println("You won!");
        }
    }

    public void printSlots() {
        for (String i : slots) {
            System.out.print(i + " ");
        }
    }

    public boolean isWon() {
        return isWon;
    }

}
