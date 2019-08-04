import java.util.Random;

public class Words {

    private static final String[] BANK = {"bear", "animal", "switch", "java", "phone", "samsung", "laptop", "computer", "screen", "shoe", "sandal", "refrigerator", "goose", "duck", "squirrel", "mattress", "bed", "floor", "shirt", "pants", "book", "exam", "university", "pamphlet", "umbrella", "intelligence", "program", "programming", "math", "calculus", "shampoo", "earth", "door", "car"};

    public static String randomWord() {
        Random r = new Random();
        return BANK[r.nextInt(BANK.length)];
    }
}
