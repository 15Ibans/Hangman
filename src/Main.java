import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game g = new Game();
        Scanner s = new Scanner(System.in);
        while (g.isGameInSession()) {
            g.printHangman();
            System.out.println("");
            g.printSlots();
            System.out.print("\nGuess a letter or guess the word by typing -g <word here>: ");
            g.getInput(s.nextLine());
        }
    }

}
